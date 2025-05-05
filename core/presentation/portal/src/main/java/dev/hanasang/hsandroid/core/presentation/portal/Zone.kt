package dev.hanasang.hsandroid.core.presentation.portal

/**
 * Portal Zone 식별자로 사용됩니다.
 *
 * Map key로 활용되기 때문에, Zone 구현체는 가능한 단순하고 불변한 구조로 구성되어야 합니다.
 * - object / enum / id 기반 data class를 우선적으로 사용하세요.
 * - 복합 객체나 가변 필드를 피하세요.
 */
sealed interface Zone
