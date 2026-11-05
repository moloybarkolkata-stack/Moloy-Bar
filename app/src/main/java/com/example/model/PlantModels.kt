package com.example.model

/**
 * জলজ উদ্ভিদের রূপতাত্ত্বিক শ্রেণী
 */
enum class PlantCategory(val labelBn: String) {
    STEM("কাণ্ডযুক্ত উদ্ভিদ (Stem)"),
    ROSETTE("রোসেট উদ্ভিদ (Rosette)"),
    RHIZOME_EPIPHYTE("রাইজোম ও এপিফাইট (Rhizome/Epiphyte)"),
    CARPET("কার্পেট উদ্ভিদ (Stoloniferous Carpet)"),
    BULB_TUBER("বাল্ব ও টিউবার (Bulb/Tuber)"),
    MOSS_LIVERWORT("মস ও লিভারওয়ার্ট (Moss/Liverwort)"),
    FLOATING("ভাসমান উদ্ভিদ (Floating)")
}

/**
 * অ্যাকোয়াস্কেপ জোন
 */
enum class ScapeZone(val labelBn: String) {
    FOREGROUND("ফোরগ্রাউন্ড (Foreground)"),
    MIDGROUND("মিডগ্রাউন্ড (Midground)"),
    BACKGROUND("ব্যাকগ্রাউন্ড (Background)"),
    HARDSCAPE_EPIPHYTE("হার্ডস্কেপ এপিফাইট (Epiphyte)"),
    SURFACE_ACCENT("পৃষ্ঠদেশের ভাসমান (Surface)")
}

/**
 * পাতার গঠন ও টেক্সচার
 */
enum class LeafTexture(val labelBn: String) {
    FINE_FEATHERY("সূক্ষ্ম পালকসদৃশ (Fine/Feathery)"),
    STRAP_LIKE("ফিতার মতো দীর্ঘ (Strap-like)"),
    BROAD_OVAL("প্রশস্ত ডিম্বাকৃতি (Broad/Oval)"),
    BULLATE("উঁচু-নিচু খাঁজকাটা (Bullate/Dimpled)"),
    NEEDLE_LEAVED("তীক্ষ্ণ সূঁচালো (Needle-leaved)"),
    ROUND_TINY("ক্ষুদ্র গোলাকার (Miniature Round)")
}

/**
 * বৃদ্ধির গতি
 */
enum class GrowthRate(val labelBn: String) {
    SLOW("ধীরগতির (Slow)"),
    MODERATE("মাঝারি গতির (Moderate)"),
    FAST("দ্রুতগতির (Fast)"),
    VERY_FAST("অত্যন্ত দ্রুতগতির (Very Fast)")
}

/**
 * পুষ্টি গ্রহণের প্রধান মাধ্যম
 */
enum class NutrientUptake(val labelBn: String) {
    HEAVY_ROOT_FEEDER("মূলত শিকড় দ্বারা (Heavy Root Feeder)"),
    WATER_COLUMN_FEEDER("মূলত পানির কলাম দ্বারা (Water Column Feeder)"),
    BALANCED_UPTAKE("শিকড় ও কলাম উভয় মাধ্যম (Balanced)")
}

/**
 * ছাঁটাই পদ্ধতি
 */
enum class PruningMethod(val labelBn: String) {
    TOPPING_BRANCHING("টপিং/শীর্ষ ছাঁটাই (Multi-branching Bush)"),
    UPROOT_AND_REPLANT("আপরুট ও শীর্ষ প্রতিস্থাপন (Uproot & Replant Tops)"),
    RHIZOME_DIVISION("রাইজোম ব্যবচ্ছেদ (Rhizome Splitting)"),
    RUNNER_SEPARATION("রানার ও স্টোলন পৃথকীকরণ (Stolon Trimming)"),
    OUTER_LEAF_REMOVAL("পুরাতন বাইরের পাতা কর্তন (Outer Leaf Removal)")
}

/**
 * কাল্টিভার ও ট্রেড ভেরিয়েন্ট
 */
data class CultivarVariant(
    val name: String,
    val tradeNameBn: String,
    val distinguishingFeatureBn: String,
    val colorToneHex: Long,
    val nitrateSensitivityBn: String
)

/**
 * প্রাকৃতিক বায়োটোপ ও ভৌগোলিক উৎপত্তি
 */
data class BiotopeOrigin(
    val regionBn: String,
    val habitatDescriptionBn: String,
    val flowTypeBn: String, // e.g. তীব্র খরস্রোতা পাহাড়ি ঝরনা (Torrential rheophytic stream)
    val substrateInWildBn: String,
    val ecologicalStatusBn: String, // বন্য পরিবেশে বিপন্ন / চরম আগ্রাসী
    val invasivePotentialBn: String
)

/**
 * রূপতত্ত্ব ও গঠন
 */
data class MorphologyHabit(
    val category: PlantCategory,
    val maxHeightCm: String,
    val leafSpanCm: String,
    val stemThicknessMm: String,
    val rootStructureBn: String
)

/**
 * ভিজ্যুয়াল ডাইমরফিজম (এমর্সড বনাম নিমজ্জিত) ও আলোর বর্ণালী প্রতিক্রিয়া
 */
data class DimorphismSpectrum(
    val emersedDescriptionBn: String,
    val submersedDescriptionBn: String,
    val emersedLeafShapeBn: String,
    val submersedLeafShapeBn: String,
    val flowerInflorescenceBn: String,
    val wrgbSpectrumReactionBn: String,
    val nitrateLimitationShiftBn: String,
    val lowLightColorHex: Long = 0xFF388E3C, // ডিফল্ট সবুজ
    val highLightColorHex: Long = 0xFFD32F2F, // উচ্চ আলোতে লাল
    val emersedColorHex: Long = 0xFF2E7D32 // এমর্সড সবুজ
)

/**
 * চাষাবাদ ও পানির প্যারামিটার ম্যাট্রিক্স
 */
data class CultivationMatrix(
    val parRangeMicroMol: String, // e.g. "30–60" বা "80+"
    val parLevelBn: String, // কম / মাঝারি / উচ্চ
    val co2DemandPpm: String, // "25–35 ppm"
    val lowTechViable: Boolean,
    val lowTechViabilityNotesBn: String,
    val tempMinC: Int,
    val tempMaxC: Int,
    val tempOptimalC: String,
    val summerMeltWarningBn: String,
    val phRange: String,
    val khRange: String,
    val softWaterObligate: Boolean,
    val ghRange: String,
    val caMgRatioNotesBn: String,
    val primaryUptake: NutrientUptake,
    val substratePreferenceBn: String,
    val ironPotassiumDemandBn: String
)

/**
 * অ্যাকোয়াস্কেপিং নকশা ও প্রয়োগ
 */
data class AquascapeApplication(
    val zone: ScapeZone,
    val dutchStyleSuitabilityBn: String,
    val dutchStreetsViability: Boolean,
    val natureIwagumiSuitabilityBn: String,
    val leafTexture: LeafTexture,
    val growthRate: GrowthRate,
    val shadowingRiskBn: String
)

/**
 * ছাঁটাই ও জীবনচক্র ব্যবস্থাপনা
 */
data class PruningAndLifecycle(
    val pruningMethod: PruningMethod,
    val pruningInstructionsBn: String,
    val propagationMethodsBn: List<String>,
    val meltingTriggersBn: String,
    val dormancyRestRequired: Boolean,
    val dormancyCareNotesBn: String
)

/**
 * পূর্ণাঙ্গ মানসম্মত প্রজাতি এন্ট্রি (Core Plant Profile)
 */
data class AquaticPlant(
    val id: String,
    val scientificName: String,
    val authority: String,
    val family: String,
    val commonNameBn: String,
    val tradeSynonyms: List<String>,
    val obsoleteNames: List<String>,
    val etymologyBn: String,
    val cultivars: List<CultivarVariant>,
    val biotope: BiotopeOrigin,
    val morphology: MorphologyHabit,
    val dimorphism: DimorphismSpectrum,
    val cultivation: CultivationMatrix,
    val aquascape: AquascapeApplication,
    val care: PruningAndLifecycle,
    val livestockCompatibilityBn: String
)

/**
 * তুলনামূলক লুক-অ্যালাইক গাইড এন্ট্রি
 */
data class LookAlikeComparison(
    val id: String,
    val titleBn: String,
    val primarySpecies: String,
    val primarySpeciesBn: String,
    val confusedSpecies: String,
    val confusedSpeciesBn: String,
    val keyDiagnosticDifferenceBn: String,
    val leafComparisonBn: String,
    val growthHabitComparisonBn: String,
    val cultivationDifferenceBn: String
)

/**
 * পুষ্টি ঘাটতি প্যাথোলজি
 */
enum class NutrientMobility(val labelBn: String) {
    MOBILE_OLD_LEAVES("মোবাইল পুষ্টি (পুরাতন পাতায় লক্ষণ)"),
    IMMOBILE_NEW_GROWTH("ইম্মোবাইল পুষ্টি (কচি/নতুন ডগায় লক্ষণ)")
}

data class DeficiencyPathology(
    val id: String,
    val nutrientNameBn: String,
    val chemicalSymbol: String,
    val mobility: NutrientMobility,
    val visualSymptomsBn: String,
    val commonMisconceptionBn: String,
    val correctiveActionBn: String,
    val mostSensitivePlantsBn: String
)

/**
 * শৈবাল সংবেদনশীলতা ও চিকিৎসা
 */
data class AlgaeVulnerability(
    val id: String,
    val algaeNameBn: String,
    val scientificGroup: String,
    val targetPlantHabitsBn: String,
    val rootCausesBn: String,
    val glutaraldehydeSafeDoseBn: String,
    val hydrogenPeroxideSafeDoseBn: String,
    val sensitiveSpeciesWarningBn: String
)

/**
 * ওয়াবি-কুসা ও এমর্সড ফার্মিং গাইড
 */
data class WabiKusaStep(
    val stepNumber: Int,
    val titleBn: String,
    val descriptionBn: String,
    val humidityRequirementBn: String,
    val transitionDurationBn: String
)
