package com.genda

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.genda.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        setupClickListeners()

        return binding.root
    }

    private fun setupClickListeners() {
        binding.floatingActionButtonCreateEvent.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionFragmentHomeToFragmentCreateEvent())
        }
    }
}