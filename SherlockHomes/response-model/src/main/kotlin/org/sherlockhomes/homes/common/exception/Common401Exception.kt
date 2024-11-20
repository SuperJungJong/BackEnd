package org.sherlockhomes.homes.common.exception

class Common401Exception(
    override val code: Int? = 401,
    override val message: String
) : AbstractException(
    code = code,
    message = message,
)