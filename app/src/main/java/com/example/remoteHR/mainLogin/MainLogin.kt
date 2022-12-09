package com.example.remoteHR.mainLogin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.remoteHR.R
import com.example.remoteHR.SharedPreferences
import com.example.remoteHR.activity.MainActivity
import com.example.remoteHR.databinding.MainLoginBinding
import com.example.remoteHR.others.PrefManager
import com.example.remoteHR.others.Utility
import com.example.remoteHR.others.Utility.Companion.printMessage
import com.example.remoteHR.spref.Spref

import org.json.JSONObject

class MainLogin() : Fragment() {

    lateinit var binding: MainLoginBinding
    private var mainActivity: MainActivity? = null
    private val model: LoginViewModel by activityViewModels()
    var email: String = ""
    var password: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivity = activity as MainActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.main_login, container, false)
        binding.loginViewModel = model
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnClick()
        if (!PrefManager(requireContext()).isUserLogedOut) {
            startNext()
        }
    }

    private fun startNext() {
        try {
            view?.findNavController()?.navigate(R.id.action_mainLogin_to_dashboardFragment)
        } catch (e: Exception) {
        }
    }

    private fun setOnClick() {
        binding.btLogin.setOnClickListener {
            email = model.inputUserId.value.toString()
            password = model.inputPassword.value.toString()
            if (Utility.isNetworkConnected(requireContext())) {
                model.getTokens(this)
                model.GetResponse().observe((viewLifecycleOwner)) {
                    printMessage("response data =$it")

                    if (it != null) {
                        try {
                            view?.findNavController()
                                ?.navigate(R.id.action_mainLogin_to_dashboardFragment)
                        } catch (e: Exception) {
                        }
                        for (i in 0 until it.size()) {
                            val jsonElement = it[i]
                            val jsonObject = jsonElement.asJsonObject
                            if (jsonObject.has("token")) {
                                val json = JSONObject(jsonObject["token"].toString())
                                printMessage("accessToken - $json")
                                if (json.has("accessToken")) {
                                    Spref.putStringVal(Spref.TOKEN, json.getString("accessToken"))
                                    printMessage("accessToken - 1 " + Spref.getStringVal(Spref.TOKEN))
                                }
                            }
                            if (jsonObject.has("user")) {
                                val json = JSONObject(jsonObject["user"].toString())
                                if (json.has("empId")) {
                                    printMessage("empId - " + json.getInt("empId"))
                                    SharedPreferences.setIntPreference(
                                        requireContext(),
                                        SharedPreferences.EmpId,
                                        json.getInt("empId")
                                    )
                                }
                                if (json.has("empCode")) {
                                    SharedPreferences.setStringPreference(
                                        requireContext(),
                                        SharedPreferences.EmpCode,
                                        json.getString("empCode")
                                    )
                                }
                                if (json.has("fullName")) {
                                    SharedPreferences.setStringPreference(
                                        requireContext(),
                                        SharedPreferences.FullName,
                                        json.getString("fullName")
                                    )
                                }
                                if (json.has("contactNumber")) {
                                    SharedPreferences.setStringPreference(
                                        requireContext(),
                                        SharedPreferences.ContactNumber,
                                        json.getString("contactNumber")
                                    )
                                }
                                if (json.has("companyEmail")) {
                                    SharedPreferences.setStringPreference(
                                        requireContext(),
                                        SharedPreferences.CompanyEmail,
                                        json.getString("companyEmail")
                                    )
                                }
                                if (json.has("userType")) {
                                    SharedPreferences.setStringPreference(
                                        requireContext(),
                                        SharedPreferences.UserType,
                                        json.getString("userType")
                                    )
                                }
                            }
                        }
                    }
                }
            } else {
                Utility.showToast(requireContext(),"No Internet Connection",R.drawable.no_signal)            }
        }
    }
}