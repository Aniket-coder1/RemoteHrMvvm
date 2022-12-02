package com.example.mvvm.contact

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm.databinding.SingleItmContactBinding
import com.squareup.picasso.Picasso

class ContactAdapter(
    private val arrayList: ArrayList<ContactData>,
    val context: Context, val model: ContactViewModel
) : RecyclerView.Adapter<ContactAdapter.ViewHolder>() {
    lateinit var binding: SingleItmContactBinding


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = SingleItmContactBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val viewHolder: ViewHolder = holder
       binding.tvContNm.text = arrayList[position].displayName
        Picasso.with(context).load(arrayList[position].profilePhoto)
            .into(binding.ivContact)
        binding.tvEmail.text = arrayList[position].companyEmail
        binding.tvDesignation.text = arrayList[position].designation
        binding.tvContact.text = arrayList[position].contactNumber
        val number: String = arrayList[position].contactNumber
        binding.ivCall.setOnClickListener(View.OnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:$number")
            context.startActivity(intent)
        })
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    class ViewHolder(val binding: SingleItmContactBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(contactData: ContactData) {
            binding.contactListData = contactData
        }
    }
}