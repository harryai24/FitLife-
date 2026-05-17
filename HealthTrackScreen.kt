package com.np.hemant_baduwal.application.NavigationBar

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.np.hemant_baduwal.application.R

// Data class for health metrics, for the former RecyclerView
data class HealthMetric(val name: String, val value: String, val unit: String)

@Composable
fun HealthTrackScreen() {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5)) // background color from XML
            .verticalScroll(scrollState)
            .padding(16.dp)
    ) {
        Text(
            text = stringResource(id = R.string.health_tracking),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Text(
            text = stringResource(id = R.string.monitor_health_metrics),
            fontSize = 14.sp,
            color = Color(0xFF757575), // gray_600
            modifier = Modifier.padding(top = 4.dp, bottom = 16.dp)
        )

        TodaysSummaryCard()

        Text(
            text = stringResource(id = R.string.health_metrics),
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = Modifier.padding(top = 16.dp, bottom = 12.dp)
        )

        HealthMetricsList()
    }
}

@Composable
fun TodaysSummaryCard() {
    OutlinedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(2.dp, Color(0xFFE0E0E0)), // gray_300
    ) {
        Column(
            modifier = Modifier
                .background(Color.White)
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = stringResource(id = R.string.todays_summary),
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier.padding(bottom = 12.dp)
            )

            MetricProgress(title = stringResource(id = R.string.steps), value = "8,547", goal = " / 10,000 steps", progress = 0.85f)
            MetricProgress(title = stringResource(id = R.string.calories_burned), value = "450", goal = " / 600 kcal", progress = 0.75f)
            MetricProgress(title = stringResource(id = R.string.water_intake), value = "6", goal = " / 8 glasses", progress = 0.75f, isLast = true)
        }
    }
}

@Composable
fun MetricProgress(title: String, value: String, goal: String, progress: Float, isLast: Boolean = false) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            fontSize = 14.sp,
            color = Color(0xFF757575), // gray_600
            modifier = Modifier.weight(1f)
        )
        Text(text = value, fontWeight = FontWeight.Bold)
        Text(text = goal, color = Color(0xFF757575)) // gray_600
    }

    Spacer(modifier = Modifier.height(8.dp))

    LinearProgressIndicator(
        progress = progress,
        modifier = Modifier
            .fillMaxWidth()
            .height(12.dp)
            .clip(RoundedCornerShape(6.dp))
    )

    if (!isLast) {
        Spacer(modifier = Modifier.height(12.dp))
    }
}

@Composable
fun HealthMetricsList() {
    // This is a placeholder for the RecyclerView content.
    val metrics = listOf(
        HealthMetric("Heart Rate", "72", "bpm"),
        HealthMetric("Blood Pressure", "120/80", "mmHg"),
        HealthMetric("Sleep", "7.5", "hours")
    )
    Column {
        metrics.forEach { metric ->
            HealthMetricItem(metric)
        }
    }
}

@Composable
fun HealthMetricItem(metric: HealthMetric) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = metric.name, modifier = Modifier.weight(1f))
        Text(text = metric.value, fontWeight = FontWeight.Bold, fontSize = 16.sp)
        Spacer(modifier = Modifier.padding(horizontal = 2.dp))
        Text(text = metric.unit, color = Color.Gray)
    }
}
