package com.example.remoteHR.dashBoard

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.remoteHR.R
import com.example.remoteHR.activity.MainActivity
import com.example.remoteHR.profile.mainProfile.MainProfileViewModel
import com.example.remoteHR.dataClass.dashboardData.Dashboard
import com.example.remoteHR.databinding.FragmentDashboardBinding
import com.example.remoteHR.others.Utility
import com.example.remoteHR.others.Utility.Companion.printMessage
import com.facebook.shimmer.ShimmerFrameLayout
import com.squareup.picasso.Picasso


class DashboardFragment() : Fragment() {
    var ivLogout: ImageView? = null
    private var tvTitle: TextView? = null
    lateinit var binding: FragmentDashboardBinding
    private var mainActivity: MainActivity? = null
    private val model: DashboardViewModel by activityViewModels()
    private val mainProfileModel: MainProfileViewModel by activityViewModels()
    var progressBar: Dialog? = null
    private var recyclerView: RecyclerView? = null
    var container: ShimmerFrameLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivity = activity as MainActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_dashboard, container, false)
        binding.dashboard = model
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        container = view.findViewById(R.id.shimmer_view_container)
        ivLogout = view.findViewById(R.id.ivLogout)
        tvTitle = view.findViewById(R.id.tvTitle)
        recyclerView = view.findViewById(R.id.recyclerView)
        ivLogout!!.visibility = View.VISIBLE
        if (progressBar == null) progressBar = Utility.CustomLoader(requireContext())
        setOnClick()
        with(container) { this?.startShimmer() }
        model.isLoading.observe(this.viewLifecycleOwner) {
            when (it) {
                true -> showProgressBar()
                false -> hideProgressBar()
            }
        }
    }

    private fun setOnClick() {
        if (Utility.isNetworkConnected(requireContext())) {
            model.getDashboardData(this)
        } else {
            Utility.showToast(requireContext(), "No Internet Connection", R.drawable.no_signal)
        }

        model.dashboarddata.observe((viewLifecycleOwner)) {
            printMessage("response data =$it")
            if (it != null) {
                val dashBoardData = it[0]
                tvTitle!!.text = dashBoardData.headerName
                binding.tvClockIn.text = dashBoardData.dutyIn
                binding.tvClockOut.text = dashBoardData.dutyOut
                binding.tvDate.text = dashBoardData.dateDisplay
                binding.tvWelcome.text = dashBoardData.displayName
                Picasso.with(context).load(dashBoardData.dateIcon)
                    .error(R.drawable.time).into(binding.ivTime)
                setAdapter(ArrayList(dashBoardData.dashboard))
            }
        }
        binding.cvPunchIn.setOnClickListener {
            if (Utility.isNetworkConnected(requireContext())) {
                model.hitPunchIn(this)
            } else {
                Utility.showToast(requireContext(), "No Internet Connection", R.drawable.no_signal)
            }
        }
        binding.cvPunchOut.setOnClickListener {
            if (Utility.isNetworkConnected(requireContext())) {
                model.hitPunchOut(this)
            } else {
                Utility.showToast(requireContext(), "No Internet Connection", R.drawable.no_signal)
            }
        }
        fun logout() {
            model.HitLogout()
            model.GetLogoutResponse().observe((viewLifecycleOwner)) {
                printMessage("log res $it")
                if (it != null) {
                    try {
                        view?.findNavController()
                            ?.navigate(R.id.action_dashboardFragment_to_mainLogin)
                    } catch (e: Exception) {
                    }
                }
            }
        }
        ivLogout?.setOnClickListener {

            val builder = AlertDialog.Builder(requireContext())
            builder.setTitle("Demo MVVM App")
            builder.setIcon(R.mipmap.ic_launcher)
            builder.setMessage("Are you sure want to logout")
            builder.setNegativeButton("No") { dialog, _ -> dialog.dismiss() }
            builder.setPositiveButton("Yes") { dialog, _ ->
                dialog.dismiss()
                if (Utility.isNetworkConnected(requireContext())) {
                    logout()
                } else {
                    Utility.showToast(
                        requireContext(),
                        "No Internet Connection",
                        R.drawable.no_signal
                    )
                }
            }
            val alertDialog = builder.create()
            alertDialog.show()
        }
        binding.tvHelp.setOnClickListener {
            mainActivity?.showHelpDialog()
        }
    }

    private fun setAdapter(arrayList: ArrayList<Dashboard>?) {
        if (!arrayList.isNullOrEmpty()) {
            recyclerView?.apply {
                layoutManager = GridLayoutManager(requireContext(), 3)
                adapter = DashboardAdapter(arrayList, context)
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

