package com.example.andsecurity.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.andsecurity.Model.Login
import com.example.andsecurity.repository.MainRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class LoginViewModel(private val mainRepository: MainRepository) : ViewModel() {


    val myResponse: MutableLiveData<Response<Login>> = MutableLiveData()


    fun LoginUser(login: Login) {
        viewModelScope.launch {
            val response: Response<Login> = mainRepository.loginUser(login)
            myResponse.value = response
        }

    }


}
class LoginViewModelFactory(private  val repository: MainRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LoginViewModel(repository) as T
    }
}