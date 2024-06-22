package good.damn.tvlist.fragments.ui

import android.content.Context
import android.view.View
import android.widget.LinearLayout
import good.damn.tvlist.App
import good.damn.tvlist.fragments.StackFragment

class SplashFragment
: StackFragment() {

    override fun onCreateView(
        context: Context,
        measureUnit: Int
    ): View {
        val layout = LinearLayout(
            context
        )
        layout.y = App.HEIGHT.toFloat()

        layout.setBackgroundColor(
            0xff0000ff.toInt()
        )

        return layout
    }


    override fun onInAnimation(
        v: Float
    ) {
        view?.y = App.HEIGHT * (1.0f-v)
    }

    override fun onOutAnimation(
        v: Float
    ) {
        view?.alpha = 1.0f - v
    }

}