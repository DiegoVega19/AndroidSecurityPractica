package com.example.andsecurity.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.andsecurity.Model.Login
import com.example.andsecurity.Model.Register
import com.example.andsecurity.repository.MainRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class RegisterViewModel(private val mainRepository: MainRepository):ViewModel() {
    val myResponse: MutableLiveData<Response<Register>> = MutableLiveData()
    fun RegisterUser(register: Register) {
        viewModelScope.launch {
            val response: Response<Register> = mainRepository.registerUser(register)
            myResponse.value = response
        }

    }
}
class registerViewModelFactory(private  val mainRepository: MainRepository):ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return RegisterViewModel(mainRepository) as T
    }

}