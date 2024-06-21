package good.damn.tvlist

import android.app.Application
import android.content.res.Resources
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.core.content.res.ResourcesCompat

class App
: Application() {

    companion object {

        lateinit var RESOURCES: Resources
        const val URL = "http://176.109.108.35"

        var WIDTH = 1
        var HEIGHT = 1

        @ColorInt
        fun color(
            @ColorRes id: Int
        ): Int {
            return ResourcesCompat.getColor(
                RESOURCES,
                id,
                null
            )
        }

    }

    override fun onCreate() {
        super.onCreate()

        RESOURCES = resources
    }
}