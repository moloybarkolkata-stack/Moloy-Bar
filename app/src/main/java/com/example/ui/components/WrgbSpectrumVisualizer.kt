package com.example.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Science
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.DimorphismSpectrum
import kotlin.math.roundToInt

@Composable
fun WrgbSpectrumVisualizer(
    dimorphism: DimorphismSpectrum,
    par: Float,
    red660: Float,
    green: Float,
    blue450: Float,
    white: Float,
    isNitrateLimited: Boolean,
    onParChange: (Float) -> Unit,
    onRedChange: (Float) -> Unit,
    onGreenChange: (Float) -> Unit,
    onBlueChange: (Float) -> Unit,
    onWhiteChange: (Float) -> Unit,
    onToggleNitrate: () -> Unit,
    modifier: Modifier = Modifier
) {
    // পিগমেন্টেশনের গাণিতিক গণনা:
    // আলো যদি উচ্চ PAR হয় (>70) এবং রেড 660nm বেশি থাকে ও নাইট্রেট নিয়ন্ত্রিত থাকে -> অ্যান্থোসায়ানিন বৃদ্ধি
    val redFactor = (red660 / 100f) * 0.45f + (par / 150f) * 0.35f + if (isNitrateLimited) 0.35f else 0.05f
    val greenFactor = (green / 100f) * 0.5f + (if (!isNitrateLimited) 0.4f else 0.1f)
    val blueFactor = (blue450 / 100f) * 0.3f

    // সিমুলেটেড পাতার রঙ
    val targetR = (0.2f + redFactor * 0.75f).coerceIn(0.1f, 0.95f)
    val targetG = (0.65f * greenFactor - (if (isNitrateLimited && par > 60) 0.25f else 0f)).coerceIn(0.15f, 0.85f)
    val targetB = (0.15f + blueFactor * 0.35f).coerceIn(0.1f, 0.6f)

    val animatedLeafColor by animateColorAsState(
        targetValue = Color(targetR, targetG, targetB),
        animationSpec = tween(durationMillis = 300),
        label = "leaf_pigmentation"
    )

    Card(
        modifier = modifier
            .fillMaxWidth()
            .testTag("wrgb_spectrum_card"),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Science,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "🔬 WRGB বর্ণালী ও পুষ্টি প্রতিক্রিয়া সিমুলেটর",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }

            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = "LED বর্ণালী ও নাইট্রেটের পরিবর্তনে পাতার রঞ্জক পদার্থ (অ্যান্থোসায়ানিন বনাম ক্লোরোফিল) কীভাবে রূপান্তরিত হয় তা পরীক্ষা করুন।",
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(14.dp))

            // লাইভ সিমুলেশন প্রিভিউ ক্যানভাস
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFF09171C))
                    .padding(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // পাতার অঙ্কন
                Box(
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                        .background(Color(0xFF050E12)),
                    contentAlignment = Alignment.Center
                ) {
                    Canvas(modifier = Modifier.size(60.dp)) {
                        val w = size.width
                        val h = size.height

                        // পাতার আকৃতির পাথ
                        val leafPath = Path().apply {
                            moveTo(w * 0.5f, h * 0.05f)
                            cubicTo(w * 0.95f, h * 0.35f, w * 0.85f, h * 0.8f, w * 0.5f, h * 0.95f)
                            cubicTo(w * 0.15f, h * 0.8f, w * 0.05f, h * 0.35f, w * 0.5f, h * 0.05f)
                            close()
                        }
                        drawPath(
                            path = leafPath,
                            brush = Brush.radialGradient(
                                colors = listOf(
                                    animatedLeafColor.copy(alpha = 0.95f),
                                    animatedLeafColor.copy(alpha = 0.75f)
                                ),
                                center = Offset(w * 0.5f, h * 0.4f),
                                radius = w * 0.5f
                            )
                        )
                        // পাতার মধ্যবর্তী প্রধান শিরা
                        drawLine(
                            color = Color.White.copy(alpha = 0.35f),
                            start = Offset(w * 0.5f, h * 0.1f),
                            end = Offset(w * 0.5f, h * 0.9f),
                            strokeWidth = 2.dp.toPx()
                        )
                    }
                }

                Spacer(modifier = Modifier.width(14.dp))

                // রঞ্জক পদার্থের স্থিতি
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = if (isNitrateLimited && par >= 70 && red660 >= 70) {
                            "🔥 চরম অ্যান্থোসায়ানিন সমৃদ্ধ (রক্তিম লাল)"
                        } else if (par < 40 || !isNitrateLimited) {
                            "🌿 ক্লোরোফিল সমৃদ্ধ (সবুজ ও দ্রুত বৃদ্ধি)"
                        } else {
                            "🍁 ক্যারোটিনয়েড সমৃদ্ধ (কমলা-সোনালী)"
                        },
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        color = animatedLeafColor
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "PAR: ${par.roundToInt()} µmol | Red 660nm: ${red660.roundToInt()}%",
                        fontSize = 11.sp,
                        color = Color.White.copy(alpha = 0.8f)
                    )
                    Text(
                        text = if (isNitrateLimited) "নাইট্রেট: নিয়ন্ত্রিত (< ৫ ppm)" else "নাইট্রেট: উচ্চ সমৃদ্ধি (> ১৫ ppm)",
                        fontSize = 11.sp,
                        color = if (isNitrateLimited) Color(0xFFFF8A80) else Color(0xFF81C784)
                    )
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // নাইট্রেট লিমিটেশন সুইচ
            Surface(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                color = MaterialTheme.colorScheme.surface
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp, vertical = 6.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "নাইট্রেট সীমাবদ্ধতা (Nitrate Limitation)",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Text(
                            text = "নাইট্রোজেন কমালে পাতা সবুজ থেকে তীব্র লালে রূপান্তরিত হয়",
                            fontSize = 10.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                    Switch(
                        checked = isNitrateLimited,
                        onCheckedChange = { onToggleNitrate() },
                        modifier = Modifier.testTag("nitrate_limitation_switch")
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // PAR স্লাইডার
            Text(
                text = "আলোর তীব্রতা (PAR: ${par.roundToInt()} µmol/m²/s)",
                fontSize = 11.sp,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onSurface
            )
            Slider(
                value = par,
                onValueChange = onParChange,
                valueRange = 20f..150f,
                modifier = Modifier.height(28.dp).testTag("par_slider")
            )

            // Red 660nm
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("🔴 রেড চ্যানেল (660nm Deep Red): ${red660.roundToInt()}%", fontSize = 11.sp, color = Color(0xFFFF5252))
            }
            Slider(
                value = red660,
                onValueChange = onRedChange,
                valueRange = 0f..100f,
                colors = SliderDefaults.colors(
                    thumbColor = Color(0xFFFF5252),
                    activeTrackColor = Color(0xFFFF5252)
                ),
                modifier = Modifier.height(26.dp)
            )

            // Blue 450nm
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("🔵 রয়্যাল ব্লু (450nm): ${blue450.roundToInt()}%", fontSize = 11.sp, color = Color(0xFF448AFF))
            }
            Slider(
                value = blue450,
                onValueChange = onBlueChange,
                valueRange = 0f..100f,
                colors = SliderDefaults.colors(
                    thumbColor = Color(0xFF448AFF),
                    activeTrackColor = Color(0xFF448AFF)
                ),
                modifier = Modifier.height(26.dp)
            )

            // Green 525nm
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("🟢 গ্রিন চ্যানেল (525nm): ${green.roundToInt()}%", fontSize = 11.sp, color = Color(0xFF69F0AE))
            }
            Slider(
                value = green,
                onValueChange = onGreenChange,
                valueRange = 0f..100f,
                colors = SliderDefaults.colors(
                    thumbColor = Color(0xFF69F0AE),
                    activeTrackColor = Color(0xFF69F0AE)
                ),
                modifier = Modifier.height(26.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            // স্পেকট্রাম নির্দেশিকা
            Surface(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                color = MaterialTheme.colorScheme.surface.copy(alpha = 0.5f)
            ) {
                Column(modifier = Modifier.padding(10.dp)) {
                    Text(
                        text = "💡 আলোক শারীরতত্ত্ব গাইড:",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = dimorphism.wrgbSpectrumReactionBn,
                        fontSize = 11.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        lineHeight = 15.sp
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "নাইট্রেট ডজিং প্রতিক্রিয়া: ${dimorphism.nitrateLimitationShiftBn}",
                        fontSize = 11.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        lineHeight = 15.sp
                    )
                }
            }
        }
    }
}
