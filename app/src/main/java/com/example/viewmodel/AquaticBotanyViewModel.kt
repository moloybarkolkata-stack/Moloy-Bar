package com.example.viewmodel

import androidx.lifecycle.ViewModel
import com.example.data.AquaticBotanyRepository
import com.example.model.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlin.math.pow
import kotlin.math.roundToInt

enum class AppNavigationTab(val labelBn: String) {
    CATALOG("উদ্ভিদ বিশ্বকোষ"),
    DIMORPHISM_LAB("ডাইমরফিজম ও স্পেকট্রাম"),
    CALCULATOR("প্যারামিটার ক্যালকুলেটর"),
    PATHOLOGY("পুষ্টি ও শৈবাল অ্যাটলাস"),
    LOOK_ALIKE("লুক-অ্যালাইক গাইড")
}

data class UiState(
    val currentTab: AppNavigationTab = AppNavigationTab.CATALOG,
    val selectedPlantId: String = "rotala_rotundifolia",
    val isDetailOpen: Boolean = false,
    
    // অনুসন্ধান ও ফিল্টার
    val searchQuery: String = "",
    val selectedCategory: PlantCategory? = null,
    val selectedZone: ScapeZone? = null,
    val filterOnlyRedPlants: Boolean = false,
    val filterOnlyLowTech: Boolean = false,
    val filterOnlySoftWater: Boolean = false,
    val favoritePlantIds: Set<String> = emptySet(),

    // ডাইমরফিজম ইন্টারেক্টিভ স্প্লিট স্লাইডার (০.০ থেকে ১.০)
    val emersedSubmersedSplitRatio: Float = 0.5f,

    // WRGB স্পেকট্রাম সিমুলেটর
    val parLevel: Float = 85f, // µmol/m²/s
    val red660Intensity: Float = 90f, // ০ - ১০০%
    val greenIntensity: Float = 40f,
    val blue450Intensity: Float = 75f,
    val whiteIntensity: Float = 80f,
    val isNitrateLimited: Boolean = true, // নাইট্রেট < ৫ পিপিএম

    // ওয়াটার প্যারামিটার ম্যাচিং টুল
    val inputPh: Float = 6.6f,
    val inputKh: Float = 3.0f,
    val inputGh: Float = 5.0f,
    val inputTempC: Int = 24,
    val inputPar: Float = 70f,

    // প্যাথোলজি ফিল্টার
    val selectedMobility: NutrientMobility? = null
)

class AquaticBotanyViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    val allPlants: List<AquaticPlant> = AquaticBotanyRepository.plants
    val allLookAlikes: List<LookAlikeComparison> = AquaticBotanyRepository.lookAlikes
    val allDeficiencies: List<DeficiencyPathology> = AquaticBotanyRepository.deficiencies
    val allAlgaeTreatments: List<AlgaeVulnerability> = AquaticBotanyRepository.algaeTreatments
    val allWabiKusaSteps: List<WabiKusaStep> = AquaticBotanyRepository.wabiKusaSteps

    fun setTab(tab: AppNavigationTab) {
        _uiState.update { it.copy(currentTab = tab, isDetailOpen = false) }
    }

    fun openPlantDetail(plantId: String) {
        _uiState.update { it.copy(selectedPlantId = plantId, isDetailOpen = true) }
    }

    fun closePlantDetail() {
        _uiState.update { it.copy(isDetailOpen = false) }
    }

    fun setSearchQuery(query: String) {
        _uiState.update { it.copy(searchQuery = query) }
    }

    fun selectCategory(category: PlantCategory?) {
        _uiState.update {
            it.copy(selectedCategory = if (it.selectedCategory == category) null else category)
        }
    }

    fun selectZone(zone: ScapeZone?) {
        _uiState.update {
            it.copy(selectedZone = if (it.selectedZone == zone) null else zone)
        }
    }

    fun toggleRedPlantsFilter() {
        _uiState.update { it.copy(filterOnlyRedPlants = !it.filterOnlyRedPlants) }
    }

    fun toggleLowTechFilter() {
        _uiState.update { it.copy(filterOnlyLowTech = !it.filterOnlyLowTech) }
    }

    fun toggleSoftWaterFilter() {
        _uiState.update { it.copy(filterOnlySoftWater = !it.filterOnlySoftWater) }
    }

    fun toggleFavorite(plantId: String) {
        _uiState.update { state ->
            val newFavorites = if (state.favoritePlantIds.contains(plantId)) {
                state.favoritePlantIds - plantId
            } else {
                state.favoritePlantIds + plantId
            }
            state.copy(favoritePlantIds = newFavorites)
        }
    }

    // স্প্লিট স্লাইডার ড্র্যাগ হ্যান্ডলার
    fun updateSplitRatio(ratio: Float) {
        _uiState.update { it.copy(emersedSubmersedSplitRatio = ratio.coerceIn(0.05f, 0.95f)) }
    }

    // WRGB স্পেকট্রাম কন্ট্রোল
    fun updatePar(par: Float) {
        _uiState.update { it.copy(parLevel = par) }
    }

    fun updateRed660(value: Float) {
        _uiState.update { it.copy(red660Intensity = value) }
    }

    fun updateGreen(value: Float) {
        _uiState.update { it.copy(greenIntensity = value) }
    }

    fun updateBlue450(value: Float) {
        _uiState.update { it.copy(blue450Intensity = value) }
    }

    fun updateWhite(value: Float) {
        _uiState.update { it.copy(whiteIntensity = value) }
    }

    fun toggleNitrateLimitation() {
        _uiState.update { it.copy(isNitrateLimited = !it.isNitrateLimited) }
    }

    // ক্যালকুলেটর ইনপুট হ্যান্ডলার
    fun updateCalculatorPh(ph: Float) {
        _uiState.update { it.copy(inputPh = ph) }
    }

    fun updateCalculatorKh(kh: Float) {
        _uiState.update { it.copy(inputKh = kh) }
    }

    fun updateCalculatorGh(gh: Float) {
        _uiState.update { it.copy(inputGh = gh) }
    }

    fun updateCalculatorTemp(temp: Int) {
        _uiState.update { it.copy(inputTempC = temp) }
    }

    fun updateCalculatorPar(par: Float) {
        _uiState.update { it.copy(inputPar = par) }
    }

    fun selectMobilityFilter(mobility: NutrientMobility?) {
        _uiState.update {
            it.copy(selectedMobility = if (it.selectedMobility == mobility) null else mobility)
        }
    }

    /**
     * pH এবং KH সমীকরণ দ্বারা দ্রবীভূত কার্বন ডাই অক্সাইড ($CO_2$) পিপিএম গণনা
     * সমীকরণ: CO2 (ppm) = 3.0 * KH * 10^(7.0 - pH)
     */
    fun calculateCo2Ppm(ph: Float, kh: Float): Float {
        if (ph <= 0f || kh <= 0f) return 0f
        val exponent = (7.0f - ph).toDouble()
        val ppm = 3.0 * kh * 10.0.pow(exponent)
        return (ppm * 10.0).roundToInt() / 10.0f
    }

    /**
     * CO2 এর নিরাপত্তা অঞ্চল শ্রেণিবিভাগ
     */
    fun getCo2Status(co2Ppm: Float): Co2Status {
        return when {
            co2Ppm < 15f -> Co2Status.LOW("অপর্যাপ্ত (উদ্ভিদের জন্য শ্লথ বৃদ্ধি)", 0xFFFFA726)
            co2Ppm in 15f..35f -> Co2Status.OPTIMAL("সর্বোত্তম ও নিরাপদ (উদ্ভিদ ও মাছের জন্য আদর্শ)", 0xFF00E5A3)
            co2Ppm in 35.1f..45f -> Co2Status.HIGH("উচ্চ মাত্রা (মাছের সতর্ক পর্যবেক্ষণ প্রয়োজন)", 0xFFFF7043)
            else -> Co2Status.DANGEROUS("বিপজ্জনক! (মাছ ও চিংড়ির জন্য বিষাক্ত)", 0xFFEF5350)
        }
    }

    /**
     * ব্যবহারকারীর ইনপুট প্যারামিটারের সাথে মিলিয়ে উপযুক্ত উদ্ভিদের তালিকা ফিল্টার
     */
    fun getMatchedPlants(ph: Float, kh: Float, temp: Int, par: Float): List<AquaticPlant> {
        return allPlants.filter { plant ->
            val tempMatch = temp in plant.cultivation.tempMinC..plant.cultivation.tempMaxC
            val khMatch = if (plant.cultivation.softWaterObligate) kh <= 3.5f else true
            tempMatch && khMatch
        }
    }
}

sealed class Co2Status(val labelBn: String, val colorHex: Long) {
    class LOW(labelBn: String, colorHex: Long) : Co2Status(labelBn, colorHex)
    class OPTIMAL(labelBn: String, colorHex: Long) : Co2Status(labelBn, colorHex)
    class HIGH(labelBn: String, colorHex: Long) : Co2Status(labelBn, colorHex)
    class DANGEROUS(labelBn: String, colorHex: Long) : Co2Status(labelBn, colorHex)
}
