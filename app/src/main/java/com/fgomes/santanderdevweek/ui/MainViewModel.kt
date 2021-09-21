package com.fgomes.santanderdevweek.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fgomes.santanderdevweek.data.Conta
import com.fgomes.santanderdevweek.data.local.FakeData

class MainViewModel : ViewModel() {

    private val mutableLiveData: MutableLiveData<Conta> = MutableLiveData()

    fun getContaCliente() : LiveData<Conta> {
        mutableLiveData.value = FakeData().getLocalData()

        return mutableLiveData
    }

}