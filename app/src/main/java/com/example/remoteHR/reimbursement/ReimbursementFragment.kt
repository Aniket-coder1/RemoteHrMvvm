package com.example.remoteHR.reimbursement

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.remoteHR.R
import com.example.remoteHR.activity.MainActivity
import com.example.remoteHR.databinding.FragmentReimbursementBinding
import com.example.remoteHR.others.Utility
import java.util.*

class ReimbursementFragment() : Fragment() {
    lateinit var binding: FragmentReimbursementBinding
    private var mainActivity: MainActivity? = null
    val model: ReimbursementViewModel by activityViewModels()
    var progressBar: Dialog? = null
    private val c: Calendar = Calendar.getInstance()
    private var year = 0
    private var month = 0
    private var day = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivity = activity as MainActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_reimbursement, container, false)
        binding.reimbursement = model
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (progressBar == null) progressBar = Utility.CustomLoader(requireContext())

        model.isLoading.observe(this.viewLifecycleOwner) {
            when (it) {
                true -> showProgressBar()
                false -> hideProgressBar()
            }
        }

        setOnClick()
    }

    private fun setOnClick() {
        binding.etFromDate.setOnClickListener {
            year = c[Calendar.YEAR]
            month = c[Calendar.MONTH]
            day = c[Calendar.DAY_OF_MONTH]
            //:2022-10-01
            val datePickerDialog = DatePickerDialog(
                requireContext(),
                { _, year, monthOfYear, dayOfMonth ->
                    binding.etFromDate.setText(year.toString() + "-" + (monthOfYear + 1) + "-" + dayOfMonth)
                    model.fromDate = binding.etFromDate.text.toString()
                    Utility.printMessage("From Date-- " + binding.etFromDate.text.toString())
                }, year, month, day
            )
            datePickerDialog.show()
        }
        binding.etToDate.setOnClickListener {
            year = c[Calendar.YEAR]
            month = c[Calendar.MONTH]
            val datePickerDialog = DatePickerDialog(
                requireContext(),
                { _, year, monthOfYear, dayOfMonth ->
                    binding.etToDate.setText(year.toString() + "-" + (monthOfYear + 1) + "-" + dayOfMonth)
                    model.toDate = binding.etToDate.text.toString()
                    Utility.printMessage("to Date-- " + binding.etToDate.text.toString())
                }, year, month, day
            )
            datePickerDialog.show()
        }
        binding.btApply.setOnClickListener {
            model.hitReimbursement(this)
        }
    }
    private fun showProgressBar() {
        if (progressBar != null) {
            progressBar!!.show()
        }
    }

    private fun hideProgressBar() {
        if (progressBar != null && progressBar!!.isShowing) {
            progressBar!!.dismiss()
        }
    }
}