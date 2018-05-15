package weapplify.tech.loandrivedemo.UI

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.loanapplicationnogenerationform.*
import weapplify.tech.loandrivedemo.R
import weapplify.tech.loandrivedemo.Upgrade.BaseActivity

class LoanApplicatioNumber : BaseActivity() {
    companion object {
        val OCCUPATION="occupation"
        val SELFEMPLOYED="Self Employed"
        val SALARIED="Salaried"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loanapplicationnogenerationform)
        showbottomnavigation(false)
        cbsubmit.setOnClickListener{
            val occupation= spOccupation.selectedItem.toString().trim()
            if (occupation.equals(SELFEMPLOYED)|| occupation.equals(SALARIED)){
            val intent = Intent(this, LoanApplication::class.java)
            intent.putExtra(OCCUPATION,occupation)
            startActivity(intent)
            }
            else
            {
                Toast.makeText(applicationContext,"Please Select Occupation",Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
      val intentback=Intent(this,Home::class.java)
        startActivity(intentback)
    }
}
