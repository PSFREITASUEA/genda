package com.genda.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.genda.databinding.FragmentCreateEventBinding

class CreateEventFragment : Fragment() {

    private lateinit var binding: FragmentCreateEventBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCreateEventBinding.inflate(inflater, container, false)
        return binding.root
    }
}