package com.sarumah.posbersama.ui.menu.listmenu.productinventory.productlist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sarumah.posbersama.databinding.ActivityAddnewproductBinding
import com.sarumah.posbersama.databinding.ActivityEmptyBinding

class AddProductActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddnewproductBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddnewproductBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}