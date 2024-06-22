package good.damn.tvlist.navigators

import android.widget.FrameLayout
import androidx.fragment.app.FragmentManager
import good.damn.tvlist.fragments.StackFragment
import java.util.LinkedList

class MainFragmentNavigator(
    private val mFragmentManager: FragmentManager,
    private val mContainer: FrameLayout
) {

    private val mFragments = LinkedList<StackFragment>()


    fun replaceFragment(
        base: StackFragment,
        with: StackFragment
    ) {
        popFragment(
            base
        )
        pushFragment(
            with
        )
    }

    fun pushFragment(
        fragment: StackFragment
    ) {
        mFragments.add(
            fragment
        )
        mFragmentManager
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
        mFragmentManager
            .beginTransaction()
            .remove(
                fragment
            ).commit()
    }
}