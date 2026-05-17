package com.np.hemant_baduwal.application.NavigationBar

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {

    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            TopAppBar(title = { Text("FitnessApp") })
        },
        bottomBar = { BottomNavigationBar(navController) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.rout,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.rout) { HomeScreen() }
            composable(Screen.Profile.rout) { ProfileScreen() }
            composable(Screen.Calendar.rout) { CalendarScreen() }
            composable(Screen.HealthTrack.rout) { HealthTrackScreen() }
        }
    }
}