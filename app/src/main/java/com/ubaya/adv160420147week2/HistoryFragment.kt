package com.ubaya.adv160420147week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ubaya.adv160420147week2.databinding.FragmentHistoryBinding
import com.ubaya.adv160420147week2.databinding.FragmentProfileBinding

class HistoryFragment : Fragment() {
    private lateinit var binding: FragmentHistoryBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHistoryBinding.inflate(
            inflater, container, false
        )
        return binding.root
    }

}