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
import weapplify.tech.loandrivedemo.Upgrade.App
import weapplify.tech.loandrivedemo.Upgrade.BaseActivity

class EnterAddress : BaseActivity() {
    override lateinit var context: Context
    override lateinit  var activity: Activity
    lateinit  var etaddressline1: EditText
    lateinit  var etaddressline2: EditText
    lateinit  var etcity: EditText
    lateinit  var etpincode: EditText
    lateinit  var etstate: EditText
    lateinit  var btnsave: Button
      var identity: Int = 0
    lateinit  var holdaddress: SharedPreferences
    lateinit  var holdaddress1: SharedPreferences
    lateinit  var lladdress1: String
    lateinit  var lladdress2: String
    lateinit  var llcity: String
    lateinit  var llpincode: String
    lateinit  var llstate: String
    lateinit  var llcompleteaddress: String
    internal var holdadd1: String? = null
    internal var holdadd2: String? = null
    internal var holdcity: String? = null
    internal var holdpin: String? = null
    internal var holdstate: String? = null
    internal var holdcomplete: String? = null
    lateinit  var kMyId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter_address)
        title = "Address"
        showbottomnavigation(false)
        identity = intent.getIntExtra("address", 0)
        kMyId = intent.getStringExtra("kMyId")
        context = this
        activity = this
        holdaddress = getSharedPreferences(App.MyPreferences, Context.MODE_PRIVATE)
        holdaddress1 = getSharedPreferences("kMyId", Context.MODE_PRIVATE)

        initlayout()


        if (kMyId == "1" || kMyId == "2" || kMyId == "3") {
            holddata()
        } else if (kMyId == "4") {
            holddata1()
        }
    }

    fun initlayout() {
        etaddressline1 = findViewById(R.id.etaddressline1) as EditText
        etaddressline2 = findViewById(R.id.etaddressline2) as EditText
        etcity = findViewById(R.id.etcity) as EditText
        etpincode = findViewById(R.id.etpincode) as EditText
        etstate = findViewById(R.id.etstate) as EditText


        btnsave = findViewById(R.id.cbsave) as Button
        btnsave.setOnClickListener(this)
        /*
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                lladdress1=etaddressline1.getText().toString().trim();
                lladdress2=etaddressline2.getText().toString().trim();
                llcity=etcity.getText().toString().trim();
                llpincode=etpincode.getText().toString().trim();
                llstate=etstate.getText().toString().trim();
                llcompleteaddress=lladdress1+","+lladdress2+","+llcity+","+llpincode+","+llstate;
                savedata();
                Intent showaddress= new Intent();
                showaddress.putExtra("flag",identity);
                showaddress.putExtra("comadd",llcompleteaddress);
                setResult(RESULT_OK,showaddress);
                finish();

            }
        });
*/


    }

    override fun onClick(v: View) {
        super.onClick(v)
        when (v.id) {

            R.id.cbsave -> {
                lladdress1 = etaddressline1.text.toString().trim { it <= ' ' }
                lladdress2 = etaddressline2.text.toString().trim { it <= ' ' }
                llcity = etcity.text.toString().trim { it <= ' ' }
                llpincode = etpincode.text.toString().trim { it <= ' ' }
                llstate = etstate.text.toString().trim { it <= ' ' }
                llcompleteaddress = "$lladdress1,$lladdress2,$llcity,$llpincode,$llstate"
                if (kMyId == "1" || kMyId == "2" || kMyId == "3") {
                    savedata()
                } else if (kMyId == "4") {
                    saveData1()
                }
                val showaddress = Intent()
                showaddress.putExtra("flag", identity)
                showaddress.putExtra("comadd", llcompleteaddress)
                setResult(Activity.RESULT_OK, showaddress)
                finish()
            }
        }
    }


    fun savedata() {

        val editor = holdaddress.edit()
        editor.putString("address1", lladdress1)
        editor.putString("address2", lladdress2)
        editor.putString("city", llcity)
        editor.putString("pincode", llpincode)
        editor.putString("state", llstate)
        editor.putString("completeadd", llcompleteaddress)
        editor.commit()

    }

    fun saveData1() {
        val editor1 = holdaddress1.edit()
        editor1.putString("address1", lladdress1)
        editor1.putString("address2", lladdress2)
        editor1.putString("city", llcity)
        editor1.putString("pincode", llpincode)
        editor1.putString("state", llstate)
        editor1.putString("completeadd", llcompleteaddress)
        editor1.commit()

    }

    fun holddata() {


        holdadd1 = holdaddress.getString("address1", "")
        holdadd2 = holdaddress.getString("address2", "")
        holdcity = holdaddress.getString("city", "")
        holdpin = holdaddress.getString("pincode", "")
        holdstate = holdaddress.getString("state", "")
        holdcomplete = holdaddress.getString("completeadd", "")
        etaddressline1.setText(holdadd1)
        etaddressline2.setText(holdadd2)
        etcity.setText(holdcity)
        etpincode.setText(holdpin)
        etstate.setText(holdstate)
    }

    fun holddata1() {


        holdadd1 = holdaddress1.getString("address1", "")
        holdadd2 = holdaddress1.getString("address2", "")
        holdcity = holdaddress1.getString("city", "")
        holdpin = holdaddress1.getString("pincode", "")
        holdstate = holdaddress1.getString("state", "")
        holdcomplete = holdaddress1.getString("completeadd", "")
        etaddressline1.setText(holdadd1)
        etaddressline2.setText(holdadd2)
        etcity.setText(holdcity)
        etpincode.setText(holdpin)
        etstate.setText(holdstate)
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}
