package com.example.mylistapi.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mylistapi.Data.Employee
import com.example.mylistapi.Repo.EmployeeRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class EmployeeVM @Inject constructor(private  val repository:EmployeeRepo) : ViewModel() {


 private  val  _response = MutableLiveData<List<Employee>>()

    val employeeName:LiveData<List<Employee>>
    get() = _response


    init {
        getEmployeeList()
    }


     fun getEmployeeList()=
            viewModelScope.launch {
                    repository.getAllEmployee().let {
                        if (it.isSuccessful){

                            _response.postValue(it.body()?.data)
                        } else{
                            Log.d("EXCEPTION", "${it.message().toString()}")

                        }
                    }
            }
  /*      viewModelScope.launch {
        try {
            val emp = repository.getAllEmployee()
            _response.value = emp.body()!!.data
        } catch (e:Exception){

        }
    }
*/


/*  private  fun  getEmployeeList() = viewModelScope.launch {
        repository.getAllEmployee().let {
            if (it.isSuccessful){
                _response.
            } else{

                Log.d("EXCEPTION", "${it.body()}")

            }
        }
  }*/





/*    var employeeList: List<Data> = mutableListOf()
    var job: Job? = null
    val apiService = ApiService.getInstance()


    fun getAllEmployee(){

        job = CoroutineScope(Dispatchers.IO).launch {
                val response =  apiService.getEmployeeList()
            withContext(Dispatchers.Main){
                if (response.isSuccessful){
                    employeeList = response.body()!!
                } else{

                }
            }
        }
    }*/

}