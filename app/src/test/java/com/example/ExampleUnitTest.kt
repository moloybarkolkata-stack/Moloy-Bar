package com.example

import com.example.data.AquaticBotanyRepository
import com.example.viewmodel.AquaticBotanyViewModel
import com.example.viewmodel.Co2Status
import org.junit.Assert.*
import org.junit.Test

class ExampleUnitTest {
    @Test
    fun testPlantRepositoryIntegrity() {
        val plants = AquaticBotanyRepository.plants
        assertTrue("Plant repository must not be empty", plants.isNotEmpty())
        
        // Rotala rotundifolia validation
        val rotala = plants.find { it.id == "rotala_rotundifolia" }
        assertNotNull("Rotala rotundifolia must exist", rotala)
        assertTrue("Rotala must have cultivars", rotala!!.cultivars.isNotEmpty())
        assertEquals("Lythraceae (লাইথ্রেসি)", rotala.family)
    }

    @Test
    fun testCo2Calculation() {
        val vm = AquaticBotanyViewModel()
        // pH 6.6, KH 3.0 -> CO2 ≈ 22.6 ppm
        val co2 = vm.calculateCo2Ppm(6.6f, 3.0f)
        assertTrue("CO2 ppm should be around 22.6 ppm", co2 in 22f..24f)

        val status = vm.getCo2Status(co2)
        assertTrue("Status should be optimal", status is Co2Status.OPTIMAL)
    }

    @Test
    fun testPlantParameterMatching() {
        val vm = AquaticBotanyViewModel()
        val matched = vm.getMatchedPlants(ph = 6.5f, kh = 2.0f, temp = 24, par = 80f)
        assertTrue("Should match multiple plants under standard tropical parameters", matched.isNotEmpty())
    }
}
