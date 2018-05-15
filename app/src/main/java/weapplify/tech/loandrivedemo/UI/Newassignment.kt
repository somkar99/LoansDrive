package weapplify.tech.loandrivedemo.UI

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log

import java.util.ArrayList

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.annotations.NonNull
import io.reactivex.disposables.Disposable
import weapplify.tech.loandrivedemo.Adapters.AssignmentListadapter
import weapplify.tech.loandrivedemo.Models.Assignmentlist
import weapplify.tech.loandrivedemo.R
import weapplify.tech.loandrivedemo.Upgrade.BaseActivity

class Newassignment : BaseActivity() {
    lateinit var rcassignmentlist: RecyclerView
  override  lateinit var context: Context
    lateinit var assignmentListadapter: AssignmentListadapter
     private var assignmentlist: ArrayList<Assignmentlist>? = null
    lateinit var list: RecyclerView.LayoutManager
    lateinit var alist: Assignmentlist
    lateinit var alist1: Assignmentlist
    lateinit var alist2: Assignmentlist
    lateinit var alist3: Assignmentlist
    lateinit var alist4: Assignmentlist


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.newassign)
        title = "New Assignments"
        context = this
        initlayout()
        createObservable()
    }

    fun initlayout() {
        list = LinearLayoutManager(context)
        rcassignmentlist = findViewById(R.id.assignmentlist) as RecyclerView
        rcassignmentlist.layoutManager = list


    }


    fun getAssignmentlist(): ArrayList<Assignmentlist> {
        alist = Assignmentlist()
        alist.borrowername = "Raj Shekhar"
        alist.loanno = "7276741887654"
        alist.date = "24 Sept 2017"
        alist.loanamt = 500000
        alist.collectionamt = 34000
        alist.residentialaddress = "Raikar Chemburs,\nnear Govandi Station,mumbai-400088"
        alist.propertyaddress = "Nilkath Appartment,\n Govandi,Mumbai -400088"

        alist1 = Assignmentlist()
        alist1.borrowername = "Vinay Zade"
        alist1.loanno = "9870055219876"
        alist1.date = "25 Sept 2017"
        alist1.loanamt = 500000
        alist1.collectionamt = 30000
        alist1.residentialaddress = "Raikar Chemburs,\nnear Govandi Station,mumbai-400088"
        alist1.propertyaddress = "Nilkath Appartment,\n Govandi,Mumbai -400088"

        alist2 = Assignmentlist()
        alist2.borrowername = "Omkar shinde"
        alist2.loanno = "8097755139876"
        alist2.date = "29 Sept 2017"
        alist2.loanamt = 500000
        alist2.collectionamt = 25000
        alist2.residentialaddress = "Raikar Chemburs,\nnear Govandi Station,mumbai-400088"
        alist2.propertyaddress = "Nilkath Appartment,\n Govandi,Mumbai -400088"

        alist3 = Assignmentlist()
        alist3.borrowername = "Rishabh Karani"
        alist3.loanno = "8097755140987"
        alist3.date = "30 Sept 2017"
        alist3.loanamt = 400000
        alist3.collectionamt = 44000
        alist3.residentialaddress = "Raikar Chemburs,\nnear Govandi Station,mumbai-400088"
        alist3.propertyaddress = "Nilkath Appartment,\n Govandi,Mumbai -400088"

        alist4 = Assignmentlist()
        alist4.borrowername = "Rashmi Mathada"
        alist4.loanno = "7276741887655"
        alist4.date = "1 Oct 2017"
        alist4.loanamt = 500000
        alist4.collectionamt = 34000
        alist4.residentialaddress = "Raikar Chemburs,\nnear Govandi Station,mumbai-400088"
        alist4.propertyaddress = "Nilkath Appartment,\n Govandi,Mumbai -400088"


        assignmentlist = ArrayList()
        assignmentlist!!.add(alist)
        assignmentlist!!.add(alist1)
        assignmentlist!!.add(alist2)
        assignmentlist!!.add(alist3)
        assignmentlist!!.add(alist4)
        return assignmentlist!!

    }

    fun createObservable() {
        val listobservable = Observable.just(getAssignmentlist())
        listobservable.subscribe(object : Observer<ArrayList<Assignmentlist>> {
            override fun onSubscribe(@NonNull d: Disposable) {


            }

            override fun onNext(@NonNull assignmentlists: ArrayList<Assignmentlist>) {

                assignmentListadapter = AssignmentListadapter(context, assignmentlists)
                rcassignmentlist.adapter = assignmentListadapter
                assignmentListadapter.notifyDataSetChanged()

            }

            override fun onError(@NonNull e: Throwable) {

            }

            override fun onComplete() {


            }
        })
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }


}
