package com.example.data

import com.example.model.*

object AquaticBotanyRepository {

    val plants: List<AquaticPlant> = listOf(
        // 1. Rotala rotundifolia
        AquaticPlant(
            id = "rotala_rotundifolia",
            scientificName = "Rotala rotundifolia",
            authority = "(Buch.-Ham. ex Roxb.) Koehne",
            family = "Lythraceae (লাইথ্রেসি)",
            commonNameBn = "রোটালা রোটান্ডিফোলিয়া (গোলাকার পত্র কাণ্ড)",
            tradeSynonyms = listOf("Rotala indica (পূর্ববর্তী শৌখিন ভুল নাম)", "Ammannia rotundifolia"),
            obsoleteNames = listOf("Rotala indica (misapplied)"),
            etymologyBn = "ল্যাটিন 'Rotala' অর্থ ক্ষুদ্র চাকা (ঘূর্ণায়মান পাতা বিন্যাস) এবং 'rotundifolia' অর্থ গোলাকার পাতা, যা মূলত এর এমর্সড (জলের বাইরের) পাতার রূপকে নির্দেশ করে।",
            cultivars = listOf(
                CultivarVariant(
                    name = "Rotala rotundifolia 'Green'",
                    tradeNameBn = "রোটালা গ্রিন",
                    distinguishingFeatureBn = "উচ্চ তীব্রতার আলো ও শূন্য নাইট্রেটেও পাতা সর্বদা প্রাণবন্ত উজ্জ্বল সবুজ থাকে, কোনো লাল বর্ণ ধারণ করে না। ডাচ স্টাইলে চমৎকার খাড়া ঝোপ তৈরি করে।",
                    colorToneHex = 0xFF4CAF50,
                    nitrateSensitivityBn = "অসংবেদনশীল (সর্বদা সবুজ)"
                ),
                CultivarVariant(
                    name = "Rotala rotundifolia 'H'Ra' (Gia Lai)",
                    tradeNameBn = "রোটালা হ্রা / ভিয়েতনামী এইচ'রা",
                    distinguishingFeatureBn = "উচ্চ আলো ও অনুভূমিক বৃদ্ধি প্রবণতা। নাইট্রেট নিয়ন্ত্রিত রাখলে পাতার শীর্ষ গাঢ় কমলা-লাল ও নিচের দিক মনোরম গোলাপী আভা ধারণ করে।",
                    colorToneHex = 0xFFFF5722,
                    nitrateSensitivityBn = "নাইট্রেট < ৫ পিপিএম হলে গাঢ় কমলা-লাল"
                ),
                CultivarVariant(
                    name = "Rotala rotundifolia 'Orange Juice'",
                    tradeNameBn = "রোটালা অরেঞ্জ জুস",
                    distinguishingFeatureBn = "নাইট্রেট বেশি থাকলেও পাতা সোনালী-কমলা আভা বজায় রাখে। পাতার কিনারা মসৃণ ও তীক্ষ্ণ।",
                    colorToneHex = 0xFFFF9800,
                    nitrateSensitivityBn = "মাঝারি নাইট্রেটেও অবিচল কমলা"
                ),
                CultivarVariant(
                    name = "Rotala rotundifolia 'Blood Red SG'",
                    tradeNameBn = "রোটালা ব্লাড রেড (সিঙ্গাপুর ভ্যারাইটি)",
                    distinguishingFeatureBn = "বিশ্বের সবচেয়ে গাঢ় লাল রোটালা। এমনকি উচ্চ নাইট্রেট মাত্রাতেও পাতা ফিকে হয় না, সম্পূর্ণ রক্তিম লাল রঙ ধারণ করে।",
                    colorToneHex = 0xFFD32F2F,
                    nitrateSensitivityBn = "নাইট্রেট সমৃদ্ধ পানিতেও নিখাদ রক্তিম লাল"
                )
            ),
            biotope = BiotopeOrigin(
                regionBn = "দক্ষিণ ও দক্ষিণ-পূর্ব এশিয়া (ভারত, চীন, ভিয়েতনাম, থাইল্যান্ড)",
                habitatDescriptionBn = "মৌসুমী ধানক্ষেতের আইল, অগভীর খাল-বিল এবং প্লাবনভূমি যেখানে বর্ষায় গাছ সম্পূর্ণ জলের নিচে থাকে এবং গ্রীষ্মে স্যাঁতসেঁতে মাটিতে এমর্সড ফুলে ভরে ওঠে।",
                flowTypeBn = "স্থির অথবা অত্যন্ত মৃদু জলপ্রবাহ",
                substrateInWildBn = "কাদামাটি ও পলিযুক্ত সমৃদ্ধ তলদেশ",
                ecologicalStatusBn = "প্রকৃতিতে অতি প্রাচুর্যময় (Least Concern)",
                invasivePotentialBn = "উষ্ণমন্ডলীয় জলাশয়ে বিস্তার লাভের মাঝারি ঝুঁকি"
            ),
            morphology = MorphologyHabit(
                category = PlantCategory.STEM,
                maxHeightCm = "২০–৫০ সেমি",
                leafSpanCm = "১.৫–৩.০ সেমি",
                stemThicknessMm = "১.০–১.৫ মিমি",
                rootStructureBn = "প্রতিটি ইন্টারনোড (পর্ব) থেকে সূক্ষ্ম সাদা অ্যাডভেনটিটিয়াস ওয়াটার রুট নির্গত হয়।"
            ),
            dimorphism = DimorphismSpectrum(
                emersedDescriptionBn = "জলের উপরে পাতার রূপ সম্পূর্ণ আলাদা: পাতা ছোট, গোল ও মাংসল (কয়েনের মতো), কাণ্ড শক্ত ও খাড়া। ক্ষুদ্র গোলাপী পুষ্পমঞ্জরি গঠিত হয়।",
                submersedDescriptionBn = "জলের নিচে নিমজ্জিত হলে পাতা পরিবর্তিত হয়ে সরু, লম্বা, বর্শাফলা আকৃতির (Lanceolate) এবং অত্যন্ত নমনীয় হয়। রঙ সবুজ থেকে রক্তিম বর্ণে রূপ নেয়।",
                emersedLeafShapeBn = "গোলাকার/ডিম্বাকৃতি (Orbicular-ovate)",
                submersedLeafShapeBn = "সরু ও লম্বা বর্শাকৃতি (Linear-lanceolate)",
                flowerInflorescenceBn = "শীর্ষমুকুলে ক্ষুদ্র গুচ্ছাকারে গোলাপী-বেগুনি বর্ণের চতুর্ভাগ ফুল ফোটে।",
                wrgbSpectrumReactionBn = "উচ্চ PAR (৮০+ µmol) এবং ডিপ রেড (660nm) স্পেকট্রামে দ্রুত অ্যান্থোসায়ানিন পিগমেন্টেশন বৃদ্ধি পায় এবং কাণ্ড অনুভূমিকভাবে বেঁকে ঘন ঝোপ তৈরি করে।",
                nitrateLimitationShiftBn = "নাইট্রেট (NO₃) ৫ পিপিএমের নিচে নামিয়ে দিলে ক্লোরোফিল সংশ্লেষণ কমে যায় এবং উজ্জ্বল ক্যারোটিনয়েড ও অ্যান্থোসায়ানিনের প্রভাবে পাতা রক্তলাল হয়ে ওঠে।",
                lowLightColorHex = 0xFF66BB6A,
                highLightColorHex = 0xFFD32F2F,
                emersedColorHex = 0xFF2E7D32
            ),
            cultivation = CultivationMatrix(
                parRangeMicroMol = "৫০–১২০ µmol/m²/s",
                parLevelBn = "মাঝারি থেকে অত্যন্ত উচ্চ",
                co2DemandPpm = "২০–৩০ ppm (উজ্জ্বল লাল বর্ণের জন্য আবশ্যক)",
                lowTechViable = true,
                lowTechViabilityNotesBn = "লো-টেক নন-CO2 ট্যাঙ্কেও বেঁচে থাকে, তবে পাতার রঙ সম্পূর্ণ সবুজ থাকবে এবং বৃদ্ধি কিছুটা ধীর হবে।",
                tempMinC = 18,
                tempMaxC = 30,
                tempOptimalC = "২২°–২৬° সে.",
                summerMeltWarningBn = "২৯° সে. এর উপরে দীর্ঘকাল থাকলে কাণ্ডের নিচের অংশের পাতা কালো হয়ে পচে যেতে পারে।",
                phRange = "৫.৫ – ৭.২",
                khRange = "০ – ৮ dKH",
                softWaterObligate = false,
                ghRange = "২ – ১২ dGH",
                caMgRatioNotesBn = "৩:১ Ca:Mg অনুপাত বজায় রাখলে শীর্ষ মুকুলের বিকৃতি রোধ হয়।",
                primaryUptake = NutrientUptake.WATER_COLUMN_FEEDER,
                substratePreferenceBn = "অ্যাকোয়াসয়েল দ্রুত মূল বিস্তারে সহায়ক, তবে ওয়াটার কলাম সার পেলেই চমৎকার বৃদ্ধি পায়।",
                ironPotassiumDemandBn = "উচ্চ আয়রন (Fe) এবং পর্যাপ্ত পটাশিয়াম (K) পাতার কিনারা সতেজ রাখে।"
            ),
            aquascape = AquascapeApplication(
                zone = ScapeZone.BACKGROUND,
                dutchStyleSuitabilityBn = "ডাচ স্টাইলের 'স্ট্রিট' বা রঙিন পর্দা তৈরির জন্য অবিসংবাদিত রাজা। নিয়মিত শীর্ষ ছাঁটাইয়ে ঘন ক্যানোপি তৈরি করে।",
                dutchStreetsViability = true,
                natureIwagumiSuitabilityBn = "নেচার অ্যাকোয়ারিয়ামে ব্যাকগ্রাউন্ডে রঙের বৈপরীত্য আনতে চমৎকার।",
                leafTexture = LeafTexture.FINE_FEATHERY,
                growthRate = GrowthRate.FAST,
                shadowingRiskBn = "উচ্চ ঝুঁকি; দ্রুত জলের উপরিভাগে পৌঁছে নিচের পাতাগুলোকে আলোহীন করে ফেলে।"
            ),
            care = PruningAndLifecycle(
                pruningMethod = PruningMethod.TOPPING_BRANCHING,
                pruningInstructionsBn = "কাণ্ডের যে কোনো স্থানে ধারালো কাঁচি দিয়ে কেটে দিলে প্রতিটি কাটা স্থান থেকে ২-৩টি নতুন শাখা বের হয়। ঘন ঝোপ তৈরির পর তলদেশ পরিষ্কার রাখতে মাঝেমধ্যে আপরুট করে শীর্ষ পুনরায় রোপণ করতে হয়।",
                propagationMethodsBn = listOf("শীর্ষ কাটিং (Stem Cutting)", "পার্শ্বীয় শাখা পৃথকীকরণ", "অ্যাডভেনটিটিয়াস মুকুল"),
                meltingTriggersBn = "হঠাৎ pH বা KH এর তীব্র পরিবর্তন এবং আলোহীন অতিরিক্ত ঘনত্বে নিচের ডাল গলে যাওয়া।",
                dormancyRestRequired = false,
                dormancyCareNotesBn = "কোনো ডরম্যান্সি বা বিশ্রামের প্রয়োজন নেই; বছরজুড়ে অবিরাম বৃদ্ধি পায়।"
            ),
            livestockCompatibilityBn = "সকল প্রজাতির ন্যানো ফিশ, টেট্রা এবং নিওকার্ডিফিনা শ্রিম্পের জন্য নিরাপদ। উদ্ভিদভোজী বড় সিনক্লিড পাতা ছিঁড়ে ফেলতে পারে।"
        ),

        // 2. Bucephalandra motleyana / catherineae
        AquaticPlant(
            id = "bucephalandra_spp",
            scientificName = "Bucephalandra spp.",
            authority = "Schott (১৮৫৮)",
            family = "Araceae (অ্যারাসি)",
            commonNameBn = "বুসেফাল্যান্ড্রা (বোর্নিও রিওফাইট রত্ন)",
            tradeSynonyms = listOf("Bucephalandra 'Kedagang'", "Bucephalandra 'Godzilla'", "Bucephalandra 'Theia'"),
            obsoleteNames = listOf("Microcasia (ঐতিহাসিক)"),
            etymologyBn = "গ্রিক 'Bous' (ষাঁড়) এবং 'kephale' (মাথা) এবং 'anther' (পরাগধানী) থেকে উদ্ভূত, যার পরাগধানী দেখতে ষাঁড়ের শিংয়ের মতো।",
            cultivars = listOf(
                CultivarVariant(
                    name = "Bucephalandra 'Kedagang'",
                    tradeNameBn = "বুসে কেডাগাং",
                    distinguishingFeatureBn = "লম্বাটে খাঁজকাটা পাতা, পৃষ্ঠদেশে ধাতব নীল-সবুজ ও বেগুনি আভা এবং ক্ষুদ্র রূপালী বিন্দুর মতো স্টোমাটা ঝলমল করে।",
                    colorToneHex = 0xFF3F51B5,
                    nitrateSensitivityBn = "কম নাইট্রেটে গাঢ় নীল-ধাতব রূপ ধারণ করে"
                ),
                CultivarVariant(
                    name = "Bucephalandra 'Theia'",
                    tradeNameBn = "বুসে থিয়া",
                    distinguishingFeatureBn = "প্রশস্ত উপবৃত্তাকার পাতা, কচি পাতা তাম্র-লাল ও পরিণত পাতা গাঢ় সবুজাভ নীল। দ্রুত ফুল ফোটায়।",
                    colorToneHex = 0xFF009688,
                    nitrateSensitivityBn = "মাঝারি পুষ্টিতে দ্রুত বৃদ্ধি"
                )
            ),
            biotope = BiotopeOrigin(
                regionBn = "বোর্নিও দ্বীপ (ইন্দোনেশিয়া, মালয়েশিয়া)",
                habitatDescriptionBn = "বৃষ্টিঅরণ্যের ঘন ছায়াযুক্ত খরস্রোতা পাহাড়ি ঝরনার বেসাল্ট পাথর ও গাছের গুঁড়িতে শক্ত শিকড় দিয়ে আঁকড়ে থাকে। বর্ষার তীব্র জলস্রোতে সম্পূর্ণ নিমজ্জিত থাকে।",
                flowTypeBn = "তীব্র খরস্রোতা রিয়োফাইটিক (Rheophytic torrential stream)",
                substrateInWildBn = "আগ্নেয় শিলা, বেসাল্ট পাথর এবং ভেজা কাঠের বল্কল",
                ecologicalStatusBn = "প্রকৃতিতে বিপন্ন (অতিরিক্ত আহরণ ও বন উজাড়ের কারণে সংকটাপন্ন)",
                invasivePotentialBn = "কোনো আগ্রাসী ঝুঁকি নেই (অতি ধীরগতির বৃদ্ধি)"
            ),
            morphology = MorphologyHabit(
                category = PlantCategory.RHIZOME_EPIPHYTE,
                maxHeightCm = "৩–১০ সেমি",
                leafSpanCm = "২–৫ সেমি",
                stemThicknessMm = "২.০–৩.৫ মিমি ক্রিপিং রাইজোম",
                rootStructureBn = "শক্ত আঠালো রুটলেটস যা পাথর বা কাঠে সরাসরি নোঙ্গর করে।"
            ),
            dimorphism = DimorphismSpectrum(
                emersedDescriptionBn = "জলের উপরে আর্দ্র পাথরে পাতা কিছুটা শক্ত ও মোমের মতো থাকে। স্প্যাথ বা ফুলের মঞ্জরি জলের ওপরে নিয়মিত ফোটে।",
                submersedDescriptionBn = "জলের নিচে পাতার ওপরে রূপালী/সোনালী তেলতেলে মাইক্রো-ডট ঝলমল করে। আলো প্রতিফলিত হয়ে ধাতব নীল বা বেগুনি আভা ফুটে ওঠে।",
                emersedLeafShapeBn = "মসৃণ ত্বকযুক্ত চামড়ার মতো পাতা",
                submersedLeafShapeBn = "তরঙ্গায়িত খাঁজকাটা চকচকে রূপালী-বিন্দুযুক্ত পাতা",
                flowerInflorescenceBn = "জলের তলদেশেও চমৎকার সাদা রঙের স্প্যাথ (Spathe) ফুল উন্মোচিত হয়।",
                wrgbSpectrumReactionBn = "রয়্যাল ব্লু (450nm) ও সাদা আলোর মিশ্রণে পাতার ধাতব নীল দীপ্তি সর্বোচ্চ ফুটে ওঠে।",
                nitrateLimitationShiftBn = "কম পুষ্টিতে বৃদ্ধি আরও ধীর হয় কিন্তু পাতার উপরিভাগের রত্নসম বিন্দুগুলো প্রস্ফুটিত হয়।",
                lowLightColorHex = 0xFF1B5E20,
                highLightColorHex = 0xFF303F9F,
                emersedColorHex = 0xFF2E7D32
            ),
            cultivation = CultivationMatrix(
                parRangeMicroMol = "২০–৬০ µmol/m²/s",
                parLevelBn = "কম থেকে মাঝারি (অতিরিক্ত আলোতে শৈবালের ঝুঁকি)",
                co2DemandPpm = "১০–২০ ppm (CO2 ছাড়া বেঁচে থাকে, দিলে বৃদ্ধি দ্রুত হয়)",
                lowTechViable = true,
                lowTechViabilityNotesBn = "লো-টেক ফিল্টারযুক্ত সাধারণ অ্যাকোয়ারিয়ামে পাথরে বেঁধে রাখলে চমৎকার টিকে থাকে।",
                tempMinC = 20,
                tempMaxC = 28,
                tempOptimalC = "২২°–২৫° সে.",
                summerMeltWarningBn = "২৯° সে. এর বেশি তাপমাত্রায় রাইজোম পচন (Rhizome Rot) শুরু হতে পারে।",
                phRange = "৫.৫ – ৭.০",
                khRange = "০ – ৪ dKH (মৃদু পানি অত্যন্ত পছন্দনীয়)",
                softWaterObligate = true,
                ghRange = "২ – ৮ dGH",
                caMgRatioNotesBn = "ক্যালসিয়াম স্বল্পতায় পাতা কুঁকড়ে যেতে পারে।",
                primaryUptake = NutrientUptake.WATER_COLUMN_FEEDER,
                substratePreferenceBn = "কখনোই রাইজোম বালু বা মাটিতে পুঁতে দেওয়া যাবে না; কেবল পাথর বা কাঠে বাঁধতে হবে।",
                ironPotassiumDemandBn = "নিয়মিত ট্রেস এলিমেন্টস ও পটাশিয়াম প্রয়োগে পাতার উজ্জ্বলতা বাড়ে।"
            ),
            aquascape = AquascapeApplication(
                zone = ScapeZone.HARDSCAPE_EPIPHYTE,
                dutchStyleSuitabilityBn = "ডাচ স্টাইলে ব্যবহার কম, তবে লোয়ার ফোকাল পয়েন্টে বৈপরীত্য আনতে ব্যবহৃত হয়।",
                dutchStreetsViability = false,
                natureIwagumiSuitabilityBn = "নেচার অ্যাকোয়ারিয়াম ও হার্ডস্কেপের খাঁজে খাঁজে প্রাকৃতিক সৌন্দর্য আনার শ্রেষ্ঠ উদ্ভিদ।",
                leafTexture = LeafTexture.BULLATE,
                growthRate = GrowthRate.SLOW,
                shadowingRiskBn = "শূন্য; নিজেই দ্রুত বর্ধনশীল উদ্ভিদের ছায়ায় থাকতে ভালোবাসে।"
            ),
            care = PruningAndLifecycle(
                pruningMethod = PruningMethod.RHIZOME_DIVISION,
                pruningInstructionsBn = "ধারালো জীবাণুমুক্ত ব্লেড দিয়ে শক্ত রাইজোমের অন্তত ৩-৪টি পাতা সমেত অংশ কেটে পৃথক করে নতুন স্থানে সুতা বা অ্যাকোয়ারিয়াম গ্লু দিয়ে বাঁধতে হয়।",
                propagationMethodsBn = listOf("রাইজোম বিভাজন", "অ্যাক্সিলারি শুট পৃথকীকরণ"),
                meltingTriggersBn = "পানির তীব্র তাপ বৃদ্ধি, হঠাৎ জৈব বর্জ্যের (Organic waste) উল্লম্ফন এবং রাইজোম মাটিতে পুঁতে ফেলা।",
                dormancyRestRequired = false,
                dormancyCareNotesBn = "বিশ্রাম চক্রের প্রয়োজন নেই; পানির প্রবাহ বজায় রাখা অপরিহার্য।"
            ),
            livestockCompatibilityBn = "চিংড়ি (Caridina/Neocaridina) ও অটোসিনক্লাসের স্বর্গরাজ্য; পাতা থেকে ডায়াটম পরিষ্কার করে গাছ সুস্থ রাখে।"
        ),

        // 3. Cryptocoryne wendtii
        AquaticPlant(
            id = "cryptocoryne_wendtii",
            scientificName = "Cryptocoryne wendtii",
            authority = "de Wit (১৯৫৮)",
            family = "Araceae (অ্যারাসি)",
            commonNameBn = "ক্রিপ্টোকোরিন ওয়েন্ডটি (শ্রীলঙ্কান রোসেট ক্রিপ্ট)",
            tradeSynonyms = listOf("Cryptocoryne wendtii 'Brown'", "Cryptocoryne wendtii 'Green'", "Cryptocoryne 'Mi Oya'"),
            obsoleteNames = listOf("Cryptocoryne wendtii var. wendtii"),
            etymologyBn = "গ্রিক 'Kryptos' (লুকায়িত) এবং 'koryne' (মুগুর/ক্লাব), যা এর পুষ্পমঞ্জরির স্প্যাডিক্সের লুকায়িত গঠনকে বোঝায়। জার্মান উদ্ভিদবিজ্ঞানী আলবার্ট ওয়েন্ডটের সম্মানে নামাঙ্কিত।",
            cultivars = listOf(
                CultivarVariant(
                    name = "Cryptocoryne wendtii 'Brown'",
                    tradeNameBn = "ক্রিপ্ট ওয়েন্ডটি ব্রাউন",
                    distinguishingFeatureBn = "গাঢ় চকলেট ব্রোঞ্জ থেকে তামাটে রঙের বল্লমাকৃতির ঢেউখেলানো পাতা।",
                    colorToneHex = 0xFF5D4037,
                    nitrateSensitivityBn = "পুষ্টি সমৃদ্ধ মাটিতে সুবিশাল রোসেট গঠন"
                ),
                CultivarVariant(
                    name = "Cryptocoryne wendtii 'Green'",
                    tradeNameBn = "ক্রিপ্ট ওয়েন্ডটি গ্রিন",
                    distinguishingFeatureBn = "উজ্জ্বল পান্না সবুজ ঢেউখেলানো পাতা, যা ছায়াযুক্ত কোণেও চিরসবুজ থাকে।",
                    colorToneHex = 0xFF388E3C,
                    nitrateSensitivityBn = "স্থির বর্ণ বজায় রাখে"
                )
            ),
            biotope = BiotopeOrigin(
                regionBn = "শ্রীলঙ্কা (সেন্ট্রাল হাইল্যান্ডস ও নিম্নভূমি)",
                habitatDescriptionBn = "ঘন ছায়াঘেরা পাহাড়ি নদী ও জলধারার তলদেশে যেখানে পলিমাটি এবং ঝরা পাতার হিউমাসের স্তর থাকে। পানির রাসায়নিক মাত্রা খুবই স্থিতিশীল।",
                flowTypeBn = "ধীর থেকে মাঝারি স্রোতধারা",
                substrateInWildBn = "সমৃদ্ধ কাদা, নদীমাতৃক পলি ও ক্ষয়িষ্ণু জৈববস্তু",
                ecologicalStatusBn = "আবাসস্থল সংকোচনে স্থানীয়ভাবে ঝুঁকিপূর্ণ",
                invasivePotentialBn = "খুবই নগণ্য"
            ),
            morphology = MorphologyHabit(
                category = PlantCategory.ROSETTE,
                maxHeightCm = "১০–২৫ সেমি",
                leafSpanCm = "৮–১৫ সেমি",
                stemThicknessMm = "পাতার বোঁটা ২-৩ মিমি, কেন্দ্রীয় রোসেট ক্রাউন",
                rootStructureBn = "বিশাল, গভীর ও মাংসল রুট সিস্টেম যা মাটির বহু দূর পর্যন্ত বিস্তৃত হয়।"
            ),
            dimorphism = DimorphismSpectrum(
                emersedDescriptionBn = "জলের ওপরে আর্দ্র টেরারিয়াম বা প্যালুডারিয়ামে পাতা খাটো, চওড়া ও কিছুটা খসখসে হয়। সুন্দর প্যাঁচানো স্প্যাথের মাধ্যমে ফুল ফোটে।",
                submersedDescriptionBn = "জলের নিচে পাতার ফলক দীর্ঘায়িত হয়, কিনারা নাটকীয়ভাবে ঢেউখেলানো (Undulate) হয় এবং রঙ আরও গভীর ব্রোঞ্জ বা সবুজে রূপ নেয়।",
                emersedLeafShapeBn = "ডিম্বাকৃতি ও শক্ত পৃষ্ঠ",
                submersedLeafShapeBn = "দীর্ঘায়িত ঢেউখেলানো বল্লমাকৃতি",
                flowerInflorescenceBn = "জলের ওপরে টিউবের মতো বাঁকানো গাঢ় লালচে-বাদামী স্প্যাথ উন্মুক্ত হয়।",
                wrgbSpectrumReactionBn = "মাঝারি আলোতে পাতাগুলো সুন্দর অনুভূমিকভাবে বিছিয়ে যায়; অতিরিক্ত উচ্চ আলোতে রোসেট সংকুচিত হতে পারে।",
                nitrateLimitationShiftBn = "নাইট্রেট কমলে বাদামী ভ্যারাইটিতে তাম্র লালচে আভা বাড়ে, তবে মূল পুষ্টি শিকড় থেকে সংগ্রহ করে।",
                lowLightColorHex = 0xFF4E342E,
                highLightColorHex = 0xFF6D4C41,
                emersedColorHex = 0xFF2E7D32
            ),
            cultivation = CultivationMatrix(
                parRangeMicroMol = "২০–৫০ µmol/m²/s",
                parLevelBn = "কম থেকে মাঝারি",
                co2DemandPpm = "৫–১৫ ppm (CO2 ছাড়া অত্যন্ত সফলভাবে বেড়ে ওঠে)",
                lowTechViable = true,
                lowTechViabilityNotesBn = "লো-টেক ট্যাঙ্কের জন্য অন্যতম সেরা নির্ভরযোগ্য প্রজাতি।",
                tempMinC = 20,
                tempMaxC = 29,
                tempOptimalC = "২৩°–২৭° সে.",
                summerMeltWarningBn = "গ্রীষ্মকালে তাপমাত্রা ৩০° অতিক্রম করলে ক্রিপ্ট মেল্ট দেখা দিতে পারে।",
                phRange = "৬.০ – ৭.৮",
                khRange = "১ – ১২ dKH (কঠিন পানিতেও মানিয়ে নেয়)",
                softWaterObligate = false,
                ghRange = "৩ – ১৫ dGH",
                caMgRatioNotesBn = "প্রশস্ত সহনশীলতা সম্পন্ন।",
                primaryUptake = NutrientUptake.HEAVY_ROOT_FEEDER,
                substratePreferenceBn = "শিকড় পুষ্টির উপর ৯০% নির্ভরশীল; নিউট্রিয়েন্ট সমৃদ্ধ সয়েল বা রুট ট্যাব অপরিহার্য।",
                ironPotassiumDemandBn = "আয়রনসমৃদ্ধ মাটিতে পাতার ব্রোঞ্জ আভা চোখ ধাঁধানো হয়।"
            ),
            aquascape = AquascapeApplication(
                zone = ScapeZone.MIDGROUND,
                dutchStyleSuitabilityBn = "ডাচ স্টাইলে টেক্সচার ও রঙের ভারসাম্য আনতে মিডগ্রাউন্ড ফোকাল পয়েন্টে ব্যবহৃত হয়।",
                dutchStreetsViability = false,
                natureIwagumiSuitabilityBn = "পাথরের গোড়ায় বা ড্র Driftwood এর ছায়ায় প্রাকৃতিক ট্রানজিশন তৈরিতে আদর্শ।",
                leafTexture = LeafTexture.BULLATE,
                growthRate = GrowthRate.MODERATE,
                shadowingRiskBn = "কম; অন্যান্য লম্বা গাছের ছায়া উপভোগ করে।"
            ),
            care = PruningAndLifecycle(
                pruningMethod = PruningMethod.OUTER_LEAF_REMOVAL,
                pruningInstructionsBn = "কখনোই পুরো গাছ উপড়ে ফেলবেন না। কেবল বাইরের হলুদ বা ক্ষতিগ্রস্ত পাতাগুলো গোড়া থেকে কেটে দিন। শিকড় থেকে পার্শ্বীয় রানার তৈরি হলে তা পৃথক করুন।",
                propagationMethodsBn = listOf("আন্ডারগ্রাউন্ড রানার ও অফশুট", "রাইজোম বিভাজন"),
                meltingTriggersBn = "বিখ্যাত 'ক্রিপ্ট মেল্ট' (Crypt Melt): পানির প্যারামিটার (যেমন হঠাৎ ১০০% পানি বদল), আলো বা পরিবেশ বদলালে ৪৮ ঘণ্টার মধ্যে সব পাতা গলে পচে যেতে পারে। কিন্তু শিকড় অক্ষত থাকে এবং ২-৩ সপ্তাহে নতুন কচি পাতা বের হয়।",
                dormancyRestRequired = false,
                dormancyCareNotesBn = "মেল্ট হলেও মাটি থেকে শিকড় তুলবেন না; শান্ত রাখলে পুনরায় জেগে ওঠে।"
            ),
            livestockCompatibilityBn = "গাছের পাতা শক্ত হওয়ায় নিরামিষাশী মাছ বা শামুকের হাত থেকে অক্ষত থাকে।"
        ),

        // 4. Micranthemum tweediei 'Monte Carlo'
        AquaticPlant(
            id = "micranthemum_monte_carlo",
            scientificName = "Micranthemum tweediei 'Monte Carlo'",
            authority = "Benth. / Trade Cultivar",
            family = "Linderniaceae (লিন্ডারনিয়াসি)",
            commonNameBn = "মন্টে কার্লো (দক্ষিণ আমেরিকান কার্পেট)",
            tradeSynonyms = listOf("Bacopa 'Monte Carlo'", "New Large Pearl Grass"),
            obsoleteNames = listOf("Elatine hydropiper (ভুল ট্রেড লেবেল)"),
            etymologyBn = "আর্জেন্টিনার মিসিওনেস প্রদেশের 'মন্টে কার্লো' শহর থেকে প্রথম সংগ্রহ ও বাণিজ্যিকীকরণ করা হয় বলে এই নামকরণ।",
            cultivars = listOf(
                CultivarVariant(
                    name = "Micranthemum tweediei 'Monte Carlo'",
                    tradeNameBn = "স্ট্যান্ডার্ড মন্টে কার্লো",
                    distinguishingFeatureBn = "গোল ক্ষুদ্র চকচকে পাতা, ঘন সবুজ গালিচা তৈরি করে। HC Cuba এর চেয়ে অনেক বেশি সহনশীল ও দ্রুত বর্ধনশীল।",
                    colorToneHex = 0xFF43A047,
                    nitrateSensitivityBn = "পর্যাপ্ত নাইট্রোজেনে ঘন পুরু ম্যাট তৈরি করে"
                )
            ),
            biotope = BiotopeOrigin(
                regionBn = "দক্ষিণ আমেরিকা (উত্তর আর্জেন্টিনা, প্যারাগুয়ে)",
                habitatDescriptionBn = "নদীর স্যাঁতসেঁতে তীর ও অগভীর প্লাবনভূমি যেখানে দ্রুত বর্ধনশীল স্টোলন মাটির সাথে সমান্তরালে ছড়িয়ে পড়ে।",
                flowTypeBn = "মৃদু থেকে মাঝারি জলধারা",
                substrateInWildBn = "বালুকা মিশ্রিত পলিমাটি",
                ecologicalStatusBn = "স্থানীয়ভাবে নিরাপদ",
                invasivePotentialBn = "নগণ্য"
            ),
            morphology = MorphologyHabit(
                category = PlantCategory.CARPET,
                maxHeightCm = "১–৩ সেমি",
                leafSpanCm = "০.৩–০.৫ সেমি",
                stemThicknessMm = "০.৫ মিমি সরু রানার",
                rootStructureBn = "অসংখ্য সূক্ষ্ম শিকড় যা সয়েলের দানাকে শক্তভাবে আটকে ধরে রাখে।"
            ),
            dimorphism = DimorphismSpectrum(
                emersedDescriptionBn = "এমর্সড অবস্থায় পাতা কিছুটা স্থূল ও গাঢ় সবুজ থাকে, টিস্যু কালচার কাপে এভাবেই সরবরাহ করা হয়।",
                submersedDescriptionBn = "জলের নিচে মানিয়ে নেওয়ার পর পাতাগুলো হালকা পাতলা ও উজ্জ্বল কাঁচা আপেল সবুজ রঙ ধারণ করে এবং মাটির উপর সমান্তরালে লতানো বৃদ্ধি পায়।",
                emersedLeafShapeBn = "গোলাকার মাংসল পাতা",
                submersedLeafShapeBn = "বৃত্তাকার ক্ষুদ্র সূক্ষ্ম পাতা",
                flowerInflorescenceBn = "এমর্সড অবস্থায় পাতার গোড়ায় অতি ক্ষুদ্র সাদাটে ফুল ফোটে।",
                wrgbSpectrumReactionBn = "উচ্চ তীব্রতার সবুজ ও সাদা আলোতে উদ্ভিদের ফটোসিন্থেটিক পার্লিং (Pearling) বুদবুদ সৃষ্টি হয়।",
                nitrateLimitationShiftBn = "নাইট্রেট ঘাটতি হলে কার্পেট ফ্যাকাশে হলুদ হয়ে বৃদ্ধি স্তব্ধ হয়ে যায়।",
                lowLightColorHex = 0xFF66BB6A,
                highLightColorHex = 0xFF43A047,
                emersedColorHex = 0xFF2E7D32
            ),
            cultivation = CultivationMatrix(
                parRangeMicroMol = "৪০–৮০ µmol/m²/s",
                parLevelBn = "মাঝারি থেকে উচ্চ",
                co2DemandPpm = "১৫–২৫ ppm (CO2 ছাড়া গালিচা তৈরি হতে বেশি সময় লাগে)",
                lowTechViable = true,
                lowTechViabilityNotesBn = "পর্যাপ্ত আলো ও পুষ্টিকর সয়েল থাকলে নন-CO2 ট্যাঙ্কেও ধৈর্য সহকারে কার্পেট তৈরি করা সম্ভব।",
                tempMinC = 18,
                tempMaxC = 27,
                tempOptimalC = "২১°–২৫° সে.",
                summerMeltWarningBn = "২৮° সে. এর উপরে কার্পেটের নিচের স্তর পচে ভেসে উঠতে পারে।",
                phRange = "৫.৫ – ৭.২",
                khRange = "০ – ৭ dKH",
                softWaterObligate = false,
                ghRange = "২ – ১০ dGH",
                caMgRatioNotesBn = "ক্যালসিয়ামের সুষম মাত্রা রানার বৃদ্ধিতে সাহায্য করে।",
                primaryUptake = NutrientUptake.BALANCED_UPTAKE,
                substratePreferenceBn = "সূক্ষ্ম দানার অ্যাকোয়াসয়েল (Powder Type) শিকড় নোঙ্গরের জন্য সর্বোত্তম।",
                ironPotassiumDemandBn = "আয়রন ও মাইক্রোনিউট্রিয়েন্ট প্রয়োগে সতেজ সবুজ বর্ণ অক্ষুণ্ণ থাকে।"
            ),
            aquascape = AquascapeApplication(
                zone = ScapeZone.FOREGROUND,
                dutchStyleSuitabilityBn = "ডাচ স্টাইলের সামনের অংশে পরিষ্কার সবুজ কার্পেট বর্ডার তৈরিতে সহায়ক।",
                dutchStreetsViability = false,
                natureIwagumiSuitabilityBn = "ইওয়াগুমি (Iwagumi) লেআউটে সেকিরিওকু পাথরের চারপাশের অবিচ্ছেদ্য কার্পেট উদ্ভিদ।",
                leafTexture = LeafTexture.ROUND_TINY,
                growthRate = GrowthRate.FAST,
                shadowingRiskBn = "কম; তবে কার্পেট অতিরিক্ত পুরু (২ ইঞ্চির বেশি) হলে নিচের স্তর আলো না পেয়ে উপড়ে ভেসে উঠতে পারে।"
            ),
            care = PruningAndLifecycle(
                pruningMethod = PruningMethod.RUNNER_SEPARATION,
                pruningInstructionsBn = "লনমওয়ারের মতো বাঁকানো স্প্রিং কাঁচি দিয়ে ওপর থেকে ছেঁটে ১ সেমি উচ্চতায় বজায় রাখতে হয়, যাতে নিচের স্তরে আলো পৌঁছায়।",
                propagationMethodsBn = listOf("স্টোলন রানার কাটিং", "টিস্যু কালচার ক্লাস্টার বিভাজন"),
                meltingTriggersBn = "পুরু ম্যাটের নিচের স্তরে পানি ও আলোর সঞ্চালন বন্ধ হয়ে অ্যানেরোবিক পচন।",
                dormancyRestRequired = false,
                dormancyCareNotesBn = "নিয়মিত ট্রিম করলে বছরজুড়ে সুস্থ থাকে।"
            ),
            livestockCompatibilityBn = "মাটি খোঁড়ে এমন বটম ফিডার (যেমন বড় কোরিডোরাস বা সিচলিড) নতুন রোপিত কার্পেট উপড়ে ফেলতে পারে। শ্রিম্পের জন্য আদর্শ।"
        ),

        // 5. Ludwigia inclinata var. verticillata 'Meta'
        AquaticPlant(
            id = "ludwigia_inclinata_meta",
            scientificName = "Ludwigia inclinata var. verticillata 'Meta'",
            authority = "(Kunth) P.H. Raven",
            family = "Onagraceae (অনগ্রাসি)",
            commonNameBn = "লুডউইগিয়া ইনক্লিনাটা 'মেটা' (সূক্ষ্ম রক্তিম মুকুট)",
            tradeSynonyms = listOf("Ludwigia 'Meta'", "Ludwigia inclinata 'Pantanal' (ঘনিষ্ঠ প্রজাতি)"),
            obsoleteNames = listOf("Jussiaea inclinata"),
            etymologyBn = "জার্মান উদ্ভিদবিজ্ঞানী ক্রিশ্চিয়ান গটলিব লুডভিগের নামানুসারে 'Ludwigia' এবং কলম্বিয়ার রিও মেটা নদী থেকে সংগৃহীত বলে 'Meta' নাম।",
            cultivars = listOf(
                CultivarVariant(
                    name = "Ludwigia inclinata 'Meta'",
                    tradeNameBn = "লুডউইগিয়া মেটা",
                    distinguishingFeatureBn = "ঘূর্ণায়মান চক্রাকারে সাজানো অসংখ্য সূক্ষ্ম সুতোর মতো রক্তলাল পাতা। শীর্ষ মুকুট দেখলে মনে হয় উজ্জ্বল লাল ফুল ফুটে আছে।",
                    colorToneHex = 0xFFE91E63,
                    nitrateSensitivityBn = "নরম পানি ও পূর্ণ পুষ্টিতে নিখুঁত লাল"
                )
            ),
            biotope = BiotopeOrigin(
                regionBn = "দক্ষিণ আমেরিকা (কলম্বিয়ার ওরিওনোকো অববাহিকার রিও মেটা নদী)",
                habitatDescriptionBn = "চরম নরম ও অম্লীয় পানির নদী যেখানে খনিজ লবণ প্রায় শূন্য এবং স্ফটিক স্বচ্ছ জলের নিচে তীব্র রৌদ্র কিরণ প্রবেশ করে।",
                flowTypeBn = "মাঝারি থেকে দ্রুত জলপ্রবাহ",
                substrateInWildBn = "সিলিকা বালু ও আমাজোনিয়ান পলি",
                ecologicalStatusBn = "প্রকৃতিতে সীমিত পরিসরে সুরক্ষিত",
                invasivePotentialBn = "শূন্য (পরিবেশ সংবেদনশীল)"
            ),
            morphology = MorphologyHabit(
                category = PlantCategory.STEM,
                maxHeightCm = "২০–৪০ সেমি",
                leafSpanCm = "৪–৭ সেমি শীর্ষ রোসেট",
                stemThicknessMm = "২.০–৩.০ মিমি নমনীয় কাণ্ড",
                rootStructureBn = "সূক্ষ্ম শিকড় ও পর্ব থেকে সীমিত ওয়াটার রুট।"
            ),
            dimorphism = DimorphismSpectrum(
                emersedDescriptionBn = "এমর্সড রূপ চেনা প্রায় অসম্ভব! বাইরে পাতাগুলো স্থূল, চওড়া, ডিম্বাকৃতি এবং সম্পূর্ণ সবুজ। হলুদ রঙের চার পাপড়ির ফুল ফোটে।",
                submersedDescriptionBn = "জলের নিচে অবিশ্বাস্য রূপান্তর ঘটে—পাতাগুলো সূক্ষ্ম সুচের মতো শত শত চক্রাকারে সাজানো রক্তলাল ও ম্যাজেন্টা রঙের পুষ্পমুকুটে পরিণত হয়।",
                emersedLeafShapeBn = "ডিম্বাকৃতি মসৃণ সবুজ পাতা",
                submersedLeafShapeBn = "চক্রাকার সূঁচালো সূক্ষ্ম পাতা (Verticillate whorls)",
                flowerInflorescenceBn = "জলের উপরে বড় উজ্জ্বল হলুদ চার পাপড়ির ফুল ফোটে।",
                wrgbSpectrumReactionBn = "উচ্চ PAR (১০০+ µmol) ও 660nm ডিপ রেড আলোতে কাণ্ড ও পাতার শিরায় তীব্র রুবি লাল রঞ্জক তৈরি হয়।",
                nitrateLimitationShiftBn = "নাইট্রেট নিয়ন্ত্রিত এবং উচ্চ আয়রন সরবরাহ করলে মুকুটের মধ্যভাগ গাঢ় বেগুনি-ম্যাজেন্টা রঙে জ্বলে ওঠে।",
                lowLightColorHex = 0xFFFF7043,
                highLightColorHex = 0xFFC2185B,
                emersedColorHex = 0xFF388E3C
            ),
            cultivation = CultivationMatrix(
                parRangeMicroMol = "৮০–১৫০ µmol/m²/s",
                parLevelBn = "চরম উচ্চ (হাই-টেক অপরিহার্য)",
                co2DemandPpm = "২৫–৩৫ ppm (স্থির ও উচ্চ CO2 মাত্রা বাধ্যতামূলক)",
                lowTechViable = false,
                lowTechViabilityNotesBn = "লো-টেক সিস্টেমে এটি টিকবে না; কয়েকদিনের মধ্যে ডগা কুঁকড়ে পচে যাবে।",
                tempMinC = 22,
                tempMaxC = 28,
                tempOptimalC = "২৩°–২৬° সে.",
                summerMeltWarningBn = "উচ্চ তাপমাত্রায় দ্রবীভূত অক্সিজেনের অভাবে কাণ্ড দ্রুত পচে যায়।",
                phRange = "৪.৫ – ৬.৪",
                khRange = "০ – ২ dKH (কঠোর নরম পানির বাধ্যবাধকতা - Soft Water Obligate)",
                softWaterObligate = true,
                ghRange = "২ – ৫ dGH",
                caMgRatioNotesBn = "ক্যালসিয়াম ও ম্যাগনেসিয়ামের অনুপাত ভারসাম্যহীন হলে কচি ডগা কুঁকড়ে বন্ধ হয়ে যায়।",
                primaryUptake = NutrientUptake.BALANCED_UPTAKE,
                substratePreferenceBn = "সক্রিয় বাফারিং অ্যাকোয়াসয়েল (যা pH ও KH কম রাখে) একান্ত প্রয়োজন।",
                ironPotassiumDemandBn = "আয়রন (Fe DTPA/EDDHA) ও মাইক্রোনিউট্রিয়েন্টের তীব্র ক্ষুধা।"
            ),
            aquascape = AquascapeApplication(
                zone = ScapeZone.MIDGROUND,
                dutchStyleSuitabilityBn = "ডাচ অ্যাকোয়ারিয়ামের কেন্দ্রবিন্দুতে শ্বাসরুদ্ধকর একক ফোকাল পয়েন্ট তৈরির জন্য আদর্শ।",
                dutchStreetsViability = true,
                natureIwagumiSuitabilityBn = "নেচার স্কেপে গাঢ় সবুজ পটভূমির সামনে একক বৈপরীত্য সৃষ্টি করে।",
                leafTexture = LeafTexture.FINE_FEATHERY,
                growthRate = GrowthRate.FAST,
                shadowingRiskBn = "মাঝারি; কাণ্ডের বিস্তার বেশি হওয়ায় নিচের পাতা যেন ঢেকে না যায় সেদিকে লক্ষ্য রাখতে হয়।"
            ),
            care = PruningAndLifecycle(
                pruningMethod = PruningMethod.UPROOT_AND_REPLANT,
                pruningInstructionsBn = "অন্যান্য স্টেমের মতো কেবল টপিং করলে নিচের পুরনো কাণ্ড পচে নষ্ট হয়ে যায়। সেরা পদ্ধতি হলো কাণ্ডের ওপরের সুন্দর শীর্ষ কেটে নিচের গোড়া উপড়ে ফেলে সেই স্থানে নতুন শীর্ষ রোপণ করা।",
                propagationMethodsBn = listOf("সুস্থ শীর্ষ কাটিং (Top cutting replanting)"),
                meltingTriggersBn = "KH ৩ এর উপরে উঠলে বা CO2 ওঠানামা করলে ডগা তৎক্ষণাৎ কুঁকড়ে গিয়ে মেল্ট হয়।",
                dormancyRestRequired = false,
                dormancyCareNotesBn = "স্থিতিশীল ওয়াটার প্যারামিটার নিশ্চিত রাখা।"
            ),
            livestockCompatibilityBn = "অত্যন্ত মৃদু পানির কারিডিনা শ্রিম্প ও ব্ল্যাকওয়াটার টেট্রার সাথে নিখুঁতভাবে মানানসই।"
        ),

        // 6. Anubias barteri var. nana 'Petite'
        AquaticPlant(
            id = "anubias_nana_petite",
            scientificName = "Anubias barteri var. nana 'Petite'",
            authority = "Schott / Oriental Aquarium Cultivar",
            family = "Araceae (অ্যারাসি)",
            commonNameBn = "অনুবিয়াস নানা পেটিট (ক্ষুদ্রাকার আফ্রিকান এপিফাইট)",
            tradeSynonyms = listOf("Anubias 'Bonsai'", "Miniature Anubias"),
            obsoleteNames = listOf("Anubias nana var. compacta"),
            etymologyBn = "মিশরীয় মৃত্যু ও পাতাল দেবতা 'আনুবিস' (Anubis) এর নাম থেকে উদ্ভূত, যা এর অন্ধকার ছায়াযুক্ত স্থানে বেঁচে থাকার ক্ষমতা নির্দেশ করে। 'Petite' ফরাসি শব্দ অর্থ অতি ক্ষুদ্র।",
            cultivars = listOf(
                CultivarVariant(
                    name = "Anubias barteri var. nana 'Petite'",
                    tradeNameBn = "নানা পেটিট",
                    distinguishingFeatureBn = "নিয়মিত অনুবিয়াস নানার এক-তৃতীয়াংশ আকৃতির পাতা। অত্যন্ত টেকসই ও চিরসবুজ।",
                    colorToneHex = 0xFF2E7D32,
                    nitrateSensitivityBn = "যেকোনো পুষ্টি মাত্রায় টিকে থাকে"
                )
            ),
            biotope = BiotopeOrigin(
                regionBn = "পশ্চিম আফ্রিকা (ক্যামেরুন, নাইজেরিয়া, গ্যাবন)",
                habitatDescriptionBn = "ঘন অতিবৃষ্টি অরণ্যের ছায়াময় দ্রুতগামী জলপ্রপাত ও পাথুরে জলধারার প্রান্তদেশ যেখানে গাছের বাকলে শিকড় গেঁথে থাকে।",
                flowTypeBn = "মাঝারি থেকে তীব্র খরস্রোত",
                substrateInWildBn = "পাথর, গ্রানাইট শিলা ও জলমগ্ন গাছের ডালপালা",
                ecologicalStatusBn = "প্রকৃতিতে সুরক্ষিত",
                invasivePotentialBn = "শূন্য"
            ),
            morphology = MorphologyHabit(
                category = PlantCategory.RHIZOME_EPIPHYTE,
                maxHeightCm = "৩–৫ সেমি",
                leafSpanCm = "১–২ সেমি",
                stemThicknessMm = "১.৫–২.০ মিমি শক্ত রাইজোম",
                rootStructureBn = "মোটা, স্থিতিস্থাপক নোঙ্গর শিকড় যা যেকোনো উপরিভাগে সেঁটে থাকে।"
            ),
            dimorphism = DimorphismSpectrum(
                emersedDescriptionBn = "এমর্সড ও নিমজ্জিত উভয় অবস্থায় পাতা প্রায় একই রকম থাকে। আর্দ্রতায় রাখলে ওপরে নিয়মিত সাদা ফুল ফোটে।",
                submersedDescriptionBn = "জলের তলদেশেও পাতার টেক্সচার অপরিবর্তিত থাকে; চকচকে চামড়ার মতো গাঢ় সবুজ পাতা কয়েক বছর বেঁচে থাকে।",
                emersedLeafShapeBn = "ছোট উপবৃত্তাকার চামড়ার মতো পাতা",
                submersedLeafShapeBn = "ক্ষুদ্র উপবৃত্তাকার পুরু গাঢ় সবুজ পাতা",
                flowerInflorescenceBn = "জলের তলদেশেও চমৎকার ক্ষুদ্র সাদা স্প্যাথ ও স্প্যাডিক্স মঞ্জরি প্রস্ফুটিত হয়।",
                wrgbSpectrumReactionBn = "কম আলোতে বেশি স্বাস্থ্যকর থাকে। অতিরিক্ত উচ্চ আলো দিলে পাতায় গ্রিন স্পট শৈবাল (GSA) আক্রমণ করে।",
                nitrateLimitationShiftBn = "পুষ্টি কমলেও পাতার রঙের কোনো পরিবর্তন হয় না; শুধু বৃদ্ধি আরও শ্লথ হয়।",
                lowLightColorHex = 0xFF1B5E20,
                highLightColorHex = 0xFF2E7D32,
                emersedColorHex = 0xFF1B5E20
            ),
            cultivation = CultivationMatrix(
                parRangeMicroMol = "১০–৪০ µmol/m²/s",
                parLevelBn = "খুবই কম থেকে ছায়াময়",
                co2DemandPpm = "০–১০ ppm (CO2 ছাড়াই চিরকাল বেঁচে থাকে)",
                lowTechViable = true,
                lowTechViabilityNotesBn = "বিশ্বের সবচেয়ে সহজ ও অবিনাশী লো-টেক অ্যাকোয়ারিয়াম উদ্ভিদের একটি।",
                tempMinC = 20,
                tempMaxC = 30,
                tempOptimalC = "২২°–২৬° সে.",
                summerMeltWarningBn = "অত্যন্ত সহনশীল; তবে রাইজোম পচন রোগ (Anubias Rot) হলে সমস্ত পাতা খসে পড়ে।",
                phRange = "৬.০ – ৮.০",
                khRange = "১ – ১৪ dKH (কঠিন পানিতেও সম্পূর্ণ অটুট)",
                softWaterObligate = false,
                ghRange = "২ – ২০ dGH",
                caMgRatioNotesBn = "যেকোনো সাধারণ ট্যাপ ওয়াটারে বেঁচে থাকে।",
                primaryUptake = NutrientUptake.WATER_COLUMN_FEEDER,
                substratePreferenceBn = "কখনোই মাটিতে পুঁতবেন না। ড্রিফটউড বা পাথরের গায়ে সুপারগ্লু বা সুতা দিয়ে আটকাতে হয়।",
                ironPotassiumDemandBn = "মাঝেমধ্যে সামান্য পটাসিয়াম দিলে পাতায় কোনো হলুদ ভাব আসে না।"
            ),
            aquascape = AquascapeApplication(
                zone = ScapeZone.HARDSCAPE_EPIPHYTE,
                dutchStyleSuitabilityBn = "ডাচ স্টাইলের হার্ডস্কেপ ট্রানজিশন বর্ডারে ছায়া কোণে চমৎকার।",
                dutchStreetsViability = false,
                natureIwagumiSuitabilityBn = "ন্যানো একোয়ারিয়ামে স্কেলিং ও অনুপাত নিখুঁত রাখার জন্য বিশ্বজুড়ে প্রথম পছন্দ।",
                leafTexture = LeafTexture.BROAD_OVAL,
                growthRate = GrowthRate.SLOW,
                shadowingRiskBn = "শূন্য; এটি অন্য সব উদ্ভিদের নিচে থাকতে পছন্দ করে।"
            ),
            care = PruningAndLifecycle(
                pruningMethod = PruningMethod.RHIZOME_DIVISION,
                pruningInstructionsBn = "রাইজোমের যে অংশে অন্তত ৩-৫টি পরিপক্ক পাতা আছে তা ধারালো ব্লেড দিয়ে সাবধানে কেটে নতুন জায়গায় স্থানান্তর করুন।",
                propagationMethodsBn = listOf("রাইজোম বিভাজন"),
                meltingTriggersBn = "রাইজোম মাটির নিচে চাপা পড়লে বাতাসহীন হয়ে পচে যাওয়া।",
                dormancyRestRequired = false,
                dormancyCareNotesBn = "কোনো বিশেষ বিশ্রামের প্রয়োজন নেই।"
            ),
            livestockCompatibilityBn = "পাতা অতিশয় পুরু ও তিক্ত হওয়ায় গোল্ডফিশ, সিচলিড বা বড় নিরামিষাশী মাছের কামড়েও সম্পূর্ণ অক্ষত থাকে।"
        ),

        // 7. Aponogeton madagascariensis
        AquaticPlant(
            id = "aponogeton_madagascariensis",
            scientificName = "Aponogeton madagascariensis",
            authority = "(Mirb.) H. Bruggen",
            family = "Aponogetonaceae (অ্যাপোনোগেটোনেসি)",
            commonNameBn = "মাদাগাস্কার লেইস প্ল্যান্ট (জালিকাকার বাল্ব উদ্ভিদ)",
            tradeSynonyms = listOf("Madagascar Lace Plant", "Aponogeton fenestralis"),
            obsoleteNames = listOf("Ouvirandra fenestralis"),
            etymologyBn = "ল্যাটিন 'fenestralis' অর্থ জানালা বা জালি, কারণ এর পাতার শিরাগুলোর মধ্যবর্তী কোনো সবুজ মাংসল টিস্যু থাকে না—পাতা দেখতে সম্পূর্ণ জালের মতো।",
            cultivars = listOf(
                CultivarVariant(
                    name = "Aponogeton madagascariensis (Wide Mesh)",
                    tradeNameBn = "প্রশস্ত জালি ভ্যারাইটি",
                    distinguishingFeatureBn = "পাতার জালির ফাঁকগুলো বড় ও সুবিন্যস্ত।",
                    colorToneHex = 0xFF33691E,
                    nitrateSensitivityBn = "নরম ও শীতল পানিতে সেরা রূপ"
                )
            ),
            biotope = BiotopeOrigin(
                regionBn = "মাদাগাস্কার দ্বীপ",
                habitatDescriptionBn = "পাহাড়ের শীতল, খরস্রোতা এবং ছায়াঘন ঝরনাধারা যেখানে পানি সব সময় প্রবাহমান ও অত্যন্ত পরিষ্কার থাকে।",
                flowTypeBn = "অবিরাম শীতল ও দ্রুত জলপ্রবাহ",
                substrateInWildBn = "পাথুরে বালু ও বেসাল্ট শিলার তলদেশ",
                ecologicalStatusBn = "প্রকৃতিতে সংকটাপন্ন (বুলবুল শিকার ও আবাসস্থল ধ্বংস)",
                invasivePotentialBn = "শূন্য"
            ),
            morphology = MorphologyHabit(
                category = PlantCategory.BULB_TUBER,
                maxHeightCm = "৩০–৫৫ সেমি",
                leafSpanCm = "৬–১০ সেমি",
                stemThicknessMm = "বাল্ব/টিউবার ২-৩ সেমি ব্যাসের",
                rootStructureBn = "বাল্বের গোড়া থেকে মাংসল সাদা শিকড়ের বিস্তার।"
            ),
            dimorphism = DimorphismSpectrum(
                emersedDescriptionBn = "এমর্সড হয় না; সম্পূর্ণ নিমজ্জিত অবস্থায় থাকে। তবে পানির উপরিভাগে সাদা বা নীলচে দুই শাখাবিশিষ্ট ফুল ফোটে।",
                submersedDescriptionBn = "বিশ্বের সবচেয়ে অনন্য জলজ উদ্ভিদ—পাতার কোনো ইন্টারভেইনাল টিস্যু থাকে না, কেবল পাতার শিরাগুলো জালের মতো বিন্যস্ত থাকে।",
                emersedLeafShapeBn = "অপ্রযোজ্য (ফুল ছাড়া বাইরে আসে না)",
                submersedLeafShapeBn = "জালিকাকার ড্রিলযুক্ত ফিতার মতো পাতা (Fenestrated Lace)",
                flowerInflorescenceBn = "পানির ওপরে দ্বিখণ্ডিত কাঁটার মতো অপূর্ব সাদা-গোলাপী পুষ্পদণ্ড উত্থিত হয়।",
                wrgbSpectrumReactionBn = "মাঝারি আলো ও ভালো জলপ্রবাহে পাতার জালির কাঠামো মজবুত থাকে।",
                nitrateLimitationShiftBn = "পুষ্টি হ্রাস পেলে পাতা ভঙ্গুর হয়ে ছিঁড়ে যেতে পারে।",
                lowLightColorHex = 0xFF558B2F,
                highLightColorHex = 0xFF33691E,
                emersedColorHex = 0xFF33691E
            ),
            cultivation = CultivationMatrix(
                parRangeMicroMol = "৪০–৭০ µmol/m²/s",
                parLevelBn = "মাঝারি",
                co2DemandPpm = "১৫–২৫ ppm",
                lowTechViable = false,
                lowTechViabilityNotesBn = "পানির তাপমাত্রা ও পরিচ্ছন্নতার কঠোর চাহিদার কারণে হাই-টেক ফিল্ট্রেশন প্রয়োজন।",
                tempMinC = 16,
                tempMaxC = 24,
                tempOptimalC = "১৮°–২২° সে. (শীতল পানি অত্যন্ত জরুরি)",
                summerMeltWarningBn = "চরম গ্রীষ্মকালীন গলে যাওয়া (Summer Melt): ২৫° সে. অতিক্রম করলেই পাতা খসে পড়ে এবং গাছ মরণাপন্ন হয়।",
                phRange = "৫.৫ – ৬.৮",
                khRange = "০ – ৩ dKH (নরম পানির বিশেষজ্ঞ)",
                softWaterObligate = true,
                ghRange = "২ – ৬ dGH",
                caMgRatioNotesBn = "ক্যালসিয়ামের অভাব হলে জালিকাকার ফ্রেম ভঙ্গুর হয়।",
                primaryUptake = NutrientUptake.HEAVY_ROOT_FEEDER,
                substratePreferenceBn = "বাল্ব আংশিক মাটির ওপরে রেখে শিকড়গুলো পুষ্টিকর সয়েলে রাখতে হয়।",
                ironPotassiumDemandBn = "রুট ট্যাবের মাধ্যমে আয়রন ও ট্রেস সরবরাহ আবশ্যক।"
            ),
            aquascape = AquascapeApplication(
                zone = ScapeZone.BACKGROUND,
                dutchStyleSuitabilityBn = "একক প্রদর্শনীর রাজকীয় উদ্ভিদ (Solitary Specimen Plant)।",
                dutchStreetsViability = false,
                natureIwagumiSuitabilityBn = "লার্জ নেচার অ্যাকোয়ারিয়ামে নাটকীয় দৃষ্টি আকর্ষণকারী উপাদান।",
                leafTexture = LeafTexture.FINE_FEATHERY,
                growthRate = GrowthRate.MODERATE,
                shadowingRiskBn = "মাঝারি; পাতার জালি দিয়ে কিছুটা আলো গলে নিচে প্রবেশ করতে পারে।"
            ),
            care = PruningAndLifecycle(
                pruningMethod = PruningMethod.OUTER_LEAF_REMOVAL,
                pruningInstructionsBn = "ক্ষতিগ্রস্ত বা শ্যাওলা আক্রান্ত পুরানো জালি পাতাগুলো গোড়া থেকে কেটে দিন।",
                propagationMethodsBn = listOf("পরিপক্ক বাল্ব বিভাজন", "বীজ থেকে চারা উৎপাদন"),
                meltingTriggersBn = "উষ্ণ পানি (২৫°+) এবং জালির ফাঁকে শৈবালের বিস্তার।",
                dormancyRestRequired = true,
                dormancyCareNotesBn = "বাধ্যতামূলক সুপ্তাবস্থা (Mandatory Dormancy): প্রতি ৮-১২ মাস পর পর গাছটির সব পাতা খসে গিয়ে বাল্বটি বিশ্রামে যায়। তখন বাল্বটিকে তুলে সামান্য আর্দ্র বালু বা শীতল পানিতে (১৬° সে.) ২-৩ মাস বিশ্রাম দিয়ে পুনরায় রোপণ করলে নতুন সতেজ পাতা গজায়।"
            ),
            livestockCompatibilityBn = "জালির ফাঁকে যেন শৈবাল না জমে সেজন্য ছোট শ্রিম্প ও ওটোসিনক্লাস অত্যন্ত উপকারী সঙ্গী।"
        )
    )

    // তুলনামূলক লুক-অ্যালাইক গাইড
    val lookAlikes: List<LookAlikeComparison> = listOf(
        LookAlikeComparison(
            id = "la_rotala_variants",
            titleBn = "রোটালা রোটান্ডিফোলিয়া কাল্টিভারের সূক্ষ্ম পার্থক্য",
            primarySpecies = "Rotala rotundifolia 'Blood Red SG'",
            primarySpeciesBn = "রোটালা ব্লাড রেড (সিঙ্গাপুর)",
            confusedSpecies = "Rotala rotundifolia 'H'Ra'",
            confusedSpeciesBn = "রোটালা এইচ'রা (ভিয়েতনাম)",
            keyDiagnosticDifferenceBn = "ব্লাড রেড উচ্চ নাইট্রেটেও রক্তিম লাল থাকে; এইচ'রা লাল হতে হলে নাইট্রেট < ৫ পিপিএম এ নামাতে হয়।",
            leafComparisonBn = "ব্লাড রেড-এর পাতা কিছুটা চওড়া ও পাতার শিরা পর্যন্ত গাঢ় লাল; এইচ'রা-এর পাতা তুলনামূলক সরু ও পেছনের দিক হালকা গোলাপী-কমলা।",
            growthHabitComparisonBn = "ব্লাড রেড মূলত খাড়া ওপরের দিকে বাড়ে; এইচ'রা আলো পেলে অনুভূমিকভাবে বেঁকে বিস্তৃত ঝোপ তৈরি করে।",
            cultivationDifferenceBn = "এইচ'রা নাইট্রোজেন সীমাবদ্ধতার উপর নির্ভরশীল; ব্লাড রেড স্থিতিশীল লাল রঙ দিতে অধিক নির্ভরযোগ্য।"
        ),
        LookAlikeComparison(
            id = "la_carpet_plants",
            titleBn = "কার্পেট উদ্ভিদের ত্রিমুখী বিভ্রান্তি নিরসন",
            primarySpecies = "Micranthemum 'Monte Carlo'",
            primarySpeciesBn = "মন্টে কার্লো",
            confusedSpecies = "Hemianthus callitrichoides 'Cuba'",
            confusedSpeciesBn = "এইচসি কিউবা (Dwarf Baby Tears)",
            keyDiagnosticDifferenceBn = "মন্টে কার্লোর পাতা কিউবার চেয়ে দ্বিগুণ বড় (৪ মিমি বনাম ১-২ মিমি) এবং সহনশীলতা অনেক গুণ বেশি।",
            leafComparisonBn = "মন্টে কার্লো: হালকা উজ্জ্বল সবুজ, মসৃণ বৃত্তাকার পাতা; কিউবা: অতি ক্ষুদ্র পিনের মাথার মতো জোড়া পাতা।",
            growthHabitComparisonBn = "মন্টে কার্লো শক্ত রানার তৈরি করে যা সহজেই সয়েলে নোঙ্গর করে; কিউবার অতি সূক্ষ্ম শিকড় সামান্য ঢেউয়ে উপড়ে যায়।",
            cultivationDifferenceBn = "কিউবার জন্য উচ্চ আলো, চরম CO2 এবং কোমল পানি বাধ্যতামূলক; মন্টে কার্লো সাধারণ লো-টেক পরিসরেও সফল হয়।"
        ),
        LookAlikeComparison(
            id = "la_epiphyte_giants",
            titleBn = "অনুবিয়াস নানা পেটিট বনাম বুসেফাল্যান্ড্রা কেডাগাং",
            primarySpecies = "Bucephalandra 'Kedagang'",
            primarySpeciesBn = "বুসেফাল্যান্ড্রা কেডাগাং",
            confusedSpecies = "Anubias barteri var. nana 'Petite'",
            confusedSpeciesBn = "অনুবিয়াস নানা পেটিট",
            keyDiagnosticDifferenceBn = "বুসের পাতার উপরিভাগে ধাতব নীল আভা ও রূপালী বিন্দু (Stomata) থাকে; অনুবিয়াসের পাতা চকচকে সমতল সবুজ।",
            leafComparisonBn = "বুসে: পাতার কিনারা ঢেউখেলানো খাঁজকাটা ও তামাটে-নীল; অনুবিয়াস: মসৃণ উপবৃত্তাকার চিরসবুজ।",
            growthHabitComparisonBn = "উভয়েই রাইজোম এপিফাইট; তবে বুসের বৃদ্ধির গতি অনুবিয়াসের চেয়েও প্রায় অর্ধেক ধীর।",
            cultivationDifferenceBn = "অনুবিয়াস শক্ত পানিতেও বেঁচে থাকে; বুসে কোমল অম্লীয় পানি ও ভালো জলপ্রবাহ দাবি করে।"
        )
    )

    // পুষ্টি ঘাটতি প্যাথোলজি ডেটা
    val deficiencies: List<DeficiencyPathology> = listOf(
        DeficiencyPathology(
            id = "def_nitrogen",
            nutrientNameBn = "নাইট্রোজেন ঘাটতি (Nitrogen Deficiency)",
            chemicalSymbol = "N (NO₃⁻)",
            mobility = NutrientMobility.MOBILE_OLD_LEAVES,
            visualSymptomsBn = "উদ্ভিদ নিজের বেঁচে থাকার স্বার্থে পুরাতন পাতা থেকে নাইট্রোজেন সরিয়ে নতুন কচি পাতায় পাঠিয়ে দেয়। ফলে কাণ্ডের নিচের দিকের পুরাতন পাতাগুলো সম্পূর্ণ ফ্যাকাশে হলুদ হয়ে যায় এবং ঝরে পড়ে। উদ্ভিদের সামগ্রিক বৃদ্ধি চরমভাবে শ্লথ হয়।",
            commonMisconceptionBn = "অনেকে একে আয়রনের ঘাটতি ভেবে ভুল করেন, তবে আয়রনের ঘাটতি দেখা দেয় কচি নতুন পাতায়, পুরানো পাতায় নয়।",
            correctiveActionBn = "পানির নাইট্রেট (NO₃) মাত্রা ৫–১৫ ppm এ উন্নীত করুন (যেমন পটাশিয়াম নাইট্রেট KNO₃ ডজিং)।",
            mostSensitivePlantsBn = "দ্রুত বর্ধনশীল স্টেম যেমন Hygrophila polysperma, Rotala, Limnophila."
        ),
        DeficiencyPathology(
            id = "def_potassium",
            nutrientNameBn = "পটাশিয়াম ঘাটতি (Potassium Deficiency)",
            chemicalSymbol = "K (K⁺)",
            mobility = NutrientMobility.MOBILE_OLD_LEAVES,
            visualSymptomsBn = "পুরাতন পাতার ওপর ক্ষুদ্র ক্ষুদ্র সূঁচের মাথার মতো ছিদ্র (Pinholes) সৃষ্টি হয়। ছিদ্রগুলোর কিনারা ধীরে ধীরে হলুদ ও বাদামী হয়ে পাতাটি জালের মতো ফুটো ফুটো হয়ে পচে যায়।",
            commonMisconceptionBn = "শামুক বা মাছ পাতা খাচ্ছে মনে করা হয়; কিন্তু মূলত পটাশিয়ামের অভাবেই টিস্যু মরে গিয়ে ছিদ্র হয়।",
            correctiveActionBn = "পটাশিয়াম সালফেট (K₂SO₄) বা পটাশিয়াম ফসফেট প্রয়োগ করে K মাত্রা ১০–২০ ppm এ রাখুন।",
            mostSensitivePlantsBn = "Hygrophila corymbosa, Amazon Swords, Anubias."
        ),
        DeficiencyPathology(
            id = "def_phosphorus",
            nutrientNameBn = "ফসফরাস ঘাটতি (Phosphorus Deficiency)",
            chemicalSymbol = "P (PO₄³⁻)",
            mobility = NutrientMobility.MOBILE_OLD_LEAVES,
            visualSymptomsBn = "পুরাতন পাতার রঙ অস্বাভাবিক গাঢ় সবুজ বা কালচে-বেগুনি হয়ে যায় এবং পাতার ওপর গাঢ় গ্রিন স্পট শৈবাল (GSA) দ্রুত ছড়িয়ে পড়ে। পাতা অকালে ঝরে যায়।",
            commonMisconceptionBn = "গাঢ় সবুজ দেখে সুস্থ ভাবা হতে পারে, কিন্তু ফসফেট শূন্য হলে শৈবাল আক্রমণ ঘটে।",
            correctiveActionBn = "মনোপটাশিয়াম ফসফেট (KH₂PO₄) যোগ করে ফসফেট মাত্রা ০.৫–১.৫ ppm এ বজায় রাখুন।",
            mostSensitivePlantsBn = "Anubias, Ludwigia, Micranthemum."
        ),
        DeficiencyPathology(
            id = "def_iron",
            nutrientNameBn = "আয়রন ঘাটতি (Iron Deficiency)",
            chemicalSymbol = "Fe (Fe²⁺/Fe³⁺)",
            mobility = NutrientMobility.IMMOBILE_NEW_GROWTH,
            visualSymptomsBn = "যেহেতু আয়রন ইম্মোবাইল, তাই এটি পুরানো পাতা থেকে কচি পাতায় যেতে পারে না। নতুন গজানো পাতাগুলো ক্লোরোফিলের অভাবে ফ্যাকাশে হলুদ বা প্রায় কাঁচের মতো সাদাটে হয়ে জন্মায়, যদিও পাতার প্রধান শিরাগুলো হালকা সবুজ থাকতে পারে (Interveinal Chlorosis)।",
            commonMisconceptionBn = "অতিরিক্ত আয়রন দিলে লাল গাছ লাল হবে মনে করা হয়; কিন্তু আয়রন ঘাটতিতে লাল গাছ ফ্যাকাশে হয়ে যায়।",
            correctiveActionBn = "চিলেটেড আয়রন (Fe-DTPA বা Fe-EDDHA) ০.১–০.২ ppm ডজ করুন। উচ্চ pH এ Fe-EDDHA সবচেয়ে কার্যকর।",
            mostSensitivePlantsBn = "Ludwigia inclinata, Alternanthera reineckii, Rotala macrandra."
        ),
        DeficiencyPathology(
            id = "def_calcium",
            nutrientNameBn = "ক্যালসিয়াম ঘাটতি (Calcium Deficiency)",
            chemicalSymbol = "Ca (Ca²⁺)",
            mobility = NutrientMobility.IMMOBILE_NEW_GROWTH,
            visualSymptomsBn = "উদ্ভিদের একেবারে শীর্ষ মুকুল বা কচি পাতাগুলো স্বাভাবিকভাবে মেলতে পারে না। পাতা কুঁকড়ে পেঁচিয়ে যায় (Cupped / Hooked tips) এবং ডগা সরু হয়ে বৃদ্ধি স্তব্ধ হয়ে যায়।",
            commonMisconceptionBn = "অনেক সময় বোরন ঘাটতির সাথে মিশ্রিত হয়। অতি নরম পানিতে (GH < 2) এটি প্রায়শই ঘটে।",
            correctiveActionBn = "ক্যালসিয়াম সালফেট (জিপসাম) বা ক্যালসিয়াম ক্লোরাইড যোগ করে পানির ক্যালসিয়াম ২০–৩০ ppm এবং GH ৩-৫ এ উন্নীত করুন।",
            mostSensitivePlantsBn = "Pogostemon stellatus, Ludwigia inclinata 'Pantanal', Rotala wallichii."
        )
    )

    // শৈবাল সংবেদনশীলতা ও চিকিৎসা
    val algaeTreatments: List<AlgaeVulnerability> = listOf(
        AlgaeVulnerability(
            id = "alg_bba",
            algaeNameBn = "ব্ল্যাক বিয়ার্ড শৈবাল (Black Beard Algae - BBA)",
            scientificGroup = "Rhodophyta (Audouinella / লাল শৈবাল পরিবার)",
            targetPlantHabitsBn = "ধীর বর্ধনশীল এপিফাইটের পাতার কিনারা (Anubias, Bucephalandra), পুরানো ফিল্টার আউটলেট ও হার্ডস্কেপ।",
            rootCausesBn = "পানির কার্বন ডাই অক্সাইডের (CO₂) অনিয়মিত ওঠানামা এবং পানির কলামে অতিরিক্ত দ্রবীভূত জৈব বর্জ্য (DOC)।",
            glutaraldehydeSafeDoseBn = "স্পট ট্রিটমেন্ট: প্রতি ৫০ লিটার পানিতে ১ মিলি গ্লুটারালডিহাইড/লিকুইড কার্বন ইনজেকশন সিরিঞ্জে ভরে ফিল্টার বন্ধ অবস্থায় সরাসরি আক্রান্ত পাতায় স্প্রে করুন। ২০ মিনিট পর ফিল্টার চালু করুন।",
            hydrogenPeroxideSafeDoseBn = "৩% H₂O₂ (হাইড্রোজেন পারঅক্সাইড) প্রতি ৪০ লিটার পানিতে সর্বোচ্চ ৫ মিলি হারে আক্রান্ত স্থানে স্পট প্রয়োগ। ২-৩ দিনে BBA গোলাপী হয়ে মরে যাবে।",
            sensitiveSpeciesWarningBn = "Vallisneria, Riccia এবং কিছু Moss গ্লুটারালডিহাইডের প্রতি চরম সংবেদনশীল এবং গলে যেতে পারে।"
        ),
        AlgaeVulnerability(
            id = "alg_gsa",
            algaeNameBn = "গ্রিন স্পট শৈবাল (Green Spot Algae - GSA)",
            scientificGroup = "Chlorophyta (Choetophora)",
            targetPlantHabitsBn = "অনুবিয়াস ও ক্রিপ্টোকোরিনের পুরানো পাতার পৃষ্ঠদেশ এবং অ্যাকোয়ারিয়ামের কাঁচ।",
            rootCausesBn = "পানির ফসফেট (PO₄) শূন্যে নেমে যাওয়া এবং অতিরিক্ত উচ্চ আলোর নিচে ধীরগতির গাছ দীর্ঘক্ষণ থাকা।",
            glutaraldehydeSafeDoseBn = "গ্লুটারালডিহাইড দিয়ে GSA সম্পূর্ণ দূর করা কঠিন।",
            hydrogenPeroxideSafeDoseBn = "পাতায় স্পট ট্রিটমেন্ট কার্যকর, তবে দীর্ঘস্থায়ী সমাধান নয়।",
            sensitiveSpeciesWarningBn = "ফসফেট মাত্রা ১.৫–২.০ ppm এ উন্নীত করলে এবং গাছের ওপর আলো সামান্য কমালেই নতুন পাতায় GSA আসা বন্ধ হয়।"
        ),
        AlgaeVulnerability(
            id = "alg_staghorn",
            algaeNameBn = "স্ট্যাগহর্ন শৈবাল (Staghorn Algae)",
            scientificGroup = "Compsopogon coeruleus",
            targetPlantHabitsBn = "দ্রুত বর্ধনশীল স্টেম উদ্ভিদের শীর্ষ পাতা এবং ক্যানোপি। দেখতে হরিণের শিংয়ের মতো শাখান্বিত ধূসর-কালো।",
            rootCausesBn = "পানিতে অ্যামোনিয়ার (NH₃/NH₄⁺) স্পাইক, তলদেশের বর্জ্য নাড়াচাড়া করা এবং দুর্বল পানি সঞ্চালন।",
            glutaraldehydeSafeDoseBn = "লিকুইড কার্বনে অত্যন্ত সংবেদনশীল; আক্রান্ত পাতায় সরাসরি স্প্রে করলে পরের দিনই লাল/সাদা হয়ে মারা যায়।",
            hydrogenPeroxideSafeDoseBn = "৩% H₂O₂ স্প্রে অত্যন্ত দ্রুত ফলাফল দেয়।",
            sensitiveSpeciesWarningBn = "সরাসরি মাছ বা শ্রিম্পের মুখের কাছে স্প্রে করবেন না।"
        )
    )

    // ওয়াবি-কুসা ও এমর্সড কালচার গাইড
    val wabiKusaSteps: List<WabiKusaStep> = listOf(
        WabiKusaStep(
            stepNumber = 1,
            titleBn = "উপযুক্ত স্তর ও সয়েল বল তৈরি",
            descriptionBn = "অ্যাকোয়াসয়েল গুঁড়ো করে সামান্য আর্দ্র পিটমস বা কাদামাটি দিয়ে গোলাকার সুদৃঢ় বল তৈরি করুন এবং বাইরে স্ফ্যাগনাম মস দিয়ে সুতা দিয়ে পেঁচিয়ে নিন।",
            humidityRequirementBn = "৯০–১০০% আর্দ্রতা",
            transitionDurationBn = "দিন ১–৩"
        ),
        WabiKusaStep(
            stepNumber = 2,
            titleBn = "টিস্যু কালচার বা নিমজ্জিত স্টেম স্থাপন",
            descriptionBn = "রোটালা, লুডউইগিয়া বা মন্টে কার্লোর শীর্ষ কাটিংগুলো ফোরসেপ দিয়ে সয়েল বলের গায়ে ঘন সন্নিবিষ্টভাবে গেঁথে দিন।",
            humidityRequirementBn = "৯৫% আর্দ্রতা (স্বচ্ছ কাঁচের ঢাকনা আবশ্যক)",
            transitionDurationBn = "দিন ৪–১০"
        ),
        WabiKusaStep(
            stepNumber = 3,
            titleBn = "বায়বীয় অভিযোজন ও আর্দ্রতা হ্রাস",
            descriptionBn = "গাছের মূল শক্ত হওয়ার সাথে সাথে প্রতিদিন ঢাকনা আধা ঘণ্টা করে খুলে ঘরের সাধারণ বাতাসে অভিযোজিত করুন। কচি পাতাগুলো মসৃণ ও জলরোধী মোমের প্রলেপযুক্ত হয়ে গড়ে উঠবে।",
            humidityRequirementBn = "৭০%–৮০% নিয়ন্ত্রিত আর্দ্রতা",
            transitionDurationBn = "দিন ১১–২১"
        ),
        WabiKusaStep(
            stepNumber = 4,
            titleBn = "পূর্ণাঙ্গ টেরারিয়াম ও ফুল ফোটানো",
            descriptionBn = "এমর্সড রূপ সম্পূর্ণ প্রতিষ্ঠিত হলে পর্যাপ্ত স্প্রে ও হালকা আলোতে রাখুন। কয়েক সপ্তাহের মধ্যে সুন্দর সুগন্ধি জলজ ফুলের কুঁড়ি দেখতে পাবেন।",
            humidityRequirementBn = "৫০%–৬৫% স্বাভাবিক রুম আর্দ্রতা",
            transitionDurationBn = "দিন ২২+"
        )
    )
}
