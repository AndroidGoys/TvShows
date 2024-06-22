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
import good.damn.tvlist.extensions.generateId
import good.damn.tvlist.fragments.StackFragment
import good.damn.tvlist.fragments.ui.SplashFragment
import good.damn.tvlist.fragments.ui.TVListFragment
import good.damn.tvlist.navigators.MainFragmentNavigator
import java.util.LinkedList

class MainActivity
: AppCompatActivity(),
ValueAnimator.AnimatorUpdateListener {

    private lateinit var mNavigator: MainFragmentNavigator<StackFragment>
    private lateinit var mContainer: FrameLayout

    private val mAnimator = ValueAnimator()

    override fun onCreate(
        savedInstanceState: Bundle?
    ) {
        super.onCreate(savedInstanceState)
        val context = this

        mAnimator.addUpdateListener(
            this
        )
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
        mAnimator.start()
    }

    fun popFragment(
        fragment: StackFragment,
        withAnimation: Boolean = false
    ) {
        mNavigator.popFragment(
            fragment
        )
        mAnimator.removeAllUpdateListeners()
        mAnimator.addUpdateListener(
            this::onUpdateAnimationPop
        )
        mAnimator.start()
    }

    fun replaceFragment(
        base: StackFragment,
        on: StackFragment,
        withAnimation: Boolean = false
    ) {
        mNavigator.pushFragment(
            on
        )
        mAnimator.removeAllListeners()
        mAnimator.addListener(object : Animator.AnimatorListener {
            override fun onAnimationCancel(animation: Animator) = Unit
            override fun onAnimationRepeat(animation: Animator) = Unit
            override fun onAnimationStart(animation: Animator) = Unit
            override fun onAnimationEnd(
                animation: Animator
            ) {
                mNavigator.popFragment(
                    base
                )
            }
        })
        mAnimator.start()
    }

    override fun onAnimationUpdate(
        animation: ValueAnimator
    ) {
        val v = animation.animatedValue as Float
        mNavigator
            .topFragment
            ?.onInAnimation(v)
    }

    private fun onUpdateAnimationPop(
        animator: ValueAnimator
    ) {

    }

}