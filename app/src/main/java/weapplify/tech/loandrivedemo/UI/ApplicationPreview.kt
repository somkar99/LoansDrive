package weapplify.tech.loandrivedemo.UI

import android.app.Activity
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView

import weapplify.tech.loandrivedemo.R
import weapplify.tech.loandrivedemo.Upgrade.BaseActivity

class ApplicationPreview : BaseActivity() {
    override  lateinit var context: Context
    override lateinit var activity: Activity
    lateinit var tvname: TextView
    lateinit var tvdob: TextView
    lateinit var tvadd: TextView
    lateinit var tvmstatus: TextView
    lateinit var tvnoofchild: TextView
    lateinit var tvoccupation: TextView
    lateinit var tvempname: TextView
    lateinit var tvempadd: TextView
    lateinit var tvgrosssal: TextView
    lateinit var tvmonthlysal: TextView
    lateinit var tvtypeofloan: TextView
    lateinit var tvpurpose: TextView
    lateinit var tvpropdetails: TextView
    lateinit var tvcostofland: TextView
    lateinit var tvcostofconst: TextView
    lateinit var tvloanreq: TextView
    lateinit var tvtenture: TextView
    lateinit var tvcostofprop: TextView
    lateinit var tvconame: TextView
    lateinit var tvcobdob: TextView
    lateinit var tvcobadd: TextView
    lateinit var tvcooccupation: TextView
    lateinit var tvcoempname: TextView
    lateinit var tvcoempadd: TextView
    lateinit var tvcogrosssal: TextView
    lateinit var tvcomonthlysal: TextView
    lateinit var tvlabelprop: TextView
    lateinit var tvlabelcoc: TextView
    lateinit var tvlabelcol: TextView

    lateinit var lsname: String
    lateinit var lsdob: String
    lateinit var lsaddress: String
    lateinit var lsmstatus: String
    lateinit var lsnoofchild: String
    lateinit var lsoccupation: String
    lateinit var lsmpname: String
    lateinit var lsempadd: String
    lateinit var lstypeofloan: String
    lateinit var lspurpose: String
    var lsprodetails: String? = null
    lateinit var lstenture: String
    lateinit var lscobname: String
    lateinit var lscobdob: String
    lateinit var lscobadd: String
    lateinit var lscoboccupation: String
    lateinit var lscobempname: String
    lateinit var lscoempadd: String
  var lsgrosssal: Double? = null
     var lsmonthlysal: Double? = null
    var lscostofland: Double? = null
     var lscostofconstruction: Double? = null
    var lsloanreq: Double? = null
     var lscostofprop: Double? = null
    var lscobgrosssal: Double? = null
    var lscobmonthly: Double? = null
    lateinit var lstrimaddress: String
    lateinit var lstrimcoempadd: String
    lateinit var lstrimcobadd: String
    lateinit var lstrimempadd: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_application_preview)
        title = "Preview"
        showbottomnavigation(false)
        context = this
        activity = this

        lsname = intent.getStringExtra("name")
        lsaddress = intent.getStringExtra("resadd")
        lsdob = intent.getStringExtra("dob")
        lsmstatus = intent.getStringExtra("mstatus")
        lsnoofchild = intent.getStringExtra("noofchild")

        lsoccupation = intent.getStringExtra("occupation")
        lsmpname = intent.getStringExtra("empname")
        lsempadd = intent.getStringExtra("empadd")
        lsgrosssal = intent.getDoubleExtra("grosssal", 0.0)
        lsmonthlysal = intent.getDoubleExtra("montlysal", 0.0)

        lstypeofloan = intent.getStringExtra("type")
        lspurpose = intent.getStringExtra("purpose")
        lsprodetails = intent.getStringExtra("propdetails")

        lscostofland = intent.getDoubleExtra("costofl", 0.0)
        lscostofconstruction = intent.getDoubleExtra("costofcosnt", 0.0)
        lsloanreq = intent.getDoubleExtra("loanamt", 0.0)
        lstenture = intent.getIntExtra("tenture", 0).toString()
        lscostofprop = intent.getDoubleExtra("costofp", 0.0)

        lscobname = intent.getStringExtra("cobname")
        lscobdob = intent.getStringExtra("cobdate")
        lscobadd = intent.getStringExtra("cobadd")

        lscoboccupation = intent.getStringExtra("coboccupation")
        lscobempname = intent.getStringExtra("cobempname")
        lscoempadd = intent.getStringExtra("cobempadd")
        Log.d("Tag", "fjfjfjf:$lscoempadd")

        lscobgrosssal = intent.getDoubleExtra("cobgrosssal", 0.0)
        lscobmonthly = intent.getDoubleExtra("cobmonthlysal", 0.0)
        initlayout()

        setT()
    }

    fun initlayout() {
        tvname = findViewById(R.id.tvname) as TextView
        tvdob = findViewById(R.id.tvdob) as TextView
        tvadd = findViewById(R.id.tvresadd) as TextView
        tvmstatus = findViewById(R.id.tvstatus) as TextView
        tvnoofchild = findViewById(R.id.tvnoofchild) as TextView

        tvoccupation = findViewById(R.id.tvoccupation) as TextView
        tvempname = findViewById(R.id.tvempname) as TextView
        tvempadd = findViewById(R.id.tvempadd) as TextView
        tvgrosssal = findViewById(R.id.tvgrosssal) as TextView
        tvmonthlysal = findViewById(R.id.tvmonthlysal) as TextView
        tvlabelprop = findViewById(R.id.labelcoprop) as TextView
        tvlabelcol = findViewById(R.id.tvcol) as TextView
        tvlabelcoc = findViewById(R.id.tvcoc) as TextView

        tvtypeofloan = findViewById(R.id.tvtypeofloan) as TextView
        tvpurpose = findViewById(R.id.tvpurposeofloan) as TextView
        tvpropdetails = findViewById(R.id.tvpropertydetails) as TextView
        tvcostofland = findViewById(R.id.tvcostofland) as TextView
        tvcostofconst = findViewById(R.id.tvcostofconst) as TextView
        tvcostofprop = findViewById(R.id.tvcostofprop) as TextView
        tvloanreq = findViewById(R.id.tvloanreq) as TextView
        tvtenture = findViewById(R.id.tvtenture) as TextView

        tvconame = findViewById(R.id.tvcobname) as TextView
        tvcobdob = findViewById(R.id.tvcobdob) as TextView
        tvcobadd = findViewById(R.id.tvcobadd) as TextView

        tvcooccupation = findViewById(R.id.tvcoboccupation) as TextView
        tvcoempadd = findViewById(R.id.tvcobempadd) as TextView
        tvcogrosssal = findViewById(R.id.tvcobgross) as TextView
        tvcoempname = findViewById(R.id.tvcobempname) as TextView
        tvcomonthlysal = findViewById(R.id.tvcobmonthlysal) as TextView
        if (lsprodetails != null || lsprodetails !== "") {
            if (lsprodetails!!.contains("own")) {
                tvcostofland.visibility = View.VISIBLE
                tvcostofconst.visibility = View.VISIBLE
                tvlabelcol.visibility = View.VISIBLE
                tvlabelcoc.visibility = View.VISIBLE
                tvcostofprop.visibility = View.GONE
                tvlabelprop.visibility = View.GONE
            } else {
                tvcostofprop.visibility = View.VISIBLE
                tvlabelprop.visibility = View.VISIBLE
                tvcostofland.visibility = View.GONE
                tvcostofconst.visibility = View.GONE
                tvlabelcol.visibility = View.GONE
                tvlabelcoc.visibility = View.GONE
            }
        } else {
            lsprodetails = "blanck"
        }

        /*   if(lsaddress.equals(null))
        {
            lsaddress = "";
        }

        if(lscoempadd.equals(null))
        {
            lscoempadd = "";
        }

        if(lscoempadd.equals(null))
        {
            lscoempadd = "";
        }*/

        lstrimaddress = trimAddress(lsaddress)
        lstrimcoempadd = trimAddress(lscoempadd)
        lstrimempadd = trimAddress(lsempadd)
        lstrimcobadd = trimAddress(lscobadd)


    }

    fun trimAddress(address: String): String {
        var address = address

        if (address != "" || address != null) {
            if (address.contains("Residence")) {
                address = address.replace("Residence Address:\n", "")

            } else if (address.contains("Employer")) {
                address = address.replace("Employer Address:\n", "")

            }
        } else {
            address = "blank"
        }

        return address
    }

    fun setT() {
        tvname.text = lsname
        tvdob.text = lsdob

        tvadd.text = lstrimaddress
        tvmstatus.text = lsmstatus
        tvnoofchild.text = lsnoofchild

        tvoccupation.text = lsoccupation
        tvempname.text = lsmpname
        tvempadd.text = lstrimempadd
        tvgrosssal.text = lsgrosssal!!.toString()
        tvmonthlysal.text = lsmonthlysal!!.toString()

        tvtypeofloan.text = lstypeofloan
        tvpurpose.text = lspurpose

        tvpropdetails.text = lsprodetails

        tvcostofland.text = lscostofland!!.toString()
        tvcostofconst.text = lscostofconstruction!!.toString()
        tvcostofprop.text = lscostofprop!!.toString()
        tvloanreq.text = lsloanreq!!.toString()
        tvtenture.text = lstenture

        tvconame.text = lscobname
        tvcobdob.text = lscobdob
        tvcobadd.text = lstrimcobadd

        tvcooccupation.text = lscoboccupation
        tvcoempname.text = lscobempname
        tvcoempadd.text = lstrimcoempadd
        tvcogrosssal.text = lscobgrosssal!!.toString()
        tvcomonthlysal.text = lscobmonthly!!.toString()

    }
}
