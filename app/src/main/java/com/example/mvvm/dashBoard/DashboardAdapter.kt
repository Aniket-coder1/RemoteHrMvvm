package com.example.mvvm.dashBoard

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm.R
import com.example.mvvm.dataClass.dashboardData.Dashboard
import com.squareup.picasso.Picasso


class DashboardAdapter(
    private val arrayList: ArrayList<Dashboard>,
    val context: Context?,
) : RecyclerView.Adapter<DashboardAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.dashboard_single_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val viewHolder: ViewHolder = holder
        var navController: NavController? = null

        viewHolder.tvTitle!!.text = arrayList[position].displayName
        Picasso.with(context).load(arrayList[position].image).into(viewHolder.logo)
        viewHolder.cvMain!!.setOnClickListener {
            navController = Navigation.findNavController(viewHolder.itemView)
            when (arrayList[position].id) {
                4 -> {
                    navController!!.navigate(R.id.action_dashboardFragment_to_leaveFragment)
                }
                3 -> {
                    navController!!.navigate(R.id.action_dashboardFragment_to_contactList)
                }
                8 -> {
                    navController!!.navigate(R.id.action_dashboardFragment_to_reimbursementFragment)
                }
            }
        }
        /*  viewHolder.cvMain!!.setOnClickListener {
              if (arrayList[position].id == 1) {
                  if (Utility.isNetworkConnected(context!!)) {
                      hitUserProfile()
                  } else {
                      Utility.showToast(context, "No Internet Connection", R.drawable.no_signal)
                  }
              } else if (arrayList[position].id == 3) {
                  mainactivity.fragmentManagement(
                      Constant.Contact_Fragment,
                      Constant.REPLACE,
                      true,
                      null
                  )
              } else if (arrayList[position].id == 4) {
                  mainactivity.fragmentManagement(
                      Constant.Leave_Fragment,
                      Constant.REPLACE,
                      true,
                      null
                  )
              } else if (arrayList[position].id == 5) {
                  mainactivity.fragmentManagement(
                      Constant.Document_Fragment,
                      Constant.REPLACE,
                      true,
                      null
                  )
              } else if (arrayList[position].id == 7) {
                  // context!!.startActivity(Intent(context, PaySlipActivity::class.java))
                  *//*PayslipOptionDIalog payslipOptionDIalog = new PayslipOptionDIalog(context);
                    payslipOptionDIalog.setCancelable(false);
                    payslipOptionDIalog.show();*//*
            } else if (arrayList[position].id == 11) {
                // context!!.startActivity(Intent(context, HolidayListActivity::class.java))
                mainactivity.fragmentManagement(
                    Constant.HolidayList_Fragment,
                    Constant.REPLACE,
                    true,
                    null
                )
            }
        }*/
    }


    override fun getItemCount(): Int {
        return arrayList.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val logo: ImageView? = view.findViewById(R.id.logo)
        var tvTitle: TextView? = view.findViewById(R.id.tvTitle)
        var cvMain: CardView? = view.findViewById(R.id.cvMain)

    }
}


