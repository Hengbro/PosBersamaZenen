package com.sarumah.posbersama.ui.menu.listmenu.productinventory.modifiersoptions

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sarumah.posbersama.databinding.ActivityAddNewmodifiersBinding
import com.sarumah.posbersama.databinding.ActivityEmptyBinding

class AddModifiersActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddNewmodifiersBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNewmodifiersBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}