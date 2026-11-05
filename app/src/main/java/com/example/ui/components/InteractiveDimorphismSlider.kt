package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SwapHoriz
import androidx.compose.material.icons.filled.WaterDrop
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.DimorphismSpectrum
import kotlin.math.roundToInt

@Composable
fun InteractiveDimorphismSlider(
    dimorphism: DimorphismSpectrum,
    splitRatio: Float,
    onRatioChange: (Float) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .testTag("interactive_dimorphism_card"),
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
                Text(
                    text = "🌱 ভিজ্যুয়াল ডাইমরফিজম স্প্লিট তুলক",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = "ড্র্যাগ করে তুলনা করুন",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            // ইন্টারেক্টিভ স্প্লিট ভিউ এরিয়া
            BoxWithConstraints(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .testTag("dimorphism_split_area")
            ) {
                val totalWidth = maxWidth
                val splitPx = totalWidth * splitRatio

                // বাম পাশ: এমর্সড (জলের বাইরের আর্দ্র রূপ)
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(splitPx)
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(
                                    Color(0xFF2E5A36),
                                    Color(0xFF1B3B22)
                                )
                            )
                        )
                        .padding(12.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Surface(
                            shape = RoundedCornerShape(6.dp),
                            color = Color(0xFF4CAF50).copy(alpha = 0.85f)
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = Icons.Default.WbSunny,
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier.size(14.dp)
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = "এমর্সড (মার্শ রূপ)",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                            }
                        }

                        Column {
                            Text(
                                text = "পাতার গঠন:",
                                fontSize = 11.sp,
                                color = Color.White.copy(alpha = 0.8f)
                            )
                            Text(
                                text = dimorphism.emersedLeafShapeBn,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.White
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "ফুল: " + dimorphism.flowerInflorescenceBn,
                                fontSize = 10.sp,
                                color = Color.White.copy(alpha = 0.9f),
                                maxLines = 2
                            )
                        }
                    }
                }

                // ডান পাশ: সাবমার্সড (জলে নিমজ্জিত রূপান্তরিত রূপ)
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(totalWidth - splitPx)
                        .align(Alignment.CenterEnd)
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(
                                    Color(dimorphism.highLightColorHex).copy(alpha = 0.85f),
                                    Color(0xFF0D2530)
                                )
                            )
                        )
                        .padding(12.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.SpaceBetween,
                        horizontalAlignment = Alignment.End
                    ) {
                        Surface(
                            shape = RoundedCornerShape(6.dp),
                            color = Color(0xFF00E5A3).copy(alpha = 0.85f)
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = Icons.Default.WaterDrop,
                                    contentDescription = null,
                                    tint = Color(0xFF003824),
                                    modifier = Modifier.size(14.dp)
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = "সাবমার্সড (নিমজ্জিত)",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF003824)
                                )
                            }
                        }

                        Column(horizontalAlignment = Alignment.End) {
                            Text(
                                text = "পানির নিচের গঠন:",
                                fontSize = 11.sp,
                                color = Color.White.copy(alpha = 0.8f)
                            )
                            Text(
                                text = dimorphism.submersedLeafShapeBn,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.White,
                                textAlign = TextAlign.End
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "রঙ রূপান্তর: অ্যান্থোসায়ানিন সমৃদ্ধ",
                                fontSize = 10.sp,
                                color = Color(0xFFFFD166),
                                textAlign = TextAlign.End
                            )
                        }
                    }
                }

                // ড্র্যাগেবল স্লাইডার বার হ্যান্ডেল
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(36.dp)
                        .offset(x = splitPx - 18.dp)
                        .pointerInput(Unit) {
                            detectDragGestures { change, dragAmount ->
                                change.consume()
                                val newRatio = (splitRatio + dragAmount.x / totalWidth.toPx())
                                    .coerceIn(0.1f, 0.9f)
                                onRatioChange(newRatio)
                            }
                        },
                    contentAlignment = Alignment.Center
                ) {
                    // লম্বালম্বি বিভাজক রেখা
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(3.dp)
                            .background(Color.White)
                    )

                    // স্পর্শ সহায়ক গোল বাটন
                    Surface(
                        modifier = Modifier
                            .size(36.dp)
                            .testTag("split_slider_knob"),
                        shape = CircleShape,
                        color = MaterialTheme.colorScheme.primary,
                        shadowElevation = 6.dp
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Icon(
                                imageVector = Icons.Default.SwapHoriz,
                                contentDescription = "স্প্লিট স্লাইডার হ্যান্ডেল",
                                tint = MaterialTheme.colorScheme.onPrimary,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // দ্রুত প্রিসেট বাটন (100% Emersed, 50% Transition, 100% Submersed)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedButton(
                    onClick = { onRatioChange(0.85f) },
                    modifier = Modifier.weight(1f).padding(end = 4.dp),
                    contentPadding = PaddingValues(horizontal = 4.dp, vertical = 2.dp)
                ) {
                    Text("এমর্সড ভিউ", fontSize = 11.sp)
                }
                OutlinedButton(
                    onClick = { onRatioChange(0.50f) },
                    modifier = Modifier.weight(1f).padding(horizontal = 4.dp),
                    contentPadding = PaddingValues(horizontal = 4.dp, vertical = 2.dp)
                ) {
                    Text("৫০/৫০ রূপান্তর", fontSize = 11.sp)
                }
                OutlinedButton(
                    onClick = { onRatioChange(0.15f) },
                    modifier = Modifier.weight(1f).padding(start = 4.dp),
                    contentPadding = PaddingValues(horizontal = 4.dp, vertical = 2.dp)
                ) {
                    Text("সাবমার্সড ভিউ", fontSize = 11.sp)
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // বৈজ্ঞানিক রূপান্তর নোট
            Text(
                text = "📌 রূপতাত্ত্বিক নোট:",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = "মার্শ/নার্সারিতে: ${dimorphism.emersedDescriptionBn}",
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                lineHeight = 16.sp
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "অ্যাকোয়ারিয়ামে জলে নিমজ্জিত হলে: ${dimorphism.submersedDescriptionBn}",
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                lineHeight = 16.sp
            )
        }
    }
}
