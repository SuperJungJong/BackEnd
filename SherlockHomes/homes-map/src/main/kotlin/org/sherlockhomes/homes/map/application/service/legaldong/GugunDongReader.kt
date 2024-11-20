package org.sherlockhomes.homes.map.application.service.legaldong

import org.sherlockhomes.homes.map.application.port.inbound.GugunDongQuery
import org.sherlockhomes.homes.map.application.port.outbound.GugunDongQueryPort
import org.sherlockhomes.homes.map.application.service.legaldong.vo.GugunDongVO
import org.sherlockhomes.homes.map.domain.mapper.toVO
import org.springframework.stereotype.Service

@Service
class GugunDongReader(
    private val gugunDongQueryPort: GugunDongQueryPort,
) : GugunDongQuery {
    override fun getGugunDong(gugun: String): List<GugunDongVO.Gugun> =
        gugunDongQueryPort.findDongListByGugun(gugun).map { it.toVO() }
}