package com.example.remoteHR.profile.bankInfo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.example.remoteHR.R
import com.example.remoteHR.activity.MainActivity
import com.example.remoteHR.databinding.FragmentBankInfoBinding
import com.example.remoteHR.profile.mainProfile.MainProfileViewModel


class BankInfoFragment : Fragment() {
    private var mainActivity: MainActivity? = null
    private val model: MainProfileViewModel by activityViewModels()
    lateinit var binding: FragmentBankInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivity = activity as MainActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_bank_info, container, false)
        binding.mainProfile = model
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        model.MainProfiledata.observe((viewLifecycleOwner)){
            if (it!=null){
                val bankData = it[0]
                binding.tvBnkNm.text = bankData.bankDetailsInfo[0].bankName
                binding.tvBnkAccNum.text = bankData.bankDetailsInfo[0].accountNumber
                binding.tvIfscCode.text = bankData.bankDetailsInfo[0].ifscCode
                binding.tvPanNum.text = bankData.bankDetailsInfo[0].panNumber
                binding.tvAdharNum.text = bankData.bankDetailsInfo[0].adhaarNumber
                binding.tvBranchName.text = bankData.bankDetailsInfo[0].branchName
            }
        }
    }
}