package com.sarumah.posbersama.ui.menu.listmenu.productinventory.variantoptions

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sarumah.posbersama.databinding.ActivityAddnewvariantsBinding
import com.sarumah.posbersama.databinding.ActivityEmptyBinding

class AddVariationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddnewvariantsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddnewvariantsBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}