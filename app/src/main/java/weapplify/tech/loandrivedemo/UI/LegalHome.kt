package weapplify.tech.loandrivedemo.UI

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout

import weapplify.tech.loandrivedemo.R
import weapplify.tech.loandrivedemo.Upgrade.BaseActivity

class LegalHome : BaseActivity() {
    lateinit var llnew: LinearLayout
    lateinit var llcomplete: LinearLayout
    lateinit var llprocessing: LinearLayout
   override lateinit var context: Context


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.homeforlegal)
        context = this
        initlayout()
    }

    fun initlayout() {
        llnew = findViewById(R.id.llnew) as LinearLayout
        llprocessing = findViewById(R.id.llprocessing) as LinearLayout
        llcomplete = findViewById(R.id.llcomplete) as LinearLayout
        llnew.setOnClickListener {
            val new1 = Intent(context, Newassignment::class.java)
            startActivity(new1)
        }
        llprocessing.setOnClickListener {
            val new1 = Intent(context, PendingAssignment::class.java)
            startActivity(new1)
        }
        llcomplete.setOnClickListener {
            val new1 = Intent(context, Completedrow::class.java)
            startActivity(new1)
        }


    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()

    }
}
