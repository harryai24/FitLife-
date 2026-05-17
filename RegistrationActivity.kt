// In D:/AMD/FitnessApp/app/src/main/java/com/np/hemant_baduwal/application/registration/RegisterActivity.kt

package com.np.hemant_baduwal.application.registration

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
// Make sure these are imported
import com.np.hemant_baduwal.application.ui.theme.FitnessAppTheme

class RegisterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Apply your app's theme for consistent styling
            FitnessAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Corrected: Call RegistrationPage with only the parameters it expects.
                    // Both "success" and "navigate back" will now do the same thing: close this screen.
                    RegistrationPage(
                        onNavigateToLogin = {
                            // Navigate back to the login screen
                            finish()
                        }
                    )
                }
            }
        }
    }
}
