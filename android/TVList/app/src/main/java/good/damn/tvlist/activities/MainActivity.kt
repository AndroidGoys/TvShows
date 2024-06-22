package good.damn.tvlist.activities

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import good.damn.tvlist.App
import good.damn.tvlist.extensions.generateId
import good.damn.tvlist.fragments.StackFragment
import good.damn.tvlist.fragments.ui.SplashFragment
import good.damn.tvlist.fragments.ui.TVListFragment
import good.damn.tvlist.navigators.MainFragmentNavigator
import java.util.LinkedList

class MainActivity
: AppCompatActivity() {

    private lateinit var mNavigator: MainFragmentNavigator
    private lateinit var mContainer: FrameLayout

    override fun onCreate(
        savedInstanceState: Bundle?
    ) {
        super.onCreate(savedInstanceState)

        val context = this



        mContainer = FrameLayout(
            context
        )
        mNavigator = MainFragmentNavigator(
            supportFragmentManager,
            mContainer
        )




        mContainer.generateId()
        mContainer.post {
            App.WIDTH = mContainer.width
            App.HEIGHT = mContainer.height

            val splash = SplashFragment()
            pushFragment(
                splash
            )

            Handler(Looper.getMainLooper()).postDelayed(
                {
                    replaceFragment(
                        splash,
                        TVListFragment(),
                        true
                    )
                },
                3500
            )

        }

        setContentView(
            mContainer
        )
    }

    fun pushFragment(
        fragment: StackFragment,
        withAnimation: Boolean = false
    ) {
        mNavigator.pushFragment(
            fragment
        )
    }

    fun popFragment(
        fragment: StackFragment,
        withAnimation: Boolean = false
    ) {
        mNavigator.popFragment(
            fragment
        )
    }

    fun replaceFragment(
        base: StackFragment,
        on: StackFragment,
        withAnimation: Boolean = false
    ) {
        mNavigator.replaceFragment(
            base,
            on
        )
    }

}