package weapplify.tech.loandrivedemo.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import java.util.ArrayList

import weapplify.tech.loandrivedemo.Models.Assignmentlist
import weapplify.tech.loandrivedemo.R
import weapplify.tech.loandrivedemo.UI.Valuation


/**
 * Created by nehagulati on 9/27/17.
 */

class AssignmentListadapter(internal var context: Context, assignmentlist: ArrayList<Assignmentlist>) : RecyclerView.Adapter<AssignmentListadapter.AssignmentListViewHolder>() {
    internal var assignmentlist = ArrayList<Assignmentlist>()

    init {
        this.assignmentlist = assignmentlist
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AssignmentListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.assignment_row, parent, false)

        return AssignmentListViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun onBindViewHolder(holder: AssignmentListViewHolder, position: Int) {
        holder.tvname.setText(assignmentlist[position].borrowername!!.trim { it <= ' ' })
        holder.tvloanno.setText(assignmentlist[position].loanno!!.trim { it <= ' ' })
        holder.tvdate.setText(assignmentlist[position].date)
        holder.tvloanamt.setText("Rs." + assignmentlist[position].loanamt.toString().trim { it <= ' ' })
        holder.tvcollectionamt.setText("Rs." + assignmentlist[position].collectionamt.toString().trim { it <= ' ' })
        holder.tvresidentialaddres.setText(assignmentlist[position].residentialaddress!!.trim { it <= ' ' })
        holder.tvpropertyaddress.setText(assignmentlist[position].propertyaddress!!.trim { it <= ' ' })

    }

    override fun getItemCount(): Int {
        return assignmentlist.size
    }
    class AssignmentListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvname = itemView.findViewById<View>(R.id.tvname) as TextView
        val tvloanno = itemView.findViewById<View>(R.id.tvloanno) as TextView
        val tvdate = itemView.findViewById<View>(R.id.tvdate) as TextView
        val tvloanamt = itemView.findViewById<View>(R.id.tvloanamt) as TextView
        val tvcollectionamt = itemView.findViewById<View>(R.id.tvcollectionamt) as TextView
        val tvresidentialaddres = itemView.findViewById<View>(R.id.tvresaddress) as TextView
        val tvpropertyaddress = itemView.findViewById<View>(R.id.tvpropadd) as TextView





    }
}
