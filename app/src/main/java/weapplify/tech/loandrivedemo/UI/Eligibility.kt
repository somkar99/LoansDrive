package weapplify.tech.loandrivedemo.UI

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import weapplify.tech.loandrivedemo.R
import weapplify.tech.loandrivedemo.Upgrade.BaseActivity

class Eligibility : BaseActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eligibility)
    }
}
