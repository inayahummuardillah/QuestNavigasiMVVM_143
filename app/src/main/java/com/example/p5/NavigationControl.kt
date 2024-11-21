package com.example.p5

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.p5.model.JenisKelamin
import com.example.p5.model.JenisKelamin.jenisKelamin
import com.example.p5.ui.theme.view.TampilData
import com.example.p5.ui.theme.view.TampilDataview
import com.example.p5.viewmodel.SiswaViewModel

enum class Halaman{
    FORMULIR,
    TAMPILDATA
}

@Composable
fun NavigationControl(
    modifier: Modifier = Modifier,
    viewModel: SiswaViewModel = viewModel(),
    navHost: NavHostController = rememberNavController()
){
    val uiState by viewModel.statusUI.collectAsState()

    NavHost (
        navController = navHost,
        startDestination = Halaman.FORMULIR.name
    ){
        composable(
            route = Halaman.FORMULIR.name
        ) {
            val konteks = LocalContext.current
            FormulirView(
                listJK =jenisKelamin.map { id ->
                    konteks.getString(id)
                },
                onSubmitClicked = {
                    viewModel.saveDataSiswa(it)
                    navHost.navigate(Halaman.TAMPILDATA.name)
                }
            )
        }
        composable(route = Halaman.TAMPILDATA.name){
            TampilDataview(modifier = Modifier,
                uiState = uiState,
                onBackButton =
                { navHost.popBackStack() }
            )
        }
    }
}