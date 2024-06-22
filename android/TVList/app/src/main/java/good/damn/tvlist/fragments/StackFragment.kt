package good.damn.tvlist.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import good.damn.tvlist.App
import good.damn.tvlist.activities.MainActivity

abstract class StackFragment
: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val context = context
            ?: return null

        val v = onCreateView(
            context,
            App.WIDTH
        )

        return v
    }

    fun pushFragment(
        fragment: StackFragment,
        withAnimation: Boolean = false
    ) {
        mainActivity().pushFragment(
            fragment,
            withAnimation
        )
    }

    fun replaceFragment(
        fragment: StackFragment,
        withAnimation: Boolean = false
    ) {
        mainActivity().replaceFragment(
            this,
            fragment,
            withAnimation
        )
    }

    fun popFragment(
        withAnimation: Boolean = false
    ) {
        mainActivity().popFragment(
            withAnimation
        )
    }

    abstract fun onCreateView(
        context: Context,
        measureUnit: Int
    ): View

    abstract fun onInAnimation(
        v: Float
    )

    abstract fun onOutAnimation(
        v: Float
    )
}

private fun StackFragment.mainActivity(): MainActivity {
    return activity as MainActivity
}