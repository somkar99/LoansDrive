package weapplify.tech.loandrivedemo.UI

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import weapplify.tech.loandrivedemo.R
import weapplify.tech.loandrivedemo.Upgrade.BaseActivity

class EmiCalculater : BaseActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loanapplicationnogenerationform)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val i = Intent(applicationContext, Home::class.java)
        startActivity(i)
        finish()

    }
}
