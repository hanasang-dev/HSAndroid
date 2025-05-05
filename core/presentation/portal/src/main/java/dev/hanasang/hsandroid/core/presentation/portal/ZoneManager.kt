package dev.hanasang.hsandroid.core.presentation.portal
class ZoneManager {
    private val zoneMappings: MutableMap<Zone, MutableList<Zone>> = mutableMapOf()

    fun link(sourceZone: Zone, vararg targetZones: Zone) {
        val targets = zoneMappings.getOrPut(sourceZone) { mutableListOf() }
        targets.addAll(targetZones)
    }

    fun getLinkedZones(sourceZone: Zone): List<Zone> = zoneMappings[sourceZone]?.toList().orEmpty()

    fun clear() {
        zoneMappings.clear()
    }
}
