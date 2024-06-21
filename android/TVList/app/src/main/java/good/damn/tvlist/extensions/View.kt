package good.damn.tvlist.extensions

import android.view.View
import androidx.annotation.ColorRes
import good.damn.tvlist.App

fun View.generateId() {
    id = View.generateViewId()
}

fun View.setBackgroundColorId(
    @ColorRes id: Int
) {
    setBackgroundColor(
        App.color(
            id
        )
    )
}