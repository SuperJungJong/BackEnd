package org.sherlockhomes.homes.common.exception

class Common404Exception(
    override val code: Int? = 404,
    override val message: String
) : AbstractException(
    code = code,
    message = message,
)