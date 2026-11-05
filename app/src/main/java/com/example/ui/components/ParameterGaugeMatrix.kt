package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.CultivationMatrix
import com.example.model.NutrientUptake

@Composable
fun ParameterGaugeMatrix(
    cultivation: CultivationMatrix,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .testTag("parameter_gauge_card"),
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
                    text = "⚗️ চাষাবাদ ও পানির প্যারামিটার ম্যাট্রিক্স",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
                if (cultivation.softWaterObligate) {
                    Surface(
                        shape = RoundedCornerShape(6.dp),
                        color = Color(0xFFEF5350).copy(alpha = 0.2f)
                    ) {
                        Text(
                            text = "নরম পানির বাধ্যবাধকতা",
                            color = Color(0xFFEF5350),
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // গ্রিড ১: আলো (PAR) ও CO2
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                MetricTile(
                    title = "আলো (PAR)",
                    value = "${cultivation.parRangeMicroMol}",
                    subtitle = cultivation.parLevelBn,
                    icon = Icons.Default.WbSunny,
                    accentColor = Color(0xFFFFD166),
                    modifier = Modifier.weight(1f)
                )

                MetricTile(
                    title = "কার্বন ডাই অক্সাইড (CO₂)",
                    value = cultivation.co2DemandPpm,
                    subtitle = if (cultivation.lowTechViable) "লো-টেক সম্ভব" else "হাই-টেক আবশ্যক",
                    icon = Icons.Default.Cloud,
                    accentColor = if (cultivation.lowTechViable) Color(0xFF00E5A3) else Color(0xFFFF7043),
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            // গ্রিড ২: তাপমাত্রা ও pH/KH
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                MetricTile(
                    title = "তাপমাত্রা",
                    value = cultivation.tempOptimalC,
                    subtitle = "সহনশীলতা: ${cultivation.tempMinC}°–${cultivation.tempMaxC}° সে.",
                    icon = Icons.Default.Thermostat,
                    accentColor = Color(0xFFFFA726),
                    modifier = Modifier.weight(1f)
                )

                MetricTile(
                    title = "pH এবং KH মাত্রা",
                    value = "pH ${cultivation.phRange}",
                    subtitle = "KH: ${cultivation.khRange} | GH: ${cultivation.ghRange}",
                    icon = Icons.Default.Opacity,
                    accentColor = Color(0xFF48CAE4),
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            // গ্রীষ্মকালীন মেল্ট সতর্কতা
            Surface(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                color = Color(0xFFD32F2F).copy(alpha = 0.12f)
            ) {
                Row(
                    modifier = Modifier.padding(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Warning,
                        contentDescription = null,
                        tint = Color(0xFFEF5350),
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Column {
                        Text(
                            text = "গ্রীষ্মকালীন তাপমাত্রা ঝুঁকি (Summer Melt):",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFEF5350)
                        )
                        Text(
                            text = cultivation.summerMeltWarningBn,
                            fontSize = 11.sp,
                            color = MaterialTheme.colorScheme.onSurface,
                            lineHeight = 14.sp
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // পুষ্টি গ্রহণ ও সাবস্ট্রেট অগ্রাধিকার
            Surface(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                color = MaterialTheme.colorScheme.surface
            ) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Grass,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "পুষ্টি গ্রহণ মাধ্যম: ${cultivation.primaryUptake.labelBn}",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }

                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "তলদেশ পছন্দ: ${cultivation.substratePreferenceBn}",
                        fontSize = 11.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "অনুপাত ও অনুপুষ্টি: ${cultivation.caMgRatioNotesBn} ${cultivation.ironPotassiumDemandBn}",
                        fontSize = 11.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        lineHeight = 15.sp
                    )
                }
            }
        }
    }
}

@Composable
private fun MetricTile(
    title: String,
    value: String,
    subtitle: String,
    icon: ImageVector,
    accentColor: Color,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(10.dp),
        color = MaterialTheme.colorScheme.surface
    ) {
        Column(
            modifier = Modifier.padding(12.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .clip(RoundedCornerShape(6.dp))
                        .background(accentColor.copy(alpha = 0.2f)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                        tint = accentColor,
                        modifier = Modifier.size(14.dp)
                    )
                }
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = title,
                    fontSize = 11.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    fontWeight = FontWeight.Medium
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = value,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = subtitle,
                fontSize = 10.sp,
                color = accentColor,
                lineHeight = 13.sp
            )
        }
    }
}
