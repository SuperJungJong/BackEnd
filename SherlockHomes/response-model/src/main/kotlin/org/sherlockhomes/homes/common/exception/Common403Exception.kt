package org.sherlockhomes.homes.common.exception

class Common403Exception(
    override val code: Int? = 403,
    override val message: String
) : AbstractException(
    code = code,
    message = message,
)