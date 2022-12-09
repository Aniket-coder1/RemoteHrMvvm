package com.example.remoteHR.profile.mainProfile

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.remoteHR.profile.bankInfo.BankInfoFragment
import com.example.remoteHR.profile.companyInfo.CompanyInfoFragment
import com.example.remoteHR.profile.personalInfo.PersonalFragment
import com.example.remoteHR.profile.profileInfo.ProfileFragment

private const val NUM_TABS = 4
class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return NUM_TABS
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return ProfileFragment()
            1 -> return PersonalFragment()
            2 -> return CompanyInfoFragment()
        }
        return BankInfoFragment()
    }
}