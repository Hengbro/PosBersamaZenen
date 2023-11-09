package com.sarumah.posbersama.ui.menu.listmenu.menudiscount

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sarumah.posbersama.databinding.ActivityEmptyBinding

class DiscountMenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEmptyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmptyBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}