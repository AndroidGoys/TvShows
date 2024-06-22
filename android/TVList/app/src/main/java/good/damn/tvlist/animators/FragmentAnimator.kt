package good.damn.tvlist.animators

import android.animation.Animator
import android.animation.ValueAnimator
import androidx.fragment.app.Fragment
import good.damn.tvlist.fragments.StackFragment

class FragmentAnimator
: ValueAnimator(),
ValueAnimator.AnimatorUpdateListener,
Animator.AnimatorListener {

    var onAnimationEnd: (()->Unit)? = null

    private var mInFragment: StackFragment? = null
    private var mOutFragment: StackFragment? = null

    init {
        setFloatValues(
            0.0f, 1.0f
        )
        addUpdateListener(
            this
        )

        addListener(
            this
        )
    }

    fun startTransition(
        inFragment: StackFragment? = null,
        outFragment: StackFragment? = null
    ) {
        mInFragment = inFragment
        mOutFragment = outFragment
        start()
    }

    override fun onAnimationUpdate(
        animation: ValueAnimator
    ) {
        val v = animation.animatedValue as Float
        mInFragment?.onInAnimation(
            v
        )
        mOutFragment?.onOutAnimation(
            v
        )
    }

    override fun onAnimationCancel(
        animation: Animator
    ) = Unit

    override fun onAnimationRepeat(
        animation: Animator
    ) = Unit

    override fun onAnimationStart(
        animation: Animator
    ) = Unit

    override fun onAnimationEnd(
        animation: Animator
    ) {
        onAnimationEnd?.invoke()
    }
}