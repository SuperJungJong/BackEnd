package org.sherlockhomes.homes.apartment.application.port.inbound

import org.sherlockhomes.homes.apartment.application.service.vo.GuCountVO

interface GuCountQuery {

    fun getGuCount(si: String): List<GuCountVO.GuCount>
}