package com.example.innobuzztask.fragment

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.innobuzztask.R
import com.example.innobuzztask.databinding.FragmentContentBinding


class ContentFragment : Fragment() {
    private lateinit var binding: FragmentContentBinding
    private lateinit var title: String
    private lateinit var body: String
    private var uid: Int = 0
    private var userId: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

            title = requireArguments().getString("title").toString()
            body = requireArguments().getString("body").toString()
            uid = requireArguments().getInt("id")
            userId = requireArguments().getInt("userId")

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentContentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.mtitle.text = title.toString()
        binding.mbody.text = body.toString()
        binding.mUserid.text = userId.toString()
        binding.mid.text = uid.toString()

        binding.allowPermissionBtn.setOnClickListener {
            startActivity(Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS))
        }
    }

}