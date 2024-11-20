package org.sherlockhomes.homes.apartment.application.service

import org.sherlockhomes.homes.apartment.application.port.inbound.GuCountQuery
import org.sherlockhomes.homes.apartment.application.port.outbound.GuCountQueryPort
import org.sherlockhomes.homes.apartment.application.service.vo.GuCountVO
import org.sherlockhomes.homes.apartment.domain.mapper.toVO
import org.springframework.stereotype.Component

@Component
class GuCountReader(
    private val guCountQueryPort: GuCountQueryPort,
) : GuCountQuery {
    override fun getGuCount(si: String): List<GuCountVO.GuCount> =
        guCountQueryPort.findAllBySi(si).map { it.toVO() }


}