package com.example.remoteHR.liveList

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.remoteHR.R
import com.example.remoteHR.activity.MainActivity
import com.example.remoteHR.dataClass.leaveListData.LeaveListData
import com.example.remoteHR.databinding.FragmentContactBinding
import com.example.remoteHR.others.Utility

import java.util.ArrayList

class LeaveListFragment() : Fragment() {

    lateinit var binding: FragmentContactBinding
    private var mainActivity: MainActivity? = null
    private val model: LeaveListViewModel by activityViewModels()
    var progressBar: Dialog? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivity = activity as MainActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_contact, container, false)
        binding.leaveList = model
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
        if (Utility.isNetworkConnected(requireContext())) {
            model.hitLeaveListData(this);
        } else {
            Utility.showToast(requireContext(), "No Internet Connection", R.drawable.no_signal)
        }
        setData()
    }

    private fun setData() {
        model.leaveList.observe((viewLifecycleOwner)) {
            if (it.isNotEmpty()) {
                setAdapter(it)
            }
        }
    }

    private fun setAdapter(it: ArrayList<LeaveListData>?) {
        if (!it.isNullOrEmpty()) {
            binding.rvContact.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = LeaveListAdapter(it, context,model)
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