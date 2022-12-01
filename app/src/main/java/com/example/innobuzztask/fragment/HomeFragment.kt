package com.example.innobuzztask.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.innobuzztask.MainActivity
import com.example.innobuzztask.R
import com.example.innobuzztask.adapter.NetworkAdapter
import com.example.innobuzztask.databinding.FragmentHomeBinding
import com.example.innobuzztask.model.ResponseDataModelItem
import com.example.innobuzztask.viewModel.DataViewModel


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel :DataViewModel
    private lateinit var networkAdapter: NetworkAdapter
    private lateinit var list:MutableList<ResponseDataModelItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewmodel

        list = mutableListOf()
        viewModel.getData.observe(viewLifecycleOwner, Observer {

            it.data?.forEach {
                viewModel.saveData(ResponseDataModelItem(it.body,it.id,it.title,it.userId))
            }
//            Toast.makeText(requireContext(), it.data?.get(0)?.body.toString(), Toast.LENGTH_SHORT).show()
        })

        viewModel.getAllDataLocally().observe(viewLifecycleOwner, Observer {
            binding.titleRv.apply {
                adapter = NetworkAdapter(it)
                layoutManager = LinearLayoutManager(activity)
            }
        })




    }


}