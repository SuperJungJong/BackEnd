package org.sherlockhomes.homes.common.exception

abstract class AbstractException(
    open val code: Int?,
    override val message: String,
) : RuntimeException()