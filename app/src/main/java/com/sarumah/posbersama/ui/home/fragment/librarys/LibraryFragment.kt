package com.sarumah.posbersama.ui.home.fragment.librarys

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.sarumah.posbersama.databinding.FragmentLibraryBinding
import com.sarumah.posbersama.ui.home.fragment.librarys.adapter.LibrarysAdapter

class LibraryFragment : Fragment() {

    private var _binding: FragmentLibraryBinding? = null
    private lateinit var viewModel: LibrarysViewModel


    private val  adapterLibrary = LibrarysAdapter()
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(requireActivity()).get(LibrarysViewModel::class.java)

        _binding = FragmentLibraryBinding.inflate(inflater, container, false)



        setupAdapter()
        setupDataCategories()
        return binding.root
    }

    private fun setupAdapter(){
        binding.apply {
            rvCategories.adapter = adapterLibrary
        }
    }

    private fun setupDataCategories(){
        viewModel.listCategories.observe(requireActivity()) {
            adapterLibrary.addItems(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}