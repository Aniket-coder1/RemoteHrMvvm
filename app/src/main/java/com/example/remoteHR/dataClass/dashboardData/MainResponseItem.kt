package com.example.remoteHR.dataClass.dashboardData

data class MainResponseItem(
    val dashboard: List<Dashboard>,
    val dateDisplay: String,
    val dateIcon: String,
    val designation: String,
    val displayName: String,
    val dutyIn: String,
    val dutyOut: String,
    val headerName: String,
    val profilePhoto: String,
    val punchData: List<PunchData>,
    val qrCodeUrl: String
)