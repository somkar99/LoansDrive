package weapplify.tech.loandrivedemo.UI

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import weapplify.tech.loandrivedemo.R
import weapplify.tech.loandrivedemo.Upgrade.BaseActivity

class Completedrow : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_completedrow)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}
