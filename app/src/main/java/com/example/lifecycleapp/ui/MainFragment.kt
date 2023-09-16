package com.example.lifecycleapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.lifecycleapp.databinding.FragmentMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainFragment : Fragment() {
    private lateinit var binding : FragmentMainBinding
    private lateinit var viewModel: MainViewModel

    companion object {
        val TAG: String = "MainFragment"
        fun newInstance() = MainFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        binding = FragmentMainBinding.inflate(layoutInflater)
        binding.tvFragment.text = "text changed dynamically"

//        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]      // using indexing operator

        viewModel.users.observe(viewLifecycleOwner) {
            binding.tvFragment.text = it?.toString()
            Log.i("MyTag", "users: ${it.toString()}")
        }

        return binding.root
    }

}