package com.example.innobuzztask.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.innobuzztask.R
import com.example.innobuzztask.databinding.ListItemBinding
import com.example.innobuzztask.model.ResponseDataModelItem


class NetworkAdapter(private val list : List<ResponseDataModelItem>):RecyclerView.Adapter<NetworkAdapter.NetworkAdapterViewHolder>(){

    class NetworkAdapterViewHolder(var binding : ListItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NetworkAdapterViewHolder {
        val binding : ListItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.list_item,
            parent,
            false
        )
        return NetworkAdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NetworkAdapterViewHolder, position: Int) {
        val current = list[position]
        holder.itemView.apply {
            holder.binding.title.text= current.title.toString()
            setOnClickListener {
                val bundle =Bundle()
                bundle.putString("title",current.title)
                bundle.putInt("id",current.id)
                bundle.putInt("userId",current.userId)
                bundle.putString("body",current.body)

                findNavController().navigate(R.id.action_homeFragment_to_contentFragment,bundle)
            }
        }



    }

    override fun getItemCount(): Int {
        return list.size
    }
}