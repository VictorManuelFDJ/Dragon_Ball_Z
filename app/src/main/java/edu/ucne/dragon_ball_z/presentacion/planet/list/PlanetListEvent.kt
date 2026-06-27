package edu.ucne.dragon_ball_z.presentacion.planet.list

sealed interface PlanetListEvent {
    data class UpdateFilters(val name: String, val isDestroyed: Boolean? = null) : PlanetListEvent
    data object Search: PlanetListEvent
}