package good.damn.tvlist.navigators

import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import good.damn.tvlist.fragments.StackFragment
import java.util.LinkedList

class MainFragmentNavigator<FRAGMENT: Fragment>(
    private val mFragmentManager: FragmentManager,
    private val mContainer: FrameLayout
) {

    var topFragment: FRAGMENT? = null
        get() = mFragments.last

    private val mFragments = LinkedList<FRAGMENT>()


    fun pushFragment(
        fragment: FRAGMENT
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
        fragment: FRAGMENT
    ) {
        mFragments.removeLast()
        mFragmentManager
            .beginTransaction()
            .remove(
                fragment
            ).commit()
    }
}