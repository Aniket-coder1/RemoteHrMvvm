package com.example.remoteHR.profile.companyInfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.remoteHR.R
import com.example.remoteHR.activity.MainActivity

import com.example.remoteHR.databinding.FragmentCompanyInfoBinding
import com.example.remoteHR.profile.mainProfile.MainProfileViewModel
import com.squareup.picasso.Picasso

class CompanyInfoFragment() : Fragment() {
    private var mainActivity: MainActivity? = null
    lateinit var binding: FragmentCompanyInfoBinding
    private val model: MainProfileViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivity = activity as MainActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_company_info, container, false)
        binding.mainProfile = model
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        model.MainProfiledata.observe((viewLifecycleOwner)) {
            if (it != null) {
                val companyData = it[0]
                binding.tvComName.text = companyData.companyInfo[0].companyName
                binding.tvCompContact.text = companyData.companyInfo[0].companyContact
                binding.tvComEmail.text = companyData.companyInfo[0].companyEmail
                binding.tvCompAddress.text = companyData.companyInfo[0].companyAddress
                binding.tvCompWebsite.text = companyData.companyInfo[0].companyWebsite
                Picasso.with(context).load(companyData.companyInfo[0].companyPhoto)
                    .error(R.drawable.time).into(binding.IvComPhoto)
            }
        }
    }
}