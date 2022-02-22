package com.example.s04recyclerview.data.repositories

import com.example.s04recyclerview.domain.models.Planet
import kotlin.random.Random

class PlanetRepositories {
    fun retrievePlanets() : List<Planet> {
        val numberToGenerate = Random.nextInt(5, 21)
        val planets = mutableListOf<Planet>()

        for(i in 0..numberToGenerate){
            planets.add(newPlanet())
        }
        return planets
    }

    private fun newPlanet(): Planet {
        val planetNumber = Random.nextInt(1, 51)
        val planetImage = Random.nextInt(1, 7)
        val temperature = Random.nextDouble(0.0, 150.0)
        return Planet("planet$planetNumber", planetImage.toString(), temperature)
    }
}