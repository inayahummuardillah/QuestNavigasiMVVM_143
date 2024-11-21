package com.example.p5.viewmodel

import androidx.lifecycle.ViewModel
import com.example.p5.model.DataSiswa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SiswaViewModel : ViewModel(){

    //request
    private val _statusUI = MutableStateFlow(DataSiswa())

    //response
    val statusUI: StateFlow<DataSiswa> = _statusUI.asStateFlow()

    fun saveDataSiswa(ls: MutableList<String>) {
        _statusUI.update { statusSaatIni -> //isi sebuah model yaitu data siswa
            statusSaatIni.copy(
                nama = ls[0],
                nim = ls[1],
                gender = ls[2],
                alamat = ls[3],
                email = ls[4],
                notelepon = ls[5]
            )
        }
    }
}