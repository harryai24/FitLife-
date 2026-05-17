package com.np.hemant_baduwal.application

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.np.hemant_baduwal.application.NavigationBar.MainScreen
import com.np.hemant_baduwal.application.login.LoginPage
import com.np.hemant_baduwal.application.registration.RegistrationPage
import com.np.hemant_baduwal.application.ui.theme.FitnessAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FitnessAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyAppNavigation()
                }
            }
        }
    }
}

@Composable
fun MyAppNavigation() {
    val navController = rememberNavController()
    val context = LocalContext.current // Get context here
    NavHost(navController = navController, startDestination = "login", modifier = Modifier.fillMaxSize()) {
        composable("login") {
            LoginPage(
                onNavigateToRegister = {
                    navController.navigate("register")
                },
                onValidationSuccess = { email, password ->
                    // Navigate to the main screen and clear the back stack
                    navController.navigate("main") {
                        popUpTo("login") {
                            inclusive = true
                        }
                    }
                },
                onForgotPasswordClicked = {
                    // Use the context variable here
                    Toast.makeText(context, "Forgot Password Clicked!", Toast.LENGTH_SHORT).show()
                }
            )
        }
        composable("register") {
            RegistrationPage(
                onNavigateToLogin = {
                    navController.popBackStack()
                }
            )
        }
        composable("main") {
            MainScreen()
        }
    }
}
