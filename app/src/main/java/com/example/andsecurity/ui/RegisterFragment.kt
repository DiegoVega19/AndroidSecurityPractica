package com.example.andsecurity.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.andsecurity.Model.Register
import com.example.andsecurity.R
import com.example.andsecurity.databinding.FragmentRegisterBinding
import com.example.andsecurity.presentation.LoginViewModel
import com.example.andsecurity.presentation.LoginViewModelFactory
import com.example.andsecurity.presentation.RegisterViewModel
import com.example.andsecurity.presentation.registerViewModelFactory
import com.example.andsecurity.repository.MainRepository


class RegisterFragment : Fragment() {
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!
    private  lateinit var  viewModel: RegisterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val repository = MainRepository()
        val viewModelFactory = registerViewModelFactory(repository)
        setupListeners()
    }

    private fun setupListeners() {
        binding.btnRegister.setOnClickListener {
            if (binding.etUserName.text!!.isEmpty() ){
                binding.etUserName.error = "Username Requerido"
                return@setOnClickListener
            }
            if(binding.etPass.text!!.isEmpty()){
                binding.etPass.error = "Password Requerido"
                return@setOnClickListener
            }
            if(binding.etFullname.text!!.isEmpty()){
                binding.etFullname.error = "Fullname Requerido"
                return@setOnClickListener
            }

            makeRegister()

        }
    }

    private fun makeRegister() {
        val username = binding.etUserName.text.toString()
        val password = binding.etPass.text.toString()
        val fullname = binding.etFullname.text.toString()
       // val register = Register(username,password,fullname)
        Log.d("DATA_REGISTER", "My username is $username, my Password is $password and my fullname is $fullname")
        //When the backend is finished place view model and methods calls here
        //If the register is sucessfull go to home
        goToHome()
    }
    private fun goToHome() {
        findNavController().navigate(R.id.action_registerFragment_to_homeFragment)
    }

}