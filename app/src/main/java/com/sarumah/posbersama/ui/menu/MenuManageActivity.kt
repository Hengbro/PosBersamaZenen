package com.sarumah.posbersama.ui.menu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.inyongtisto.myhelper.extension.intentActivity
import com.sarumah.posbersama.databinding.ActivityMainmenuBinding
import com.sarumah.posbersama.ui.home.HomeActivity

class MenuManageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainmenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainmenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainButton()
    }

    private fun mainButton(){

        binding.apply {
            btnImageclose.setOnClickListener {
                intentActivity(HomeActivity::class.java)
            }
        }

    }

}