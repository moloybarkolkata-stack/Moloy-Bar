package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.AlgaeVulnerability
import com.example.model.DeficiencyPathology
import com.example.model.NutrientMobility
import com.example.model.WabiKusaStep

@Composable
fun PathologyAtlasScreen(
    deficiencies: List<DeficiencyPathology>,
    algaeTreatments: List<AlgaeVulnerability>,
    wabiKusaSteps: List<WabiKusaStep>,
    selectedMobility: NutrientMobility?,
    onSelectMobility: (NutrientMobility?) -> Unit,
    modifier: Modifier = Modifier
) {
    var selectedSection by remember { mutableIntStateOf(0) } // 0: পুষ্টি ঘাটতি, 1: শৈবাল ও স্পট চিকিৎসা, 2: ওয়াবি-কুসা

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(vertical = 16.dp)
    ) {
        // সেকশন টগল ট্যাব (পুষ্টি / শৈবাল / ওয়াবি-কুসা)
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(MaterialTheme.colorScheme.surfaceVariant)
                    .padding(4.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TabButton(
                    title = "পুষ্টি ঘাটতি অ্যাটলাস",
                    isSelected = selectedSection == 0,
                    onClick = { selectedSection = 0 },
                    modifier = Modifier.weight(1f)
                )
                TabButton(
                    title = "শৈবাল চিকিৎসা",
                    isSelected = selectedSection == 1,
                    onClick = { selectedSection = 1 },
                    modifier = Modifier.weight(1f)
                )
                TabButton(
                    title = "ওয়াবি-কুসা গাইড",
                    isSelected = selectedSection == 2,
                    onClick = { selectedSection = 2 },
                    modifier = Modifier.weight(1f)
                )
            }
        }

        if (selectedSection == 0) {
            // ১. মোবাইল বনাম ইম্মোবাইল ফিল্টার চিপস
            item {
                Column {
                    Text(
                        text = "🩺 পুষ্টির গতিশীলতা (Nutrient Mobility):",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        item {
                            FilterChip(
                                selected = selectedMobility == null,
                                onClick = { onSelectMobility(null) },
                                label = { Text("সকল লক্ষণ (${deficiencies.size})", fontSize = 11.sp) }
                            )
                        }
                        item {
                            FilterChip(
                                selected = selectedMobility == NutrientMobility.MOBILE_OLD_LEAVES,
                                onClick = { onSelectMobility(NutrientMobility.MOBILE_OLD_LEAVES) },
                                label = { Text("পুরাতন পাতা (মোবাইল: N, P, K, Mg)", fontSize = 11.sp) }
                            )
                        }
                        item {
                            FilterChip(
                                selected = selectedMobility == NutrientMobility.IMMOBILE_NEW_GROWTH,
                                onClick = { onSelectMobility(NutrientMobility.IMMOBILE_NEW_GROWTH) },
                                label = { Text("কচি ডগা (ইম্মোবাইল: Fe, Ca, B)", fontSize = 11.sp) }
                            )
                        }
                    }
                }
            }

            // পুষ্টি ঘাটতি আইটেমস
            val filteredList = if (selectedMobility == null) {
                deficiencies
            } else {
                deficiencies.filter { it.mobility == selectedMobility }
            }

            items(filteredList, key = { it.id }) { def ->
                Card(
                    modifier = Modifier.fillMaxWidth().testTag("deficiency_card_${def.id}"),
                    shape = RoundedCornerShape(14.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant
                    )
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = def.nutrientNameBn,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary
                            )
                            Surface(
                                shape = RoundedCornerShape(6.dp),
                                color = if (def.mobility == NutrientMobility.MOBILE_OLD_LEAVES) Color(0xFFFFA726).copy(alpha = 0.2f) else Color(0xFF48CAE4).copy(alpha = 0.2f)
                            ) {
                                Text(
                                    text = def.chemicalSymbol,
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = if (def.mobility == NutrientMobility.MOBILE_OLD_LEAVES) Color(0xFFFFA726) else Color(0xFF48CAE4),
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            text = "আক্রান্ত স্থান: ${def.mobility.labelBn}",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.onSurface
                        )

                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            text = "লক্ষণ: ${def.visualSymptomsBn}",
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            lineHeight = 16.sp
                        )

                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            text = "সাধারণ ভুল ধারণা: ${def.commonMisconceptionBn}",
                            fontSize = 11.sp,
                            color = Color(0xFFFF8A80),
                            lineHeight = 15.sp
                        )

                        Spacer(modifier = Modifier.height(8.dp))
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = MaterialTheme.colorScheme.surface
                        ) {
                            Column(modifier = Modifier.padding(10.dp)) {
                                Text(
                                    text = "✅ প্রতিকার ও ডজিং: ${def.correctiveActionBn}",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Medium,
                                    color = MaterialTheme.colorScheme.primary,
                                    lineHeight = 15.sp
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = "সংবেদনশীল প্রজাতি: ${def.mostSensitivePlantsBn}",
                                    fontSize = 10.sp,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }
                    }
                }
            }
        } else if (selectedSection == 1) {
            // ২. শৈবাল সংবেদনশীলতা ও গ্লুটারালডিহাইড/H2O2 স্পট ট্রিটমেন্ট
            item {
                Text(
                    text = "🌿 শৈবাল আক্রমণ ও নিরাপদ স্পট চিকিৎসা ডজিং",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
            }

            items(algaeTreatments, key = { it.id }) { alg ->
                Card(
                    modifier = Modifier.fillMaxWidth().testTag("algae_card_${alg.id}"),
                    shape = RoundedCornerShape(14.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant
                    )
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = alg.algaeNameBn,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFEF5350)
                        )
                        Text(
                            text = "বৈজ্ঞানিক শ্রেণী: ${alg.scientificGroup}",
                            fontSize = 11.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )

                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "আক্রান্ত উদ্ভিদ: ${alg.targetPlantHabitsBn}",
                            fontSize = 11.sp,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Text(
                            text = "মূল কারণ: ${alg.rootCausesBn}",
                            fontSize = 11.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            lineHeight = 15.sp
                        )

                        Spacer(modifier = Modifier.height(10.dp))
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = MaterialTheme.colorScheme.surface
                        ) {
                            Column(modifier = Modifier.padding(10.dp)) {
                                Text(
                                    text = "💉 গ্লুটারালডিহাইড (লিকুইড কার্বন) স্পট ডোজ:",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.primary
                                )
                                Text(
                                    text = alg.glutaraldehydeSafeDoseBn,
                                    fontSize = 11.sp,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                                    lineHeight = 15.sp
                                )

                                Spacer(modifier = Modifier.height(6.dp))
                                Text(
                                    text = "🧪 হাইড্রোজেন পারঅক্সাইড (৩% H₂O₂) ডোজ:",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF48CAE4)
                                )
                                Text(
                                    text = alg.hydrogenPeroxideSafeDoseBn,
                                    fontSize = 11.sp,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                                    lineHeight = 15.sp
                                )

                                Spacer(modifier = Modifier.height(6.dp))
                                Text(
                                    text = "⚠️ সতর্কতা: ${alg.sensitiveSpeciesWarningBn}",
                                    fontSize = 10.sp,
                                    color = Color(0xFFFF8A80)
                                )
                            }
                        }
                    }
                }
            }
        } else {
            // ৩. ওয়াবি-কুসা ও এমর্সড প্রোপাগেশন গাইড
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(14.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant
                    )
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "🌱 ওয়াবি-কুসা ও এমর্সড ফার্মিং গাইড",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            text = "জলের নিচের কাটিংগুলোকে ঘরের বায়বীয় পরিবেশে কীভাবে আর্দ্র সয়েল বলের মাধ্যমে এমর্সড পুষ্পিত রূপ এবং টেরারিয়ামে রূপান্তর করবেন তার চার ধাপের নির্দেশিকা।",
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            lineHeight = 16.sp
                        )
                    }
                }
            }

            items(wabiKusaSteps, key = { it.stepNumber }) { step ->
                Card(
                    modifier = Modifier.fillMaxWidth().testTag("wabikusa_step_${step.stepNumber}"),
                    shape = RoundedCornerShape(14.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant
                    )
                ) {
                    Row(modifier = Modifier.padding(16.dp)) {
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = MaterialTheme.colorScheme.primary
                        ) {
                            Text(
                                text = "ধাপ ${step.stepNumber}",
                                color = MaterialTheme.colorScheme.onPrimary,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                            )
                        }

                        Spacer(modifier = Modifier.width(12.dp))

                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = step.titleBn,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = step.descriptionBn,
                                fontSize = 11.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                lineHeight = 15.sp
                            )
                            Spacer(modifier = Modifier.height(6.dp))
                            Row {
                                Text(
                                    text = "আর্দ্রতা: ${step.humidityRequirementBn}",
                                    fontSize = 10.sp,
                                    color = Color(0xFF48CAE4),
                                    fontWeight = FontWeight.SemiBold
                                )
                                Spacer(modifier = Modifier.width(12.dp))
                                Text(
                                    text = "সময়কাল: ${step.transitionDurationBn}",
                                    fontSize = 10.sp,
                                    color = Color(0xFFFFD166),
                                    fontWeight = FontWeight.SemiBold
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun TabButton(
    title: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp)),
        color = if (isSelected) MaterialTheme.colorScheme.primary else Color.Transparent,
        onClick = onClick
    ) {
        Box(
            modifier = Modifier.padding(vertical = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = title,
                fontSize = 11.sp,
                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                color = if (isSelected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}
