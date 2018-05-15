package weapplify.tech.loandrivedemo.UI

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.support.annotation.RequiresApi
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast

import java.text.SimpleDateFormat
import java.util.Date

import weapplify.tech.loandrivedemo.R
import weapplify.tech.loandrivedemo.Services.CalendarView
import weapplify.tech.loandrivedemo.Services.CalendarView.CVOnDateChanged
import weapplify.tech.loandrivedemo.Services.Debugger
import weapplify.tech.loandrivedemo.Upgrade.App
import weapplify.tech.loandrivedemo.Upgrade.BaseActivity


class LoanApplication : BaseActivity() {

override    lateinit var context: Context
    override  lateinit var activity: Activity
    //PersonalDetails
    lateinit var etName: EditText
    lateinit var etNoofchildren: EditText
    lateinit var spMaritalstatus: Spinner
    lateinit var spRstatus: Spinner
    lateinit var spOccupation: Spinner
    lateinit var tvResidentialadd: TextView
    lateinit var tvAddlabel: TextView
    lateinit var llPersonaldetails: LinearLayout
    lateinit var llNofchilds: LinearLayout

    lateinit var lsName: String
    lateinit var lsBdate: String
    lateinit var lsNoofchildren: String
    lateinit var lsMstatus: String
    lateinit var lsRstatus: String
    lateinit var lsResidentialadd: String
     var liNoofchildren: Int = 0
    //PersonalDetails

    //KYCDetails
    lateinit var etMobileNo: EditText
    lateinit var etPanNo: EditText
    lateinit var etPassport: EditText
    lateinit var etUid: EditText
    lateinit var etVoterid: EditText
    lateinit var etBdate: EditText
    lateinit var etEmailid: EditText
    lateinit var llKycdetails: LinearLayout
    lateinit var ivBdate: ImageView
    lateinit var lsMobileNo: String
    lateinit var lsPanNo: String
    lateinit var lsPassport: String
    lateinit var lsUid: String
    lateinit var lsVoterid: String
    lateinit var lsEmailid: String
    //KYCDetails

    //IncomeDetailsSalaried
    lateinit var llIncomedetailsSalaried: LinearLayout
    lateinit var etOther: EditText
    lateinit var etDesignation: EditText
    lateinit var etNettakehomesalary: EditText
    lateinit var spEmployerName: Spinner
    lateinit var spIndustry: Spinner
    lateinit var lsOther: String
    lateinit var lsDesignation: String
    lateinit var lsNettakehomesalary: String
    lateinit var lsEmployername: String
    lateinit var lsIndustry: String
     var liNettakehomesalary: Int = 0
    //IncomeDetailsSalaried

    //IncomeDetailsSelfEmployed
    lateinit var llIncomedetailsSelfEmployed: LinearLayout
    lateinit var etFirmname: EditText
    lateinit var etNoofYerasinBusiness: EditText
    lateinit var spEntitytype: Spinner
    lateinit var spNatureofBusiness: Spinner
    lateinit var spIncometoconsider: Spinner
    lateinit var lsFirmname: String
    lateinit var lsNoofYerasinBusiness: String
    lateinit var lsEntitytype: String
    lateinit var lsNatureofBusiness: String
    lateinit var lsIncometoconsider: String
    //IncomeDetailsSelfEmployed


    //Tabicons
    lateinit var ivPdetailsicon: ImageView
    lateinit var ivIdetailsicon: ImageView
    lateinit var ivKdetailsicon: ImageView
    //Tabicons


    //localStrings
     var lcompleteaddress: String?=""
    lateinit var kMyId: String
     var occupation: String?=""
    //localStrings

    //localImages
     var ivbtnfloat: ImageView? = null
    //localImages

    //Button
     var cbpreview: Button? = null
    lateinit var cbsavennext: Button
     var cbsave: Button? = null
    //Button

    lateinit var scroll: ScrollView

    lateinit var haddress: SharedPreferences
    lateinit var haddress1: SharedPreferences

    @RequiresApi(api = Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loan_application)
        title = "Application"
        showbottomnavigation(false)
        context = this
        activity = this


        haddress = getSharedPreferences(App.MyPreferences, Context.MODE_PRIVATE)
        haddress1 = getSharedPreferences("kMyId", Context.MODE_PRIVATE)
        occupation = intent.getStringExtra(OCCUPATION)


        if (haddress.getString("completeadd", "") != null) {
            val editor = haddress.edit()
            editor.clear()
            editor.commit()
        }

        if (haddress1.getString("completeadd", "") != null) {
            val editor = haddress1.edit()
            editor.clear()
            editor.commit()
        }

        if (haddress.getString("completeadd", "") == null) {
            Log.d("tag", "pref is clear")
        }


        initlayput()

        //Default
        llPersonaldetails.visibility = View.VISIBLE
        ivPdetailsicon.background = getDrawable(R.drawable.tabselected)
        llKycdetails.visibility = View.GONE
        llIncomedetailsSalaried.visibility = View.GONE
        llIncomedetailsSelfEmployed.visibility = View.GONE
        //Default

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    fun initlayput() {

        //PersonalDetails
        etName = findViewById(R.id.etName) as EditText

        etNoofchildren = findViewById(R.id.etNochilds) as EditText
        spMaritalstatus = findViewById(R.id.spMstatus) as Spinner
        spRstatus = findViewById(R.id.spRstatus) as Spinner
        tvResidentialadd = findViewById(R.id.tvResidenceaddress) as TextView
        tvAddlabel = findViewById(R.id.tvAddlabel) as TextView
        llPersonaldetails = findViewById(R.id.llPersonaldetails) as LinearLayout
        llNofchilds = findViewById(R.id.llNofchilds) as LinearLayout
        spOccupation = findViewById(R.id.spOccupation) as Spinner

        //PersonalDetails

        //KYCDetails
        etMobileNo = findViewById(R.id.etMobileNo) as EditText
        etPanNo = findViewById(R.id.etPanNo) as EditText
        etPassport = findViewById(R.id.etPassport) as EditText
        etUid = findViewById(R.id.etUid) as EditText
        etVoterid = findViewById(R.id.etVoterid) as EditText
        etBdate = findViewById(R.id.etBdate) as EditText
        etBdate.setOnClickListener(this)
        etEmailid = findViewById(R.id.etEmailid) as EditText
        ivBdate = findViewById(R.id.ivBdate) as ImageView
        ivBdate.setOnClickListener(this)

        llKycdetails = findViewById(R.id.llKycdetails) as LinearLayout
        //KYCDetails

        //IncomeDetailsSalaried
        llIncomedetailsSalaried = findViewById(R.id.llIncomedetailsSalaried) as LinearLayout
        etOther = findViewById(R.id.etOther) as EditText
        etDesignation = findViewById(R.id.etDesignation) as EditText
        etNettakehomesalary = findViewById(R.id.etNettakehomesalary) as EditText
        spEmployerName = findViewById(R.id.spEmployerName) as Spinner
        spIndustry = findViewById(R.id.spIndustry) as Spinner
        //IncomeDetailsSalaried

        //IncomeDetailsSelfEmployed
        llIncomedetailsSelfEmployed = findViewById(R.id.llIncomedetailsSelfEmployed) as LinearLayout
        llIncomedetailsSelfEmployed.visibility = View.GONE
        etFirmname = findViewById(R.id.etFirmname) as EditText
        etNoofYerasinBusiness = findViewById(R.id.etNoofYerasinBusiness) as EditText
        spEntitytype = findViewById(R.id.spEntitytype) as Spinner
        spNatureofBusiness = findViewById(R.id.spNatureofBusiness) as Spinner
        spIncometoconsider = findViewById(R.id.spIncometoconsider) as Spinner
        //IncomeDetailsSelfEmployed

        //Tabicons
        ivPdetailsicon = findViewById(R.id.ivPdetailsicon) as ImageView
        ivIdetailsicon = findViewById(R.id.ivIdetailsicon) as ImageView
        ivKdetailsicon = findViewById(R.id.ivKdetailsicon) as ImageView

        ivPdetailsicon.setOnClickListener(this)
        ivIdetailsicon.setOnClickListener(this)
        ivKdetailsicon.setOnClickListener(this)
        //Tabicons


        scroll = findViewById(R.id.scrollview) as ScrollView


        lcompleteaddress = intent.getStringExtra("comadd")
        Log.d("Tag", "Comadd$lcompleteaddress")
        tvResidentialadd.setOnClickListener(this)
        //  ivbtnfloat = (ImageView) findViewById(R.id.btnfloat);
        /*ivbtnfloat.setVisibility(View.VISIBLE);
        ivbtnfloat.setOnClickListener(this);*/


        // cbpreview = (Button) findViewById(R.id.cbpreview);
        //cbpreview.setOnClickListener(this);
        cbsavennext = findViewById(R.id.cbnext) as Button
        cbsavennext.setOnClickListener(this)
        /* cbsave = (Button) findViewById(R.id.cbsave);
        cbsave.setOnClickListener(this);*/


        //MaritalStatus
        spMaritalstatus.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                lsMstatus = spMaritalstatus.selectedItem.toString()
                if (lsMstatus == "Single") {
                    llNofchilds.visibility = View.GONE
                } else {
                    llNofchilds.visibility = View.VISIBLE

                }

                Log.d("tag", "Status:$lsMstatus")
            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }


    }

    fun buttonoprations() {

        if (llPersonaldetails.visibility == View.VISIBLE) {
            lsName = etName.text.toString()
            lsBdate = etBdate.text.toString()
            lsResidentialadd = tvResidentialadd.text.toString()
            lsMstatus = spMaritalstatus.selectedItem.toString()
            lsNoofchildren = etNoofchildren.text.toString()
            liNoofchildren = Integer.parseInt(lsNoofchildren)
            lsRstatus = spRstatus.selectedItem.toString()
            val editor = haddress.edit()
            editor.clear()
            editor.commit()


        } else if (llIncomedetailsSalaried.visibility == View.VISIBLE) {
            lsEmployername = spEmployerName.selectedItem.toString()
            lsOther = etOther.text.toString()
            lsIndustry = spIndustry.selectedItem.toString()
            lsDesignation = etDesignation.text.toString()
            lsNettakehomesalary = etNettakehomesalary.text.toString()
            liNettakehomesalary = Integer.parseInt(lsNettakehomesalary)
            /* SharedPreferences.Editor editor=haddress.edit();
            editor.clear();
            editor.commit();*/
        } else if (llKycdetails.visibility == View.VISIBLE) {
            lsMobileNo = etMobileNo.text.toString()
            lsPanNo = etPanNo.text.toString()
            lsPassport = etPassport.text.toString()
            lsUid = etUid.text.toString()
            lsVoterid = etVoterid.text.toString()
            lsEmailid = etEmailid.text.toString()
        } else if (llIncomedetailsSelfEmployed.visibility == View.VISIBLE) {

            lsFirmname = etFirmname.text.toString()
            lsEntitytype = spEntitytype.selectedItem.toString()
            lsNatureofBusiness = spNatureofBusiness.selectedItem.toString()
            lsNoofYerasinBusiness = etNoofYerasinBusiness.text.toString()
            lsIncometoconsider = spIncometoconsider.selectedItem.toString()
        }


    }

    override fun onClick(v: View) {
        super.onClick(v)

        when (v.id) {
            R.id.ivBdate, R.id.etBdate ->

                setUpDate(etBdate)

        /*case R.id.cbpreview:
                sendtopreview();
                break;*/

            R.id.ivPdetailsicon -> {
                occupation = spOccupation.selectedItem.toString().trim()
                showPdetails()
            }

            R.id.ivIdetailsicon -> {
                occupation = spOccupation.selectedItem.toString().trim()
                showIdetails()
            }

            R.id.ivKdetailsicon -> {
                occupation = spOccupation.selectedItem.toString().trim()
                showKdetails()
            }


            R.id.tvResidenceaddress -> {
                kMyId = "1"
                redirectaddress(1, kMyId)
            }
        /* case R.id.coresidenceaddress:
                kMyId = "2";
                redirectaddress(2,kMyId);
                break;*/
        /*  case R.id.empaddress:
                kMyId = "3";
                redirectaddress(3,kMyId);
                break;*/
        /* case R.id.coempaddress:
                kMyId = "4";
               redirectaddress(4,kMyId);
                break;*/
            R.id.cbnext -> {
            }
        }// startActivity(address);
        // buttonoprations();


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_RESIDENCE && resultCode == Activity.RESULT_OK) {
            val flag = data.getIntExtra("flag", 0)
            val cAddress = data.getStringExtra("comadd")
            if (llPersonaldetails.visibility == View.VISIBLE) {
                tvAddlabel.visibility = View.VISIBLE
                tvResidentialadd.setTextColor(resources.getColor(R.color.black))
                tvResidentialadd.text = cAddress
            }

        } else {
            Toast.makeText(context, "Major Error", Toast.LENGTH_SHORT).show()
        }
    }

    fun setUpDate(etDate: EditText) {
        val calendarPop = CalendarView(activity, context, true)
        var lsDate: String? = etDate.text.toString()
        if (lsDate == null || lsDate == "") {
            val sdf = SimpleDateFormat("dd/MM/yyyy")
            lsDate = sdf.format(Date()).toString()
        }

      /*  val mOnDateChanged = CVOnDateChanged { tvDate, lsDate ->
            Debugger.debug("TAG", "DAte selected is $lsDate")
            etDate.setText(lsDate)
        }
        calendarPop.setOnDateChanged(mOnDateChanged)
        calendarPop.setupPopUpdate(etDate, lsDate)*/
    }

    fun redirectaddress(key: Int, kMyId: String) {
        val coempaddress = Intent(context, EnterAddress::class.java)
        coempaddress.putExtra("address", key)
        coempaddress.putExtra("kMyId", kMyId)
        startActivityForResult(coempaddress, REQUEST_RESIDENCE)
    }

    fun sendtopreview() {

        val editor = haddress1.edit()
        editor.clear()
        editor.commit()

        val preview = Intent(context, ApplicationPreview::class.java)
        /* preview.putExtra("name",lsname);
        preview.putExtra("dob",lsbdate);
        preview.putExtra("resadd",lsaddress);
        preview.putExtra("mstatus",lsstatus);
        preview.putExtra("noofchild",lsnochild);
        preview.putExtra("occupation",lsoccupation);
        preview.putExtra("empname",lsemployername);
        preview.putExtra("empadd",lsempaddress);
        preview.putExtra("grosssal",grosssal);
        preview.putExtra("montlysal",monthlysal);*/

        startActivity(preview)

    }

    fun showPdetails() {
        llKycdetails.visibility = View.GONE
        llPersonaldetails.visibility = View.VISIBLE
        hideIncomType()
        ivPdetailsicon.background = getDrawable(R.drawable.tabselected)
        ivKdetailsicon.background = getDrawable(R.drawable.tabbg)
        ivIdetailsicon.background = getDrawable(R.drawable.tabbg)
        cbsavennext.text = "save and next"


    }

    private fun showIdetails() {
        showIncomeType(occupation!!)
        llKycdetails.visibility = View.GONE
        llPersonaldetails.visibility = View.GONE
        ivPdetailsicon.background = getDrawable(R.drawable.tabbg)
        ivKdetailsicon.background = getDrawable(R.drawable.tabbg)
        ivIdetailsicon.background = getDrawable(R.drawable.tabselected)
        cbsavennext.text = "Submit"

    }

    private fun showKdetails() {
        hideIncomType()
        llPersonaldetails.visibility = View.GONE
        llKycdetails.visibility = View.VISIBLE
        ivPdetailsicon.background = getDrawable(R.drawable.tabbg)
        ivKdetailsicon.background = getDrawable(R.drawable.tabselected)
        ivIdetailsicon.background = getDrawable(R.drawable.tabbg)
        cbsavennext.text = "save and next"


    }

    fun showIncomeType(occupation: String) {
        if (occupation == SALARIED) {

            llIncomedetailsSalaried.visibility = View.VISIBLE
            llIncomedetailsSelfEmployed.visibility = View.GONE
        } else if (occupation == SELFEMPLOYED) {
            llIncomedetailsSalaried.visibility = View.GONE
            llIncomedetailsSelfEmployed.visibility = View.VISIBLE

        }
    }

    fun hideIncomType() {
        if (llIncomedetailsSalaried.visibility == View.VISIBLE) {
            llIncomedetailsSalaried.visibility = View.GONE
        } else if (llIncomedetailsSelfEmployed.visibility == View.VISIBLE) {
            llIncomedetailsSelfEmployed.visibility = View.GONE
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val i = Intent(context, Home::class.java)
        startActivity(i)
    }

    companion object {
        val SALARIED = "Salaried"
        val SELFEMPLOYED = "Self Employed"
        val OCCUPATION = "occupation"


        private val REQUEST_RESIDENCE = 100
    }
}
