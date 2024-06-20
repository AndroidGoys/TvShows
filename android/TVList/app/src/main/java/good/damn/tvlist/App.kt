package good.damn.tvlist

import android.app.Application
import android.content.res.Resources
import android.os.Looper
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.core.content.res.ResourcesCompat
import java.util.logging.Handler

class App
: Application() {

    companion object {

        lateinit var RESOURCES: Resources
        const val URL = "http://176.109.108.35"

        var WIDTH = 1
        var HEIGHT = 1


        private val HANDLER = android.os.Handler(
            Looper.getMainLooper()
        )

        fun ui(
            runnable: Runnable
        ) {
            HANDLER.post(runnable)
        }

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