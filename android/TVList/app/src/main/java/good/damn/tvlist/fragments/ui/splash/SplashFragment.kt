package good.damn.tvlist.fragments.ui.splash

import android.content.Context
import android.view.Gravity
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import good.damn.tvlist.App
import good.damn.tvlist.R
import good.damn.tvlist.extensions.boundsFrame
import good.damn.tvlist.extensions.setBackgroundColorId
import good.damn.tvlist.extensions.setTextSizePx
import good.damn.tvlist.extensions.withAlpha
import good.damn.tvlist.fragments.StackFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class SplashFragment
: StackFragment() {

    override fun onCreateView(
        context: Context,
        measureUnit: Int
    ): View {

        val layout = FrameLayout(
            context
        )
        val textViewAppName = TextView(
            context
        )
        val textViewCompany = TextView(
            context
        )
        val textViewPowered = TextView(
            context
        )



        App.font(
            R.font.open_sans_extra_bold,
            context
        )?.let { extraBold ->
            textViewAppName.typeface = extraBold
            textViewCompany.typeface = extraBold
            textViewPowered.typeface = extraBold
        }


        // Text
        textViewAppName.isAllCaps = true
        textViewAppName.setText(
            R.string.app_name
        )
        textViewCompany.setText(
            R.string.limeX
        )
        textViewPowered.setText(
            R.string.powered
        )



        App.color(
            R.color.background
        ).let {
            layout.setBackgroundColor(
                it
            )
            navigationBarColor = it
            statusBarColor = it
        }

        App.color(
            R.color.accentColor
        ).let {
            textViewAppName.setTextColor(
                it
            )
            textViewCompany.setTextColor(
                it
            )
            textViewPowered.setTextColor(
                it.withAlpha(0.42f)
            )
        }


        // Text Size
        textViewAppName.setTextSizePx(
            measureUnit * 0.1111f
        )





        // Bounds
        textViewAppName.boundsFrame(
            Gravity.CENTER
        )


        layout.apply {
            addView(
                textViewAppName
            )
        }

        return layout
    }



}