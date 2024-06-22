package good.damn.tvlist.activities

import android.animation.Animator
import android.animation.ValueAnimator
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.OvershootInterpolator
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import good.damn.tvlist.App
import good.damn.tvlist.animators.FragmentAnimator
import good.damn.tvlist.extensions.generateId
import good.damn.tvlist.fragments.StackFragment
import good.damn.tvlist.fragments.ui.SplashFragment
import good.damn.tvlist.fragments.ui.TVListFragment
import good.damn.tvlist.navigators.MainFragmentNavigator
import java.util.LinkedList

class MainActivity
: AppCompatActivity() {

    private lateinit var mNavigator: MainFragmentNavigator<StackFragment>
    private lateinit var mContainer: FrameLayout

    private val mAnimator = FragmentAnimator()

    override fun onCreate(
        savedInstanceState: Bundle?
    ) {
        super.onCreate(savedInstanceState)
        val context = this

        mAnimator.duration = 350
        mAnimator.interpolator = AccelerateDecelerateInterpolator()
        mAnimator.setFloatValues(
            0.0f,1.0f
        )


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
                splash,
                true
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

        if (withAnimation) {
            mAnimator.startTransition(
                inFragment = fragment
            )
        }
    }

    fun popFragment(
        withAnimation: Boolean = false
    ) {
        if (withAnimation) {
            mAnimator.onAnimationEnd = {
                mNavigator.popFragment()
            }
            mAnimator.startTransition(
                outFragment = mNavigator.topFragment
            )
            return
        }
        mNavigator.popFragment()
    }

    fun replaceFragment(
        base: StackFragment,
        on: StackFragment,
        withAnimation: Boolean = false
    ) {
        if (withAnimation) {
            pushFragment(
                on
            )
            mAnimator.onAnimationEnd = {
                mNavigator.removeFragment(
                    mNavigator.size - 2
                )
            }
            mAnimator.startTransition(
                on,
                base
            )
            return
        }

        popFragment()

        pushFragment(
            on
        )
    }


}