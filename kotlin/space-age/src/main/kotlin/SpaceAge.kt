class SpaceAge(val seconds: Int) {

    val EARTH_YEAR_IN_SECONDS = 31557600.toDouble()
    fun onPlanet(earthYears: Double): Double { return (seconds / EARTH_YEAR_IN_SECONDS) / earthYears }

    fun onEarth(): Double = onPlanet(1.0)
    fun onMercury(): Double = onPlanet(0.2408467)
    fun onVenus(): Double = onPlanet(0.61519726)
    fun onMars(): Double = onPlanet(1.8808158)
    fun onJupiter(): Double = onPlanet(11.862615)
    fun onSaturn(): Double = onPlanet(29.447498)
    fun onUranus(): Double = onPlanet(84.016846)
    fun onNeptune(): Double = onPlanet(164.79132)
}
