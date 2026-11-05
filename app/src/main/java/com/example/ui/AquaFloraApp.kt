package com.example.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ui.screens.*
import com.example.viewmodel.AppNavigationTab
import com.example.viewmodel.AquaticBotanyViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AquaFloraApp(
    viewModel: AquaticBotanyViewModel = viewModel(),
    modifier: Modifier = Modifier
) {
    val uiState by viewModel.uiState.collectAsState()
    val selectedPlant = viewModel.allPlants.find { it.id == uiState.selectedPlantId }
        ?: viewModel.allPlants.first()

    val co2Ppm = viewModel.calculateCo2Ppm(uiState.inputPh, uiState.inputKh)
    val co2Status = viewModel.getCo2Status(co2Ppm)
    val matchedPlants = viewModel.getMatchedPlants(
        ph = uiState.inputPh,
        kh = uiState.inputKh,
        temp = uiState.inputTempC,
        par = uiState.inputPar
    )

    if (uiState.isDetailOpen) {
        PlantDetailScreen(
            plant = selectedPlant,
            uiState = uiState,
            onBack = { viewModel.closePlantDetail() },
            onToggleFavorite = { viewModel.toggleFavorite(it) },
            onSplitRatioChange = { viewModel.updateSplitRatio(it) },
            onParChange = { viewModel.updatePar(it) },
            onRedChange = { viewModel.updateRed660(it) },
            onGreenChange = { viewModel.updateGreen(it) },
            onBlueChange = { viewModel.updateBlue450(it) },
            onWhiteChange = { viewModel.updateWhite(it) },
            onToggleNitrate = { viewModel.toggleNitrateLimitation() }
        )
    } else {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Column {
                            Text(
                                text = "AquaFlora জলজ উদ্ভিদ বিশ্বকোষ",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary
                            )
                            Text(
                                text = "গবেষণা, ট্যাক্সোনমি ও ডাইমরফিজম রেফারেন্স",
                                style = MaterialTheme.typography.labelSmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.surface
                    )
                )
            },
            bottomBar = {
                NavigationBar(
                    modifier = Modifier.windowInsetsPadding(WindowInsets.navigationBars),
                    containerColor = MaterialTheme.colorScheme.surface
                ) {
                    NavTabItem(
                        tab = AppNavigationTab.CATALOG,
                        icon = Icons.Default.MenuBook,
                        isSelected = uiState.currentTab == AppNavigationTab.CATALOG,
                        onClick = { viewModel.setTab(AppNavigationTab.CATALOG) }
                    )
                    NavTabItem(
                        tab = AppNavigationTab.DIMORPHISM_LAB,
                        icon = Icons.Default.Science,
                        isSelected = uiState.currentTab == AppNavigationTab.DIMORPHISM_LAB,
                        onClick = { viewModel.setTab(AppNavigationTab.DIMORPHISM_LAB) }
                    )
                    NavTabItem(
                        tab = AppNavigationTab.CALCULATOR,
                        icon = Icons.Default.Calculate,
                        isSelected = uiState.currentTab == AppNavigationTab.CALCULATOR,
                        onClick = { viewModel.setTab(AppNavigationTab.CALCULATOR) }
                    )
                    NavTabItem(
                        tab = AppNavigationTab.PATHOLOGY,
                        icon = Icons.Default.Healing,
                        isSelected = uiState.currentTab == AppNavigationTab.PATHOLOGY,
                        onClick = { viewModel.setTab(AppNavigationTab.PATHOLOGY) }
                    )
                    NavTabItem(
                        tab = AppNavigationTab.LOOK_ALIKE,
                        icon = Icons.Default.Compare,
                        isSelected = uiState.currentTab == AppNavigationTab.LOOK_ALIKE,
                        onClick = { viewModel.setTab(AppNavigationTab.LOOK_ALIKE) }
                    )
                }
            },
            contentWindowInsets = WindowInsets.safeDrawing,
            modifier = modifier.fillMaxSize()
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                when (uiState.currentTab) {
                    AppNavigationTab.CATALOG -> {
                        PlantCatalogScreen(
                            plants = viewModel.allPlants,
                            uiState = uiState,
                            onSearchChange = { viewModel.setSearchQuery(it) },
                            onSelectCategory = { viewModel.selectCategory(it) },
                            onToggleRedFilter = { viewModel.toggleRedPlantsFilter() },
                            onToggleLowTechFilter = { viewModel.toggleLowTechFilter() },
                            onToggleSoftWaterFilter = { viewModel.toggleSoftWaterFilter() },
                            onToggleFavorite = { viewModel.toggleFavorite(it) },
                            onSelectPlant = { viewModel.openPlantDetail(it) }
                        )
                    }
                    AppNavigationTab.DIMORPHISM_LAB -> {
                        DimorphismLabScreen(
                            plants = viewModel.allPlants,
                            selectedPlant = selectedPlant,
                            uiState = uiState,
                            onSelectPlant = { viewModel.openPlantDetail(it) },
                            onSplitRatioChange = { viewModel.updateSplitRatio(it) },
                            onParChange = { viewModel.updatePar(it) },
                            onRedChange = { viewModel.updateRed660(it) },
                            onGreenChange = { viewModel.updateGreen(it) },
                            onBlueChange = { viewModel.updateBlue450(it) },
                            onWhiteChange = { viewModel.updateWhite(it) },
                            onToggleNitrate = { viewModel.toggleNitrateLimitation() }
                        )
                    }
                    AppNavigationTab.CALCULATOR -> {
                        ParameterCalculatorScreen(
                            uiState = uiState,
                            co2Ppm = co2Ppm,
                            co2Status = co2Status,
                            matchedPlants = matchedPlants,
                            onPhChange = { viewModel.updateCalculatorPh(it) },
                            onKhChange = { viewModel.updateCalculatorKh(it) },
                            onGhChange = { viewModel.updateCalculatorGh(it) },
                            onTempChange = { viewModel.updateCalculatorTemp(it) },
                            onParChange = { viewModel.updateCalculatorPar(it) },
                            onSelectPlant = { viewModel.openPlantDetail(it) }
                        )
                    }
                    AppNavigationTab.PATHOLOGY -> {
                        PathologyAtlasScreen(
                            deficiencies = viewModel.allDeficiencies,
                            algaeTreatments = viewModel.allAlgaeTreatments,
                            wabiKusaSteps = viewModel.allWabiKusaSteps,
                            selectedMobility = uiState.selectedMobility,
                            onSelectMobility = { viewModel.selectMobilityFilter(it) }
                        )
                    }
                    AppNavigationTab.LOOK_ALIKE -> {
                        LookAlikeScreen(
                            lookAlikes = viewModel.allLookAlikes
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun RowScope.NavTabItem(
    tab: AppNavigationTab,
    icon: ImageVector,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    NavigationBarItem(
        selected = isSelected,
        onClick = onClick,
        icon = {
            Icon(
                imageVector = icon,
                contentDescription = tab.labelBn,
                modifier = Modifier.size(20.dp)
            )
        },
        label = {
            Text(
                text = tab.labelBn.split(" ")[0],
                fontSize = 10.sp,
                maxLines = 1
            )
        },
        modifier = Modifier.testTag("nav_tab_${tab.name.lowercase()}")
    )
}
