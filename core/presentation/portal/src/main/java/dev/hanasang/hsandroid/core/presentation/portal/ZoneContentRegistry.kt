package dev.hanasang.hsandroid.core.presentation.portal

import androidx.compose.runtime.Composable

class ZoneContentRegistry {
    private val contentMap = mutableMapOf<Zone, @Composable () -> Unit>()

    fun register(zone: Zone, content: @Composable () -> Unit) {
        contentMap[zone] = content
    }

    fun getContent(zone: Zone): (@Composable () -> Unit)? = contentMap[zone]
}
