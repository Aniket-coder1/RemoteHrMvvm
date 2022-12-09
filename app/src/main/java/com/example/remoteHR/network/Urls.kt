package com.example.remoteHR.network

interface URLs {
    companion object {
        var Login = "login"
        var user_profile = "user-profile"
        var mark_attendance = "mark-attendance"
        var logout = "logout"
        var user_dashboard = "user-dashboard"
        var employee_list = "employee-list"
        var view_payslip = "view-payslip"
        var delete_file = "delete-file"
        var document_list = "document-list"
        var sub_document_list = "sub-document-list"
        var holiday_list = "holiday-list"
        var holidays = "holidays"
        var my_leave = "my-leave"
        var apply_leave = "apply-leave"
        var list_leave = "list-leave"
        var leaveDelete = "leaveDelete"
        var apply_reimbursement = "apply-reimbursement"
        var list_reimbursement = "list-reimbursement"
        var reimbursementDelete = "reimbursementDelete"
        var my_attendance = "my-attendance"
    }
}