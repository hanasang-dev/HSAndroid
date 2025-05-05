package dev.hanasang.hsandroid.core.presentation.portal

import kotlin.reflect.KClass

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.SOURCE)
annotation class ZoneContent(val zone: KClass<out Zone>)
