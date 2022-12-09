package com.example.remoteHR.profile.personalInfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.remoteHR.R
import com.example.remoteHR.activity.MainActivity
import com.example.remoteHR.databinding.FragmentPersonalBinding
import com.example.remoteHR.profile.mainProfile.MainProfileViewModel

class PersonalFragment() : Fragment(){
    private var mainActivity: MainActivity? = null
    lateinit var binding: FragmentPersonalBinding
    private val model: MainProfileViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivity = activity as MainActivity
    }


        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View {
            binding = DataBindingUtil.inflate(inflater, R.layout.fragment_personal, container, false)
            binding.mainProfile = model
            return binding.root
        }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        model.MainProfiledata.observe((viewLifecycleOwner)){
            if (it!=null){
                val profileData = it[0]
                //profile info
                binding.tvfullName.text = profileData.personalInfo[0].fullName
                binding.tvMaritalStatus.text = profileData.personalInfo[0].maritalStatus
                binding.tvGender.text = profileData.personalInfo[0].gender
                binding.tvDateOfBirth.text = profileData.personalInfo[0].DateOfBirth
                binding.tvBloodGroup.text = profileData.personalInfo[0].bloodGroup
                binding.tvContactNumber.text = profileData.personalInfo[0].contactNumber
                binding.tvEmerContactNum.text = profileData.personalInfo[0].emergencyContactNumber
                binding.tvPersonalEmail.text = profileData.personalInfo[0].personalEmail
                binding.tvTemporaryAddress.text = profileData.personalInfo[0].temporaryAddress
                binding.tvPermanentAddress.text = profileData.personalInfo[0].permanentAddress
            }
        }
    }
}