package com.example.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Science
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.AquaticPlant
import com.example.ui.components.InteractiveDimorphismSlider
import com.example.ui.components.WrgbSpectrumVisualizer
import com.example.viewmodel.UiState

@Composable
fun DimorphismLabScreen(
    plants: List<AquaticPlant>,
    selectedPlant: AquaticPlant,
    uiState: UiState,
    onSelectPlant: (String) -> Unit,
    onSplitRatioChange: (Float) -> Unit,
    onParChange: (Float) -> Unit,
    onRedChange: (Float) -> Unit,
    onGreenChange: (Float) -> Unit,
    onBlueChange: (Float) -> Unit,
    onWhiteChange: (Float) -> Unit,
    onToggleNitrate: () -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(vertical = 16.dp)
    ) {
        // হেডার
        item {
            Card(
                modifier = Modifier.fillMaxWidth().testTag("dimorphism_lab_header"),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                )
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Science,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(22.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "🔬 ডাইমরফিজম ও স্পেকট্রাম ল্যাবরেটরি",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "যেকোনো উদ্ভিদ নির্বাচন করে তার এমর্সড (জলের বাইরের আর্দ্র রূপ) বনাম নিমজ্জিত রূপের স্প্লিট স্লাইডার তুলনা করুন এবং WRGB আলোক বর্ণালীর প্রতিক্রিয়ায় পিগমেন্টেশনের রূপান্তর পর্যবেক্ষণ করুন।",
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        lineHeight = 16.sp
                    )
                }
            }
        }

        // উদ্ভিদ নির্বাচন চিপস
        item {
            Column {
                Text(
                    text = "উদ্ভিদ নির্বাচন করুন:",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(8.dp))
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(plants, key = { it.id }) { plant ->
                        FilterChip(
                            selected = plant.id == selectedPlant.id,
                            onClick = { onSelectPlant(plant.id) },
                            label = { Text(plant.commonNameBn.split(" ")[0], fontSize = 11.sp) },
                            modifier = Modifier.testTag("select_plant_${plant.id}")
                        )
                    }
                }
            }
        }

        // ইন্টারেক্টিভ স্প্লিট স্লাইডার
        item {
            InteractiveDimorphismSlider(
                dimorphism = selectedPlant.dimorphism,
                splitRatio = uiState.emersedSubmersedSplitRatio,
                onRatioChange = onSplitRatioChange
            )
        }

        // WRGB স্পেকট্রাম প্রতিক্রিয়া সিমুলেটর
        item {
            WrgbSpectrumVisualizer(
                dimorphism = selectedPlant.dimorphism,
                par = uiState.parLevel,
                red660 = uiState.red660Intensity,
                green = uiState.greenIntensity,
                blue450 = uiState.blue450Intensity,
                white = uiState.whiteIntensity,
                isNitrateLimited = uiState.isNitrateLimited,
                onParChange = onParChange,
                onRedChange = onRedChange,
                onGreenChange = onGreenChange,
                onBlueChange = onBlueChange,
                onWhiteChange = onWhiteChange,
                onToggleNitrate = onToggleNitrate
            )
        }
    }
}
