package com.sarumah.posbersama.ui.home.orderproduct

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.sarumah.posbersama.databinding.ActivityOrderProductBinding
import com.sarumah.posbersama.ui.home.orderproduct.adapter.TexassAdapter
import com.sarumah.posbersama.ui.home.orderproduct.adapter.TopingsAdapter
import com.sarumah.posbersama.ui.home.orderproduct.adapter.VariationsAdapter

class OrderProductActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOrderProductBinding
    private lateinit var viewModel : OrderProductViewModel
    private val adapterVariations = VariationsAdapter()
    private val adaptterTopings = TopingsAdapter()
    private val adapterTexass = TexassAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(OrderProductViewModel::class.java)
        binding = ActivityOrderProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainButton()
        setAdapter()
        setDataVariation()
        setDataTopings()
        setDataTaxes()
        setData()

    }

    private fun mainButton(){
        binding.apply {
            btnClear.setOnClickListener {
                onBackPressedDispatcher.onBackPressed()
            }
        }
    }

    private fun setData(){
        val messager = intent.getStringExtra("themessage")
        binding.txtNameproduct.apply {
            text = messager
        }
    }

    private fun setAdapter(){
        binding.apply {
            rvVariation.adapter = adapterVariations
            rvTopings.adapter = adaptterTopings
            rvTaxes.adapter = adapterTexass
        }
    }

    private fun setDataVariation(){
        viewModel.listVariations.observe(this){
            adapterVariations.addItems(it)
        }
    }

    private fun setDataTopings(){
        viewModel.listTopings.observe(this){
            adaptterTopings.addItems(it)
        }
    }

    private fun setDataTaxes(){
        viewModel.listTexass.observe(this){
            adapterTexass.addItems(it)
        }
    }

}