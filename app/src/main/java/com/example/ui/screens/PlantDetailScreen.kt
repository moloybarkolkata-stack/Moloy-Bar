package com.example.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
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
import com.example.ui.components.InteractiveDimorphismSlider
import com.example.ui.components.ParameterGaugeMatrix
import com.example.ui.components.WrgbSpectrumVisualizer
import com.example.viewmodel.UiState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlantDetailScreen(
    plant: AquaticPlant,
    uiState: UiState,
    onBack: () -> Unit,
    onToggleFavorite: (String) -> Unit,
    onSplitRatioChange: (Float) -> Unit,
    onParChange: (Float) -> Unit,
    onRedChange: (Float) -> Unit,
    onGreenChange: (Float) -> Unit,
    onBlueChange: (Float) -> Unit,
    onWhiteChange: (Float) -> Unit,
    onToggleNitrate: () -> Unit,
    modifier: Modifier = Modifier
) {
    BackHandler {
        onBack()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = plant.scientificName,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            fontStyle = FontStyle.Italic
                        )
                        Text(
                            text = plant.commonNameBn,
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                },
                navigationIcon = {
                    IconButton(
                        onClick = onBack,
                        modifier = Modifier.testTag("detail_back_button")
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "ফিরে যান"
                        )
                    }
                },
                actions = {
                    val isFav = uiState.favoritePlantIds.contains(plant.id)
                    IconButton(
                        onClick = { onToggleFavorite(plant.id) },
                        modifier = Modifier.testTag("detail_favorite_button")
                    ) {
                        Icon(
                            imageVector = if (isFav) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                            contentDescription = "পছন্দের তালিকায় যোগ করুন",
                            tint = if (isFav) Color(0xFFFF5252) else MaterialTheme.colorScheme.onSurface
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            )
        },
        modifier = modifier.fillMaxSize()
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(vertical = 16.dp)
        ) {
            // ১. শিরোনাম কার্ড ও প্রাথমিক ট্যাক্সোনমি
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant
                    )
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.Top
                        ) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = plant.commonNameBn,
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.primary
                                )
                                Text(
                                    text = "${plant.scientificName} ${plant.authority}",
                                    fontSize = 14.sp,
                                    fontStyle = FontStyle.Italic,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                                Spacer(modifier = Modifier.height(2.dp))
                                Text(
                                    text = "গোত্র (Family): ${plant.family}",
                                    fontSize = 12.sp,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }

                            Surface(
                                shape = RoundedCornerShape(8.dp),
                                color = MaterialTheme.colorScheme.primaryContainer
                            ) {
                                Text(
                                    text = plant.morphology.category.labelBn.split(" ")[0],
                                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = "নামের ব্যুৎপত্তি (Etymology): ${plant.etymologyBn}",
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            lineHeight = 16.sp
                        )

                        if (plant.tradeSynonyms.isNotEmpty()) {
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "ট্রেড ও সমার্থক নাম: " + plant.tradeSynonyms.joinToString(", "),
                                fontSize = 11.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }
            }

            // ২. কাল্টিভার ও ট্রেড ভেরিয়েন্টস
            if (plant.cultivars.isNotEmpty()) {
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
                                text = "🎨 কাল্টিভার ও বৈচিত্র্যময় ট্রেড ভ্যারাইটি (${plant.cultivars.size} টি)",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary
                            )
                            Spacer(modifier = Modifier.height(10.dp))

                            plant.cultivars.forEachIndexed { index, cultivar ->
                                Surface(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(vertical = 4.dp),
                                    shape = RoundedCornerShape(10.dp),
                                    color = MaterialTheme.colorScheme.surface
                                ) {
                                    Row(
                                        modifier = Modifier.padding(12.dp),
                                        verticalAlignment = Alignment.Top
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .size(16.dp)
                                                .clip(CircleShape)
                                                .background(Color(cultivar.colorToneHex))
                                        )
                                        Spacer(modifier = Modifier.width(10.dp))
                                        Column {
                                            Text(
                                                text = "${cultivar.name} — ${cultivar.tradeNameBn}",
                                                fontSize = 13.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = MaterialTheme.colorScheme.onSurface
                                            )
                                            Spacer(modifier = Modifier.height(3.dp))
                                            Text(
                                                text = cultivar.distinguishingFeatureBn,
                                                fontSize = 11.sp,
                                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                                lineHeight = 15.sp
                                            )
                                            Spacer(modifier = Modifier.height(2.dp))
                                            Text(
                                                text = "নাইট্রেট সংবেদনশীলতা: ${cultivar.nitrateSensitivityBn}",
                                                fontSize = 10.sp,
                                                color = Color(0xFFFF8A80)
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            // ৩. প্রাকৃতিক বায়োটোপ ও ভৌগোলিক আবাসস্থল
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant
                    )
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.Public,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.size(20.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = "🗺️ ভৌগোলিক উৎপত্তি ও প্রাকৃতিক বায়োটোপ",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }

                        Spacer(modifier = Modifier.height(10.dp))
                        DetailRow(label = "আদি অঞ্চল", value = plant.biotope.regionBn)
                        DetailRow(label = "প্রাকৃতিক পরিবেশ", value = plant.biotope.habitatDescriptionBn)
                        DetailRow(label = "জলপ্রবাহের ধরণ", value = plant.biotope.flowTypeBn)
                        DetailRow(label = "বন্য তলদেশ", value = plant.biotope.substrateInWildBn)
                        DetailRow(label = "বাস্তুতাত্ত্বিক অবস্থা", value = plant.biotope.ecologicalStatusBn)
                        DetailRow(label = "আগ্রাসী বিস্তার ঝুঁকি", value = plant.biotope.invasivePotentialBn)
                    }
                }
            }

            // ৪. রূপতত্ত্ব ও গঠন
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
                            text = "📐 রূপতত্ত্ব ও বৃদ্ধির কাঠামো",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                        Spacer(modifier = Modifier.height(10.dp))

                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            StatBox(title = "সর্বোচ্চ উচ্চতা", value = plant.morphology.maxHeightCm, modifier = Modifier.weight(1f))
                            StatBox(title = "পাতার বিস্তার", value = plant.morphology.leafSpanCm, modifier = Modifier.weight(1f))
                            StatBox(title = "কাণ্ডের ঘনত্ব", value = plant.morphology.stemThicknessMm, modifier = Modifier.weight(1f))
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "শিকড়ের গঠন: ${plant.morphology.rootStructureBn}",
                            fontSize = 11.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }

            // ৫. ইন্টারেক্টিভ এমর্সড বনাম নিমজ্জিত স্প্লিট স্লাইডার
            item {
                InteractiveDimorphismSlider(
                    dimorphism = plant.dimorphism,
                    splitRatio = uiState.emersedSubmersedSplitRatio,
                    onRatioChange = onSplitRatioChange
                )
            }

            // ৬. WRGB বর্ণালী ও পুষ্টি প্রতিক্রিয়া সিমুলেটর
            item {
                WrgbSpectrumVisualizer(
                    dimorphism = plant.dimorphism,
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

            // ৭. চাষাবাদ ও পানির প্যারামিটার ম্যাট্রিক্স
            item {
                ParameterGaugeMatrix(cultivation = plant.cultivation)
            }

            // ৮. অ্যাকোয়াস্কেপিং নকশা ও জোন গাইড
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant
                    )
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.Landscape,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.size(20.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = "🎨 অ্যাকোয়াস্কেপিং ও নান্দনিক নকশা",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }

                        Spacer(modifier = Modifier.height(10.dp))
                        DetailRow(label = "প্রস্তাবিত জোন", value = plant.aquascape.zone.labelBn)
                        DetailRow(label = "ডাচ স্টাইল উপযুক্ততা", value = plant.aquascape.dutchStyleSuitabilityBn)
                        DetailRow(label = "নেচার / ইওয়াগুমি স্টাইল", value = plant.aquascape.natureIwagumiSuitabilityBn)
                        DetailRow(label = "পাতার টেক্সচার", value = plant.aquascape.leafTexture.labelBn)
                        DetailRow(label = "বৃদ্ধির গতি", value = plant.aquascape.growthRate.labelBn)
                        DetailRow(label = "ছায়া ফেলার ঝুঁকি", value = plant.aquascape.shadowingRiskBn)
                    }
                }
            }

            // ৯. ছাঁটাই, বিস্তার ও জীবনচক্র
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant
                    )
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.ContentCut,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.size(20.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = "✂️ ছাঁটাই মেকানিক্স ও জীবনচক্র ব্যবস্থাপনা",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }

                        Spacer(modifier = Modifier.height(10.dp))
                        DetailRow(label = "ছাঁটাই পদ্ধতি", value = plant.care.pruningMethod.labelBn)
                        DetailRow(label = "ছাঁটাই নির্দেশনা", value = plant.care.pruningInstructionsBn)
                        DetailRow(label = "বংশবিস্তার মাধ্যম", value = plant.care.propagationMethodsBn.joinToString(", "))
                        DetailRow(label = "মেল্টিং উদ্দীপক কারণ", value = plant.care.meltingTriggersBn)

                        if (plant.care.dormancyRestRequired) {
                            Spacer(modifier = Modifier.height(8.dp))
                            Surface(
                                shape = RoundedCornerShape(8.dp),
                                color = Color(0xFFFFA726).copy(alpha = 0.15f)
                            ) {
                                Row(
                                    modifier = Modifier.padding(8.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Bedtime,
                                        contentDescription = null,
                                        tint = Color(0xFFFFA726),
                                        modifier = Modifier.size(16.dp)
                                    )
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Text(
                                        text = "সুপ্তাবস্থা নির্দেশিকা: ${plant.care.dormancyCareNotesBn}",
                                        fontSize = 11.sp,
                                        color = MaterialTheme.colorScheme.onSurface,
                                        lineHeight = 15.sp
                                    )
                                }
                            }
                        }
                    }
                }
            }

            // ১০. জলজ জীব ও চিংড়ি সামঞ্জস্য
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant
                    )
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.Pets,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.size(18.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = "🦐 জলজ প্রাণী ও চিংড়ি সামঞ্জস্য",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = plant.livestockCompatibilityBn,
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            lineHeight = 16.sp
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun DetailRow(label: String, value: String) {
    Column(modifier = Modifier.padding(vertical = 4.dp)) {
        Text(
            text = label,
            fontSize = 11.sp,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.onSurface
        )
        Text(
            text = value,
            fontSize = 12.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            lineHeight = 16.sp
        )
    }
}

@Composable
private fun StatBox(title: String, value: String, modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        color = MaterialTheme.colorScheme.surface
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = title, fontSize = 10.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
            Spacer(modifier = Modifier.height(2.dp))
            Text(text = value, fontSize = 11.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onSurface)
        }
    }
}
