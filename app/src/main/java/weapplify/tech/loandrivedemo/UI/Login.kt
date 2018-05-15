package weapplify.tech.loandrivedemo.UI

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

import weapplify.tech.loandrivedemo.R

class Login : AppCompatActivity() {

   lateinit var context: Context
    lateinit  var activity: Activity
    lateinit var leusername: EditText
    lateinit var lepassword: EditText
     var lsname: String?="null"
     var lspass: String?="null"
  var lsdevice: String? = null
    lateinit var lblogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        title = "Login"
        lblogin = findViewById(R.id.cbLogin) as Button
        leusername = findViewById(R.id.etUserName) as EditText
        lepassword = findViewById(R.id.etPassword) as EditText



        context = this
        activity = this

        lblogin.setOnClickListener {
            lsname = leusername.text.toString().trim()
            lspass = lepassword.text.toString().trim ()
            if (lsname == "legal" || lsname == "Legal" || lsname == "LEGAL") {
                val i = Intent(this@Login, LegalHome::class.java)
                startActivity(i)

            } else if (lsname == "dsa" || lsname == "Dsa" || lsname == "DSA") {
                val i = Intent(this@Login, Home::class.java)
                startActivity(i)
                // finish();
            } else if (lsname == "valuer" || lsname == "Valuer" || lsname == "VALUER") {
                val i = Intent(this@Login, Valuation::class.java)
                startActivity(i)
            }
        }
        saveuser()


    }

    fun saveuser() {
        val sharedPreferences = context.getSharedPreferences("USER", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("NAME", lsname)
        editor.putString("PASSWORD", lspass)
        editor.putString("DEVICE", lsdevice)
        editor.commit()
    }
}
