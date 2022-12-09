package com.example.remoteHR.dataClass.data

data class MainProfileResponseItem(
    val bankDetailsInfo: List<BankDetailsInfo>,
    val companyInfo: List<CompanyInfo>,
    val designation: String,
    val displayName: String,
    val headerName: String,
    val personalInfo: List<PersonalInfo>,
    val profileInfo: List<ProfileInfo>,
    val profilePhoto: String
)