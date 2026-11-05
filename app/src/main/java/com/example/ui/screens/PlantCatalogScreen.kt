package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
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
import com.example.model.PlantCategory
import com.example.viewmodel.UiState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlantCatalogScreen(
    plants: List<AquaticPlant>,
    uiState: UiState,
    onSearchChange: (String) -> Unit,
    onSelectCategory: (PlantCategory?) -> Unit,
    onToggleRedFilter: () -> Unit,
    onToggleLowTechFilter: () -> Unit,
    onToggleSoftWaterFilter: () -> Unit,
    onToggleFavorite: (String) -> Unit,
    onSelectPlant: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    // ফিল্টারিং লজিক
    val filteredPlants = plants.filter { plant ->
        val query = uiState.searchQuery.trim().lowercase()
        val matchesQuery = query.isEmpty() ||
                plant.commonNameBn.lowercase().contains(query) ||
                plant.scientificName.lowercase().contains(query) ||
                plant.family.lowercase().contains(query) ||
                plant.tradeSynonyms.any { it.lowercase().contains(query) }

        val matchesCategory = uiState.selectedCategory == null || plant.morphology.category == uiState.selectedCategory

        val matchesRed = !uiState.filterOnlyRedPlants || plant.cultivars.any { it.colorToneHex == 0xFFD32F2F || it.colorToneHex == 0xFFE91E63 || it.colorToneHex == 0xFFFF5722 } || plant.dimorphism.highLightColorHex == 0xFFD32F2F || plant.dimorphism.highLightColorHex == 0xFFC2185B

        val matchesLowTech = !uiState.filterOnlyLowTech || plant.cultivation.lowTechViable

        val matchesSoftWater = !uiState.filterOnlySoftWater || plant.cultivation.softWaterObligate

        matchesQuery && matchesCategory && matchesRed && matchesLowTech && matchesSoftWater
    }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp),
        contentPadding = PaddingValues(vertical = 16.dp)
    ) {
        // ১. সার্চ বার
        item {
            OutlinedTextField(
                value = uiState.searchQuery,
                onValueChange = onSearchChange,
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("catalog_search_bar"),
                placeholder = { Text("প্রজাতি, বৈজ্ঞানিক নাম বা গোত্র খুঁজুন...", fontSize = 13.sp) },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "অনুসন্ধান",
                        tint = MaterialTheme.colorScheme.primary
                    )
                },
                trailingIcon = {
                    if (uiState.searchQuery.isNotEmpty()) {
                        IconButton(onClick = { onSearchChange("") }) {
                            Icon(imageVector = Icons.Default.Clear, contentDescription = "মুছুন")
                        }
                    }
                },
                shape = RoundedCornerShape(12.dp),
                singleLine = true
            )
        }

        // ২. ক্যাটাগরি ফিল্টার চিপস
        item {
            Column {
                Text(
                    text = "উদ্ভিদের শ্রেণীবিভাগ:",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(modifier = Modifier.height(6.dp))
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    item {
                        FilterChip(
                            selected = uiState.selectedCategory == null,
                            onClick = { onSelectCategory(null) },
                            label = { Text("সকল (${plants.size})", fontSize = 11.sp) }
                        )
                    }
                    items(PlantCategory.values()) { cat ->
                        FilterChip(
                            selected = uiState.selectedCategory == cat,
                            onClick = { onSelectCategory(cat) },
                            label = { Text(cat.labelBn.split(" ")[0], fontSize = 11.sp) }
                        )
                    }
                }
            }
        }

        // ৩. দ্রুত ফিল্টার সুইচ/চিপস
        item {
            LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                item {
                    FilterChip(
                        selected = uiState.filterOnlyRedPlants,
                        onClick = onToggleRedFilter,
                        label = { Text("🔴 লাল রঙের উদ্ভিদ", fontSize = 11.sp) }
                    )
                }
                item {
                    FilterChip(
                        selected = uiState.filterOnlyLowTech,
                        onClick = onToggleLowTechFilter,
                        label = { Text("🌱 লো-টেক উপযোগী", fontSize = 11.sp) }
                    )
                }
                item {
                    FilterChip(
                        selected = uiState.filterOnlySoftWater,
                        onClick = onToggleSoftWaterFilter,
                        label = { Text("💧 নরম পানি আবশ্যক", fontSize = 11.sp) }
                    )
                }
            }
        }

        // ৪. উদ্ভিদের সংখ্যা কাউন্ট
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "প্রদর্শিত প্রজাতিসমূহ (${filteredPlants.size} টি)",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }

        // ৫. উদ্ভিদ কার্ড তালিকা
        if (filteredPlants.isEmpty()) {
            item {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    color = MaterialTheme.colorScheme.surfaceVariant
                ) {
                    Column(
                        modifier = Modifier.padding(24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            imageVector = Icons.Default.SearchOff,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.size(36.dp)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "কোনো উদ্ভিদ পাওয়া যায়নি!",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Text(
                            text = "অনুসন্ধানের শর্ত পরিবর্তন করে পুনরায় চেষ্টা করুন।",
                            fontSize = 11.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        } else {
            items(filteredPlants, key = { it.id }) { plant ->
                PlantCard(
                    plant = plant,
                    isFavorite = uiState.favoritePlantIds.contains(plant.id),
                    onToggleFavorite = { onToggleFavorite(plant.id) },
                    onClick = { onSelectPlant(plant.id) }
                )
            }
        }
    }
}

@Composable
private fun PlantCard(
    plant: AquaticPlant,
    isFavorite: Boolean,
    onToggleFavorite: () -> Unit,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(14.dp))
            .clickable(onClick = onClick)
            .testTag("plant_card_${plant.id}"),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = plant.commonNameBn,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = plant.scientificName,
                        fontSize = 13.sp,
                        fontStyle = FontStyle.Italic,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = plant.family,
                        fontSize = 11.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                IconButton(
                    onClick = onToggleFavorite,
                    modifier = Modifier.size(32.dp).testTag("fav_btn_${plant.id}")
                ) {
                    Icon(
                        imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                        contentDescription = "পছন্দের তালিকা",
                        tint = if (isFavorite) Color(0xFFFF5252) else MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // ইনফোগ্রাফিক ট্যাগ ব্যাজ
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                InfoBadge(
                    text = "PAR: ${plant.cultivation.parRangeMicroMol}",
                    color = Color(0xFFFFD166)
                )
                InfoBadge(
                    text = "CO₂: ${plant.cultivation.co2DemandPpm.split(" ")[0]}",
                    color = Color(0xFF48CAE4)
                )
                InfoBadge(
                    text = plant.aquascape.zone.labelBn.split(" ")[0],
                    color = MaterialTheme.colorScheme.primary
                )
                if (plant.cultivation.lowTechViable) {
                    InfoBadge(
                        text = "লো-টেক",
                        color = Color(0xFF00E5A3)
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = plant.biotope.habitatDescriptionBn,
                fontSize = 11.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 2,
                lineHeight = 15.sp
            )
        }
    }
}

@Composable
private fun InfoBadge(text: String, color: Color) {
    Surface(
        shape = RoundedCornerShape(6.dp),
        color = color.copy(alpha = 0.15f)
    ) {
        Text(
            text = text,
            color = color,
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp)
        )
    }
}
