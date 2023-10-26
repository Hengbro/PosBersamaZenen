package com.sarumah.posbersama.ui.menu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sarumah.posbersama.databinding.ActivityCustomizenavbarBinding
import com.sarumah.posbersama.databinding.ActivityEmptyBinding

class CustomizeNavbarActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCustomizenavbarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomizenavbarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainButton()
    }

    private fun mainButton(){
        binding.apply {
            btnClose.setOnClickListener {
                onBackPressedDispatcher.onBackPressed()
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return super.onSupportNavigateUp()
    }

}