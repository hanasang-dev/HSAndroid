package dev.hanasang.hsandroid.core.presentation.portal

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * Composable that renders content for each linked zone of the given sourceZone.
 *
 * @param zoneManager The ZoneManager to query for linked zones.
 * @param sourceZone The source zone whose linked zones will be rendered.
 * @param modifier Modifier for the outer container.
 * @param contentFor Composable lambda to render content for each linked zone.
 */
@Composable
@Suppress("FunctionName")
fun ZoneContainer(
    zoneManager: ZoneManager,
    sourceZone: Zone,
    modifier: Modifier = Modifier,
    contentFor: @Composable (Zone) -> Unit,
) {
    val linkedZones = zoneManager.getLinkedZones(sourceZone)
    Box(modifier = modifier) {
        for (zone in linkedZones) {
            Box(modifier = Modifier.fillMaxSize()) {
                contentFor(zone)
            }
        }
    }
}
