package org.sherlockhomes.homes.common.exception

class Common500Exception(
    override val code: Int? = 500,
    override val message: String
) : AbstractException(
    code = code,
    message = message,
)