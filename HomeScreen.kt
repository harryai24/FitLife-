package com.np.hemant_baduwal.application.NavigationBar

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.np.hemant_baduwal.application.R

// 1. Data class for the workout plan
data class WorkoutPlan(val name: String, val imageUrl: String)

// 2. Sample data
val recommendedPlans = listOf(
    WorkoutPlan("Full Body", "https://images.unsplash.com/photo-1571019613454-1cb2f99b2d8b?q=80&w=3540&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"),
    WorkoutPlan("Arm Day", "https://images.unsplash.com/photo-1616279967983-ec413476e824?q=80&w=3540&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"),
    WorkoutPlan("Leg Day", "https://images.unsplash.com/photo-1599423421379-10b84b553653?q=80&w=3387&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"),
    WorkoutPlan("Cardio", "https://images.unsplash.com/photo-1538805451294-f273b5c49097?q=80&w=3540&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D")
)

@Composable
fun HomeScreen() {
    // We keep the Scaffold for the Floating Action Button
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { /* TODO: Handle add workout plan */ }) {
                Icon(Icons.Default.Add, contentDescription = "Add workout plan")
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            // 3. Recommended Plans Section
            Text(
                text = stringResource(id = R.string.recommended_plans),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(16.dp))
            LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                items(recommendedPlans) { plan ->
                    WorkoutPlanCard(plan)
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            // You can add other sections of your home screen here

        }
    }
}

@Composable
fun WorkoutPlanCard(plan: WorkoutPlan) {
    Card(modifier = Modifier.size(width = 200.dp, height = 250.dp)) {
        Column {
            Image(
                painter = rememberAsyncImagePainter(plan.imageUrl),
                contentDescription = plan.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp),
                contentScale = ContentScale.Crop
            )
            Box(modifier = Modifier.padding(12.dp), contentAlignment = Alignment.Center) {
                Text(plan.name, style = MaterialTheme.typography.titleMedium)
            }
        }
    }
}
