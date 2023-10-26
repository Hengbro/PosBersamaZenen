package com.sarumah.posbersama.ui.home.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sarumah.posbersama.databinding.FragmentTablesBinding
import com.sarumah.posbersama.ui.home.fragment.librarys.LibrarysViewModel
import com.sarumah.posbersama.ui.home.fragment.librarys.adapter.LibrarysAdapter

class TablesFragment : Fragment() {

    private var _binding: FragmentTablesBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTablesBinding.inflate(inflater, container, false)


        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}