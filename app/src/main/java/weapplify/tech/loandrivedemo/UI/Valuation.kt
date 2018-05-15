package weapplify.tech.loandrivedemo.UI

import android.app.Activity
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

import java.util.Date
import java.text.SimpleDateFormat

import weapplify.tech.loandrivedemo.R
import weapplify.tech.loandrivedemo.Services.CalendarView
import weapplify.tech.loandrivedemo.Services.CalendarView.CVOnDateChanged
import weapplify.tech.loandrivedemo.Services.Debugger
import weapplify.tech.loandrivedemo.Upgrade.BaseActivity



class Valuation : BaseActivity() {

  override  lateinit var context: Context
  override  lateinit var activity: Activity
    lateinit var llValuer: LinearLayout
    lateinit var llvaluer: LinearLayout
    lateinit var llColateral: LinearLayout
    lateinit var llcolateral: LinearLayout
    lateinit var tvColateral: TextView
    lateinit var tvValuer: TextView
    lateinit var etExpDate: EditText
    lateinit var etEvalDate: EditText
    lateinit var etTurnAroundTime: EditText
    lateinit var calvalexcompletedate: ImageView
    lateinit var calvaldovaluation: ImageView
    lateinit var calvaltrunaround: ImageView
    lateinit var col: View
    lateinit var `val`: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.valuation)
        activity = this
        context = this
        title = "Valuation"

        initLayout()
    }

    fun initLayout() {

        llValuer = findViewById(R.id.llValuer) as LinearLayout
        llvaluer = findViewById(R.id.llvaluer) as LinearLayout
        llColateral = findViewById(R.id.llColateral) as LinearLayout
        llcolateral = findViewById(R.id.llcolateral) as LinearLayout
        tvColateral = findViewById(R.id.tvColateral) as TextView
        tvValuer = findViewById(R.id.tvValuer) as TextView
        etTurnAroundTime = findViewById(R.id.etTurnAroundTime) as EditText
        etEvalDate = findViewById(R.id.etEvalDate) as EditText
        etExpDate = findViewById(R.id.etExpDate) as EditText
        calvaltrunaround = findViewById(R.id.calvaltrunaround) as ImageView
        calvaldovaluation = findViewById(R.id.calvaldovaluation) as ImageView
        calvalexcompletedate = findViewById(R.id.calvalexcompletedate) as ImageView
        `val` = findViewById(R.id.gviewval) as View
        col = findViewById(R.id.gviewcoll) as View
        llcolateral.visibility = View.VISIBLE
        col.visibility = View.VISIBLE
        `val`.visibility = View.INVISIBLE
        llvaluer.visibility = View.GONE
        llColateral.setBackgroundColor(resources.getColor(R.color.bggray))


        tvColateral.setTextColor(resources.getColor(R.color.background))

        llValuer.setOnClickListener {
            llcolateral.visibility = View.GONE
            llvaluer.visibility = View.VISIBLE
            col.visibility = View.GONE
            `val`.visibility = View.VISIBLE
            llValuer.setBackgroundColor(resources.getColor(R.color.bggray))
            llColateral.setBackgroundColor(resources.getColor(R.color.mdtp_white))
            tvColateral.setTextColor(resources.getColor(R.color.gray))
            tvValuer.setTextColor(resources.getColor(R.color.background))
        }

        llColateral.setOnClickListener {
            llvaluer.visibility = View.GONE
            `val`.visibility = View.GONE
            col.visibility = View.VISIBLE
            llcolateral.visibility = View.VISIBLE
            llColateral.setBackgroundColor(resources.getColor(R.color.bggray))
            llValuer.setBackgroundColor(resources.getColor(R.color.mdtp_white))
            tvValuer.setTextColor(resources.getColor(R.color.gray))
            tvColateral.setTextColor(resources.getColor(R.color.background))
        }

        calvalexcompletedate.setOnClickListener(this)
        etExpDate.setOnClickListener(this)
        calvaldovaluation.setOnClickListener(this)
        etEvalDate.setOnClickListener(this)
        calvaltrunaround.setOnClickListener(this)
        etTurnAroundTime.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        super.onClick(v)
        when (v.id) {
            R.id.calvalexcompletedate, R.id.etExpDate ->

                setUpDate(etExpDate)

            R.id.calvaldovaluation, R.id.etEvalDate ->

                setUpDate(etEvalDate)

            R.id.calvaltrunaround, R.id.etTurnAroundTime ->

                setUpDate(etTurnAroundTime)
        }
    }

    fun setUpDate(etDate: EditText) {
        val calendarPop = CalendarView(activity, context, true)
        var lsDate: String? = etDate.text.toString()
        if (lsDate == null || lsDate == "") {
            val sdf = SimpleDateFormat("dd/MM/yyyy")
            lsDate = sdf.format(Date()).toString()
        }

      /*  val mOnDateChanged = CVOnDateChanged(tvDate, lsDate)
            Debugger.debug("TAG", "DAte selected is $lsDate")
            etDate.setText(lsDate)

        calendarPop.setOnDateChanged(mOnDateChanged)
        calendarPop.setupPopUp(etDate, lsDate)*/

        val mOnDateChanged = object : CalendarView.CVOnDateChanged {
           override fun CVDateChanged(tvDate: TextView, lsDate: String) {
                Debugger.debug("TAG", "DAte selected is $lsDate")
                etDate.setText(lsDate)
            }
        }
        calendarPop.setOnDateChanged(mOnDateChanged)
        calendarPop.setupPopUp(etDate, lsDate)

    }

}
