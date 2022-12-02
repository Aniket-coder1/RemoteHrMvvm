package com.example.mvvm.liveList

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.example.mvvm.R
import com.example.mvvm.dataClass.leaveListData.LeaveListData
import com.example.mvvm.databinding.SingleItmLeaveListBinding
import com.example.mvvm.others.Utility


class LeaveListAdapter(
    private val arrayList: ArrayList<LeaveListData>,
    val context: Context,val model: LeaveListViewModel
) : RecyclerView.Adapter<LeaveListAdapter.ViewHolder>() {
    lateinit var binding: SingleItmLeaveListBinding


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = SingleItmLeaveListBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val viewHolder: ViewHolder = holder
        binding.tvStatus.text = arrayList[position].approvalStatus
        binding.tvReason.text = arrayList[position].reason
        binding.tvLeaveType.text = arrayList[position].leaveName
        binding.tvLeaveFrom.text = (arrayList[position].fromDate + " " + arrayList[position].toDate)
        binding.tvNoDays.text = arrayList[position].noOfDays
        binding.tvStatus.setTextColor(Color.parseColor(arrayList[position].textColor))
        binding.rl1.setBackgroundColor(Color.parseColor(arrayList[position].textBackgroundColor))
        when (binding.tvStatus.text.toString().lowercase()) {
            "pending" -> {
                binding.ivIcon.setBackgroundResource(R.drawable.pending)
                binding.ivDelete.visibility = View.VISIBLE
            }
            "rejected" -> {
                binding.ivIcon.setBackgroundResource(R.drawable.rejected)
                binding.ivDelete.visibility = View.GONE
            }
            "approved" -> {
                binding.ivIcon.setBackgroundResource(R.drawable.approved)
                binding.ivDelete.visibility = View.GONE
            }
            else -> viewHolder.binding.ivDelete.visibility = View.GONE
        }
       binding.ivDelete.setOnClickListener {
            if (Utility.isNetworkConnected(context)) {
                model.hitDeleteApi(position)
            } else {
                Utility.showToast(context, "No Internet Connection", R.drawable.no_signal)
            }
        }
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    class ViewHolder(val binding: SingleItmLeaveListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(foreclosureData: LeaveListData) {
            binding.leaveListData = foreclosureData
        }
    }
}