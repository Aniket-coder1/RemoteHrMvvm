package com.example.mvvm.leave

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.mvvm.R
import com.example.mvvm.activity.MainActivity
import com.example.mvvm.dataClass.leaveData.FromSession
import com.example.mvvm.dataClass.leaveData.LeaveType
import com.example.mvvm.dataClass.leaveData.ToSession
import com.example.mvvm.databinding.LeaveFagmentBinding

import com.example.mvvm.others.Utility
import java.util.*
import kotlin.collections.ArrayList


class LeaveFragment : Fragment() {
    var tvTitle: TextView? = null
    private var ivLogout: ImageView? = null
    private lateinit var binding: LeaveFagmentBinding
    private val model: LeaveViewModel by activityViewModels()
    private var mainActivity: MainActivity? = null
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
        binding = DataBindingUtil.inflate(inflater, R.layout.leave_fagment, container, false)
        binding.leave = model
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvTitle = view.findViewById(R.id.tvTitle)
        ivLogout = view.findViewById(R.id.ivLogout)
        if (progressBar == null) progressBar = Utility.CustomLoader(requireContext())
        model.isLoading.observe(this.viewLifecycleOwner) {
            when (it) {
                true -> showProgressBar()
                false -> hideProgressBar()
            }
        }
        if (Utility.isNetworkConnected(requireContext())) {
            model.hitGetLeavedata();
        } else {
            Utility.showToast(requireContext(),"No Internet Connection",R.drawable.no_signal)
        }
        setOnClick()
        setData()
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
        binding.etLeaveType.setOnClickListener {
            binding.spLeaveType.performClick()
        }
        binding.etFrmSessions.setOnClickListener {
            binding.spFrmSessions.performClick()
        }
        binding.etToSessions.setOnClickListener {
            binding.spToSessions.performClick()
        }
        binding.tvListLeave.setOnClickListener {
            try {
                view?.findNavController()
                    ?.navigate(R.id.action_leaveFragment_to_leaveList)
            } catch (e: Exception) {
            }
        }
    }

    private fun setData() {

        model.leaveType.observe((viewLifecycleOwner)) {
            if (it.isNotEmpty()) {
                setLeaveTypeAdapter(it)
            }
        }
        model.fromsession.observe((viewLifecycleOwner)) {
            if (it.isNotEmpty()) {
                setFromSessionAdapter(it)
            }
        }
        model.toSession.observe((viewLifecycleOwner)) {
            if (it.isNotEmpty()) {
                setToSessionAdapter(it)
            }
        }
    }

    private fun setToSessionAdapter(arrayListToSession: ArrayList<ToSession>) {
        if (!arrayListToSession.isNullOrEmpty()) {
            val adapter1 = ArrayAdapter(
                requireContext(),
                R.layout.spinner_tv, arrayListToSession
            )

            binding.spToSessions.adapter = adapter1
            binding.spToSessions.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
                        binding.etToSessions.setText(binding.spToSessions.selectedItem.toString())
                        model.toSessionsId = arrayListToSession[position].to_session
                    }

                    override fun onNothingSelected(parent: AdapterView<*>?) {}
                }
        }
    }

    private fun setFromSessionAdapter(arrayListFromSession: ArrayList<FromSession>) {
        if (!arrayListFromSession.isNullOrEmpty()) {
            val adapter2 = ArrayAdapter(requireContext(), R.layout.spinner_tv, arrayListFromSession)
            binding.spFrmSessions.adapter = adapter2
            binding.spFrmSessions.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
                        binding.etFrmSessions.setText(binding.spFrmSessions.selectedItem.toString())
                        model.fromSessionsId =
                            arrayListFromSession[position].from_session.toString()
                    }

                    override fun onNothingSelected(parent: AdapterView<*>?) {}
                }
        }
    }

    private fun setLeaveTypeAdapter(arrayListLeaveType: ArrayList<LeaveType>) {
        if (!arrayListLeaveType.isNullOrEmpty()) {
            val adapter3 = ArrayAdapter(
                requireContext(),
                R.layout.spinner_tv, arrayListLeaveType
            )
            binding.spLeaveType.adapter = adapter3
            binding.spLeaveType.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
                        binding.etLeaveType.setText(binding.spLeaveType.selectedItem.toString())
                        model.leaveTypeId = arrayListLeaveType[position].leaveTypeId
                    }

                    override fun onNothingSelected(parent: AdapterView<*>?) {}
                }
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
