package good.damn.tvlist.fragments.ui

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.LinearLayout
import good.damn.tvlist.fragments.StackFragment
import good.damn.tvlist.fragments.animation.FragmentAnimation

class TVListFragment
: StackFragment() {

    override fun onCreateView(
        context: Context,
        measureUnit: Int
    ): View {
        val layout = LinearLayout(
            context
        )

        layout.setBackgroundColor(
            0xffff0000.toInt()
        )

        layout.setOnClickListener {
            pushFragment(
                TVDetailsFragment(),
                withAnimation = FragmentAnimation {
                    f, fragment ->

                    fragment.view?.scaleX = f

                }
            )
        }

        return layout
    }
}