package com.np.hemant_baduwal.application.login

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.np.hemant_baduwal.application.NavigationBar.MainScreen
import com.np.hemant_baduwal.application.registration.RegisterActivity
import com.np.hemant_baduwal.application.ui.theme.FitnessAppTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FitnessAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val context = LocalContext.current

                    LoginPage(
                        onNavigateToRegister = {
                            val intent = Intent(context, RegisterActivity::class.java)
                            context.startActivity(intent)
                        },
                        onValidationSuccess = { email, password ->
                            setContent {
                                FitnessAppTheme {
                                    Surface(
                                        modifier = Modifier.fillMaxSize(),
                                        color = MaterialTheme.colorScheme.background
                                    ) {
                                        MainScreen()
                                    }
                                }
                            }
                        },
                        onForgotPasswordClicked = {
                            // TODO: Implement forgot password screen navigation
                        }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    FitnessAppTheme {
        LoginPage(
            onNavigateToRegister = {},
            onValidationSuccess = {email, password ->},
            onForgotPasswordClicked = {}
        )
    }
}