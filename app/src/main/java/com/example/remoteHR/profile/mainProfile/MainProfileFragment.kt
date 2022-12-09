package com.example.remoteHR.profile.mainProfile

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.remoteHR.R
import com.example.remoteHR.activity.MainActivity
import com.example.remoteHR.databinding.FragmentMainProfileBinding
import com.example.remoteHR.others.Utility
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.squareup.picasso.Picasso

val animalsArray = arrayOf("Profile Info", "Personal Info", "Company Info", "Bank Info")
class MainProfileFragment : Fragment() {

lateinit var binding: FragmentMainProfileBinding
    private var mainActivity: MainActivity? = null
    private val model: MainProfileViewModel by activityViewModels()
    var progressBar: Dialog? = null
    var tvTitle:TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivity = activity as MainActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main_profile, container, false)
        binding.mainProfile = model
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (progressBar == null) progressBar = Utility.CustomLoader(requireContext())
        binding.tabLayout.tabGravity = TabLayout.GRAVITY_FILL
        tvTitle = view.findViewById(R.id.tvTitle)
        val viewPager = binding.viewPager
        val tabLayout = binding.tabLayout
        val adapter = ViewPagerAdapter(parentFragmentManager, lifecycle)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = animalsArray[position]
        }.attach()

        model.isLoading.observe(this.viewLifecycleOwner) {
            when (it) {
                true -> showProgressBar()
                false -> hideProgressBar()
            }
        }

        model.hitProfile()

        setData()
    }

    private fun setData() {
        model.MainProfiledata.observe((viewLifecycleOwner)){
            if (it!=null){
                val profileData = it[0]
                Picasso.with(context).load(profileData.profilePhoto)
                    .error(R.drawable.time).into(binding.ivProfile)
                binding.tvEmpName.text = profileData.displayName
                binding.tvEmpDesignation.text = profileData.designation
                tvTitle!!.text = profileData.headerName
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