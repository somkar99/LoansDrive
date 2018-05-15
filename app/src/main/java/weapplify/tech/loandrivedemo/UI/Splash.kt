package weapplify.tech.loandrivedemo.UI

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager

import weapplify.tech.loandrivedemo.R

import weapplify.tech.loandrivedemo.R.layout.activity_splash

class Splash : AppCompatActivity() {
    internal val handler = Handler()
    lateinit var context: Context
    lateinit var activity: Activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_splash)
        activity = this
        context = this
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        handler.postDelayed({
            val i = Intent(activity, Login::class.java)
            startActivity(i)
            finish()
        },
                4000)


    }
}
