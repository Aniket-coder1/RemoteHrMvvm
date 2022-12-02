package com.example.mvvm.reimbursement

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm.dataClass.ReimburseListData
import com.example.mvvm.databinding.SingleItmReimbListBinding

class ReimbursementAdapter(
    private val arrayList: ArrayList<ReimburseListData>,
    val context: Context,
    val model: ReimbursementViewModel
) : RecyclerView.Adapter<ReimbursementAdapter.ViewHolder>() {
    lateinit var binding: SingleItmReimbListBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = SingleItmReimbListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        binding.tvStatus.text = arrayList[position].approvalStatus
        binding.tvReason.text = arrayList[position].comment
        binding.tvLeaveFrom.text = arrayList[position].fromDate.toString() + " - " + arrayList[position].toDate
        binding.tvApprovedBy.text = arrayList[position].approvedRejectBy
    }

    override fun getItemCount(): Int {
      return arrayList.size
    }

    class ViewHolder(val binding: SingleItmReimbListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(reimburseListData: ReimburseListData) {
            binding.reimburseListData = reimburseListData
        }
    }
}