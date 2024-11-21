package com.example.p5.model

import android.provider.ContactsContract.CommonDataKinds.Email

data class DataSiswa(
    val nama: String = "", //memakai val karna nilainya tetap satu
    val nim: String = "",
    val alamat: String = "",
    val gender: String = "",
    val email: String = "",
    val notelepon: String = ""
)
