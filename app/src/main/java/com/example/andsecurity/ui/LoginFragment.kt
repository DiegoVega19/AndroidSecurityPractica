package com.example.andsecurity.ui

import android.os.Bundle
import android.os.Debug
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.andsecurity.Model.Login
import com.example.andsecurity.R
import com.example.andsecurity.databinding.FragmentLoginBinding
import com.example.andsecurity.presentation.LoginViewModel
import com.example.andsecurity.presentation.LoginViewModelFactory
import com.example.andsecurity.repository.MainRepository


class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private  lateinit var  viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val repository = MainRepository()
        val viewModelFactory = LoginViewModelFactory(repository)
        setupListeners()
    }

    private fun setupListeners() {
        binding.btnLogin.setOnClickListener {
            if (binding.etUsername.text!!.isEmpty() ){
                binding.etUsername.error = "Username Requerido"
                return@setOnClickListener
            }
            if(binding.etPassword.text!!.isEmpty()){
                binding.etPassword.error = "Password Requerido"
                return@setOnClickListener
            }

            makelogin()

        }
        binding.tvRegister.setOnClickListener {
            goToRegister()
        }
    }

    private fun makelogin() {
        val username = binding.etUsername.text.toString()
        val password = binding.etPassword.text.toString()
        //val login = Login(email,password)
        Log.d("DATA_LOGIN", "My username is $username and my Password is $password")
        //When the backend is finished place view model and methods calls here
        //If the login is sucessfull go to home
        goToHome()
    }

    private fun goToHome() {
        findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
    }
    private fun goToRegister(){
        findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
    }


}