package com.example.remoteHR.profile.profileInfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.remoteHR.R
import com.example.remoteHR.activity.MainActivity
import com.example.remoteHR.databinding.FragmentProfileBinding
import com.example.remoteHR.profile.mainProfile.MainProfileViewModel

class ProfileFragment() : Fragment(){
    private var mainActivity: MainActivity? = null
    lateinit var binding: FragmentProfileBinding
    private val model: MainProfileViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivity = activity as MainActivity
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false)
        binding.mainProfile = model
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        model.MainProfiledata.observe((viewLifecycleOwner)){
            if (it!=null){
                val profileData = it[0]
                binding.tvEmpId.text = profileData.profileInfo[0].empCode
                binding.tvEmail.text = profileData.profileInfo[0].companyEmail
                binding.tvWorkLocation.text = profileData.profileInfo[0].workLocation
                binding.tvDepartment.text = profileData.profileInfo[0].department
                binding.tvDesignation.text = profileData.profileInfo[0].designation
                binding.tvGrade.text = profileData.profileInfo[0].grade
                binding.tvEmploymentType.text = profileData.profileInfo[0].employmentType
                binding.tvReportingTo.text = profileData.profileInfo[0].reportingTo
                binding.tvReportingTo.text = profileData.profileInfo[0].reportingTo
                binding.tvShiftDetails.text = profileData.profileInfo[0].shiftDetails
            }
        }
    }
}