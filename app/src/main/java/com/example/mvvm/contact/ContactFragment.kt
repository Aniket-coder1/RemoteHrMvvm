package com.example.mvvm.contact

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm.R
import com.example.mvvm.activity.MainActivity
import com.example.mvvm.databinding.FragmentContactBinding
import com.example.mvvm.others.Utility

class ContactFragment() : Fragment() {
    lateinit var binding: FragmentContactBinding
    private var mainActivity: MainActivity? = null
    private val model : ContactViewModel by activityViewModels()
    var progressBar: Dialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivity = activity as MainActivity
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_contact, container, false)
        binding.contactList = model
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (progressBar == null) progressBar = Utility.CustomLoader(requireContext())
        model.isLoading.observe(this.viewLifecycleOwner) {
            when (it) {
                true -> showProgressBar()
                false -> hideProgressBar()
            }
        }
        if (Utility.isNetworkConnected(requireContext())) {
            model.getContactList(this);
        } else {
            Utility.showToast(requireContext(), "No Internet Connection", R.drawable.no_signal)
        }
        setData()
    }

    private fun setData() {
      model.contactList.observe((viewLifecycleOwner)){
          Utility.printMessage("response data =$it")
          if (it.isNotEmpty()){
              setAdapter(it)
          }
      }
    }

    private fun setAdapter(arrayList: ArrayList<ContactData>?) {
        if (!arrayList.isNullOrEmpty()) {
            binding.rvContact.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = ContactAdapter(arrayList, context,model)
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