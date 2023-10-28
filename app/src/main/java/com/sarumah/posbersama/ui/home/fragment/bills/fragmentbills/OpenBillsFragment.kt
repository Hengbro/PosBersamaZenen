package com.sarumah.posbersama.ui.home.fragment.bills.fragmentbills

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sarumah.posbersama.databinding.FragmentEmptyBinding
import com.sarumah.posbersama.databinding.FragmentOpenbillsBinding

class OpenBillsFragment : Fragment() {

    private var _binding: FragmentOpenbillsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOpenbillsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}