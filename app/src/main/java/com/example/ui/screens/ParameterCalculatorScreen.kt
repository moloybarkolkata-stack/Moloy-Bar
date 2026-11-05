package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.AquaticPlant
import com.example.viewmodel.Co2Status
import com.example.viewmodel.UiState
import kotlin.math.roundToInt

@Composable
fun ParameterCalculatorScreen(
    uiState: UiState,
    co2Ppm: Float,
    co2Status: Co2Status,
    matchedPlants: List<AquaticPlant>,
    onPhChange: (Float) -> Unit,
    onKhChange: (Float) -> Unit,
    onGhChange: (Float) -> Unit,
    onTempChange: (Int) -> Unit,
    onParChange: (Float) -> Unit,
    onSelectPlant: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(vertical = 16.dp)
    ) {
        // ১. হেডার ইন্ট্রো
        item {
            Card(
                modifier = Modifier.fillMaxWidth().testTag("parameter_matcher_header"),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                )
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Calculate,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(22.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "প্যারামিটার ম্যাচিং ও CO₂ ক্যালকুলেটর",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "আপনার অ্যাকোয়ারিয়ামের পানি ও আলোর প্যারামিটার নির্বাচন করুন; সিস্টেম স্বয়ংক্রিয়ভাবে দ্রবীভূত CO₂ নির্ণয় করবে এবং আপনার ট্যাঙ্কের জন্য শতভাগ উপযুক্ত উদ্ভিদের তালিকা উপস্থাপন করবে।",
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        lineHeight = 16.sp
                    )
                }
            }
        }

        // ২. রিয়েলটাইম CO2 ফলাফল গেজ
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF071B24)
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "দ্রবীভূত কার্বন ডাই অক্সাইড (Dissolved CO₂)",
                        fontSize = 13.sp,
                        color = Color.White.copy(alpha = 0.8f)
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "$co2Ppm",
                            fontSize = 44.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color(co2Status.colorHex)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "ppm",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White.copy(alpha = 0.8f),
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(6.dp))
                    Surface(
                        shape = RoundedCornerShape(20.dp),
                        color = Color(co2Status.colorHex).copy(alpha = 0.2f)
                    ) {
                        Text(
                            text = co2Status.labelBn,
                            color = Color(co2Status.colorHex),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = "সূত্র: CO₂ (ppm) = ৩.০ × KH × ১০^(৭.০ - pH)",
                        fontSize = 11.sp,
                        color = Color.White.copy(alpha = 0.5f)
                    )
                }
            }
        }

        // ৩. ইন্টারেক্টিভ স্লাইডার ইনপুট কন্ট্রোল
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                )
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "🎛️ ট্যাঙ্কের প্যারামিটার সমন্বয় করুন",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Spacer(modifier = Modifier.height(14.dp))

                    // pH স্লাইডার
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("পানির অম্লত্ব (pH)", fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
                        Text("${((uiState.inputPh * 10).roundToInt() / 10f)}", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
                    }
                    Slider(
                        value = uiState.inputPh,
                        onValueChange = onPhChange,
                        valueRange = 5.0f..8.5f,
                        steps = 34,
                        modifier = Modifier.height(26.dp).testTag("calc_ph_slider")
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    // KH স্লাইডার
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("কার্বোনেট ক্ষারত্ব (KH dKH)", fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
                        Text("${((uiState.inputKh * 10).roundToInt() / 10f)} dKH", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color(0xFF48CAE4))
                    }
                    Slider(
                        value = uiState.inputKh,
                        onValueChange = onKhChange,
                        valueRange = 0.5f..15.0f,
                        steps = 28,
                        colors = SliderDefaults.colors(
                            thumbColor = Color(0xFF48CAE4),
                            activeTrackColor = Color(0xFF48CAE4)
                        ),
                        modifier = Modifier.height(26.dp).testTag("calc_kh_slider")
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    // তাপমাত্রা স্লাইডার
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("পানির তাপমাত্রা (°C)", fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
                        Text("${uiState.inputTempC}° সে.", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color(0xFFFFA726))
                    }
                    Slider(
                        value = uiState.inputTempC.toFloat(),
                        onValueChange = { onTempChange(it.roundToInt()) },
                        valueRange = 18f..32f,
                        steps = 13,
                        colors = SliderDefaults.colors(
                            thumbColor = Color(0xFFFFA726),
                            activeTrackColor = Color(0xFFFFA726)
                        ),
                        modifier = Modifier.height(26.dp).testTag("calc_temp_slider")
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    // আলো (PAR) স্লাইডার
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("আলোর তীব্রতা (PAR)", fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
                        Text("${uiState.inputPar.roundToInt()} µmol/m²/s", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color(0xFFFFD166))
                    }
                    Slider(
                        value = uiState.inputPar,
                        onValueChange = onParChange,
                        valueRange = 20f..140f,
                        colors = SliderDefaults.colors(
                            thumbColor = Color(0xFFFFD166),
                            activeTrackColor = Color(0xFFFFD166)
                        ),
                        modifier = Modifier.height(26.dp).testTag("calc_par_slider")
                    )
                }
            }
        }

        // ৪. উপযুক্ত উদ্ভিদের তালিকা (Matched Plants)
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "🌿 আপনার ট্যাঙ্কের সাথে মানানসই উদ্ভিদ (${matchedPlants.size} টি)",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }

        items(matchedPlants, key = { it.id }) { plant ->
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .clickable { onSelectPlant(plant.id) }
                    .testTag("matched_plant_${plant.id}"),
                color = MaterialTheme.colorScheme.surfaceVariant
            ) {
                Row(
                    modifier = Modifier.padding(14.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(10.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.primary)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = plant.commonNameBn,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Text(
                            text = plant.scientificName,
                            fontSize = 12.sp,
                            fontStyle = FontStyle.Italic,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = "অনুকূল তাপমাত্রা: ${plant.cultivation.tempOptimalC} | pH: ${plant.cultivation.phRange}",
                            fontSize = 11.sp,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                    Icon(
                        imageVector = Icons.Default.ChevronRight,
                        contentDescription = "প্রোফাইল দেখুন",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}
