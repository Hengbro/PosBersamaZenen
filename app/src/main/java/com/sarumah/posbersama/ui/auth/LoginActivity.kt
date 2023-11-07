package com.sarumah.posbersama.ui.auth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.inyongtisto.myhelper.extension.getString
import com.inyongtisto.myhelper.extension.pushActivity
import com.inyongtisto.myhelper.extension.toastError
import com.inyongtisto.myhelper.extension.toastSuccess
import com.sarumah.posbersama.core.source.remote.network.State
import com.sarumah.posbersama.core.source.remote.request.LoginRequest
import com.sarumah.posbersama.databinding.ActivityLoginBinding
import com.sarumah.posbersama.ui.home.HomeActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity() {

    private val viewModel: AuthViewModel by viewModel()
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainButton()
    }

    private fun mainButton() {
        binding.apply {
            btnLogin.setOnClickListener {
                login()
            }

            btnLogin.setOnLongClickListener {
                edtEmail.setText("admin@gmail.com")
                edtPassword.setText("admin123")
                return@setOnLongClickListener true
            }
        }
    }

    private fun login() {
        val request = LoginRequest(
            email = binding.edtEmail.getString(),
            password = binding.edtPassword.getString()
        )
        viewModel.login(request).observe(this) {
            when (it.state) {
                State.SUCCESS -> {
                    val body = it.body
                    toastSuccess("Halo, " + body?.name)
                    pushActivity(HomeActivity::class.java)
                }

                State.ERROR -> {
                    toastError(it.message)
                }

                State.LOADING -> {

                }
            }
        }
    }
}