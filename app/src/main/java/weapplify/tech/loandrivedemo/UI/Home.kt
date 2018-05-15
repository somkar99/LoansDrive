package weapplify.tech.loandrivedemo.UI

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView

import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.formatter.PercentFormatter

import java.util.ArrayList

import weapplify.tech.loandrivedemo.R
import weapplify.tech.loandrivedemo.Upgrade.BaseActivity

class Home : BaseActivity(), View.OnClickListener {
    lateinit var lfaq: LinearLayout
    lateinit var loffer: LinearLayout
    lateinit var lmyprofile: LinearLayout
    lateinit var lloanapplication: LinearLayout
    lateinit var leligibility: LinearLayout
    lateinit var lcalculator: LinearLayout
    lateinit var lpayment: LinearLayout
    lateinit var lreports: LinearLayout
    lateinit var ltcompanyname: TextView
    lateinit var ltname: TextView
    lateinit var ltrole: TextView
    lateinit var pieChart: PieChart
    override lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)
        initlayout()
        context = this

    }

    fun initlayout() {

        lloanapplication = findViewById(R.id.llloanapplication) as LinearLayout
        leligibility = findViewById(R.id.llLoannoGenaration) as LinearLayout
        lcalculator = findViewById(R.id.llemicalculator) as LinearLayout
        lpayment = findViewById(R.id.llCheckeligibility) as LinearLayout
        lreports = findViewById(R.id.llreports) as LinearLayout
        lfaq = findViewById(R.id.llfaqs) as LinearLayout
        loffer = findViewById(R.id.lloffers) as LinearLayout
        lmyprofile = findViewById(R.id.llprofile) as LinearLayout
        ltcompanyname = findViewById(R.id.ltcompanyname) as TextView
        ltname = findViewById(R.id.ltname) as TextView
        ltrole = findViewById(R.id.ltrole) as TextView

        lloanapplication.setOnClickListener(this)
        leligibility.setOnClickListener(this)
        lcalculator.setOnClickListener(this)
        lpayment.setOnClickListener(this)
        lreports.setOnClickListener(this)
        loffer.setOnClickListener(this)
        lmyprofile.setOnClickListener(this)
        lfaq.setOnClickListener(this)


        //piechart
        pieChart = findViewById(R.id.piechart) as PieChart

        pieChart.setUsePercentValues(true)
        pieChart.isDrawHoleEnabled = false
        pieChart.setDescription("")
        pieChart.legend.isEnabled = true
        val legend = pieChart.legend
        legend.position = Legend.LegendPosition.BELOW_CHART_LEFT
        legend.formSize = 8f
        legend.textSize = 8f
        pieChart.setDrawSliceText(false)

        val yvalues = ArrayList<Entry>()
        yvalues.add(Entry(30f, 0))
        yvalues.add(Entry(10f, 1))
        yvalues.add(Entry(12f, 2))

        val dataSet = PieDataSet(yvalues, "")
        dataSet.setColors(intArrayOf(R.color.button1, R.color.piechart1, R.color.piechart2), this@Home)

        val xVals = ArrayList<String>()
        xVals.add("New\nApplications")
        xVals.add("Processing")
        xVals.add("Completed")

        val data = PieData(xVals, dataSet)
        // In percentage Term
        data.setValueFormatter(PercentFormatter())
        pieChart.data = data

    }

    override fun onClick(v: View) {
        super.onClick(v)
        when (v.id) {
            R.id.llloanapplication -> {
                val application = Intent(context, LoanApplication::class.java)
                startActivity(application)
                finish()
            }

            R.id.llLoannoGenaration -> {
                val lapplication = Intent(context, LoanApplicatioNumber::class.java)
                startActivity(lapplication)
                finish()
            }

            R.id.llemicalculator ->{}

                R.id.llCheckeligibility -> {
            }

            R.id.llreports -> {
            }

            R.id.llfaqs -> {
            }

            R.id.lloffers -> {
            }

            R.id.llprofile -> {
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()


    }
}
