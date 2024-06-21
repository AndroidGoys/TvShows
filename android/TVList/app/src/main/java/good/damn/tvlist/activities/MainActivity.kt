package good.damn.tvlist.activities

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import good.damn.tvlist.App
import good.damn.tvlist.extensions.generateId
import good.damn.tvlist.fragments.StackFragment
import good.damn.tvlist.fragments.ui.SplashFragment
import good.damn.tvlist.fragments.ui.TVListFragment
import java.util.LinkedList

class MainActivity
: AppCompatActivity() {

    private lateinit var mContainer: FrameLayout

    private val mFragments = LinkedList<StackFragment>()

    override fun onCreate(
        savedInstanceState: Bundle?
    ) {
        super.onCreate(savedInstanceState)

        val context = this

        mContainer = FrameLayout(
            context
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

    fun replaceFragment(
        base: StackFragment,
        with: StackFragment,
        withAnimation: Boolean = false
    ) {
        popFragment(
            base
        )
        pushFragment(
            with
        )
    }

    fun pushFragment(
        fragment: StackFragment,
        withAnimation: Boolean = false
    ) {
        mFragments.add(
            fragment
        )
        supportFragmentManager
            .beginTransaction()
            .add(
                mContainer.id,
                fragment
            ).commit()
    }

    fun popFragment(
        fragment: StackFragment
    ) {
        mFragments.removeLast()
        supportFragmentManager
            .beginTransaction()
            .remove(
                fragment
            ).commit()
    }

}