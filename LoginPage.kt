package com.np.hemant_baduwal.application.login

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.np.hemant_baduwal.application.ui.theme.FitnessAppTheme

@Composable
fun LoginPage(
    modifier: Modifier = Modifier,
    onValidationSuccess: (String, String) -> Unit,
    onForgotPasswordClicked:() -> Unit,
    onNavigateToRegister: () -> Unit
) {
    var gmail by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    var emailError by remember { mutableStateOf(false) }
    var formMessage by remember { mutableStateOf<Pair<String, Color>?>(null) }

    val emailRegex = Regex("""[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}""")

    // SOLUTION: Read the theme color here, in the @Composable scope.
    val errorColor = MaterialTheme.colorScheme.error

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Icon(
            imageVector = Icons.Default.Lock,
            contentDescription = "Login lock",
            modifier = Modifier.size(64.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "Login Page", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = gmail,
            onValueChange = {
                gmail = it
                emailError = false
                formMessage = null
            },
            label = { Text("Gmail") },
            modifier = Modifier.fillMaxWidth(),
            isError = emailError
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
                formMessage = null
            },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        formMessage?.let { (message, color) ->
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = message, color = color, style = MaterialTheme.typography.bodyMedium)
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                when {
                    gmail.isBlank() || password.isBlank() -> {
                        // Use the variable here
                        formMessage = Pair("Please fill all fields.", errorColor)
                    }
                    !gmail.matches(emailRegex) -> {
                        emailError = true
                        // Use the variable here as well
                        formMessage = Pair("Invalid email format.", errorColor)
                    }
                    else -> {
                        emailError = false
                        formMessage = Pair("Login Successful!", Color.Green)
                        onValidationSuccess(gmail, password)
                    }
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Login")
        }

        TextButton(onClick = onNavigateToRegister) {
            Text("Don\'t have an account? Register")
        }
    }
}

@Composable
fun ForgotPassword(onForgotPasswordClicked: () -> Unit) {
        TextButton(onClick = onForgotPasswordClicked) {
        Text(text = "Forgot Password?")
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPagePreview() {
    FitnessAppTheme {
        LoginPage(onNavigateToRegister = {},
            onValidationSuccess = { email, password -> },
            onForgotPasswordClicked = {})
    }
}
