package com.example.p5.ui.theme.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.p5.model.DataSiswa

@Composable
fun TampilDataview(
    modifier: Modifier,
    uiState:  DataSiswa,
    onBackButton: () -> Unit
){
    Column(
        modifier = Modifier
        .fillMaxSize()
        .padding()

    ) {
        TampilData(param = "Nama", argu = uiState.nama)
        TampilData(param = "nim", argu = uiState.nim)
        TampilData(param = "Jenis Kelamin", argu = uiState.gender)
        TampilData(param = "email", argu = uiState.email)
        TampilData(param = "Alamat", argu = uiState.alamat)

        Button(onClick = onBackButton) {
            Text(text = "kembali")
        }
    }
}

@Composable
fun TampilData(
    param: String,
    argu: String
) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = param,
                modifier = Modifier.weight(0.8f), color = Color.Black)
            Text(
                text = ": ",
                modifier = Modifier.weight(0.2f), color = Color.Black)
            Text(
                text = argu,
                modifier = Modifier.weight(2f), color = Color.Black)
        }
    }
}