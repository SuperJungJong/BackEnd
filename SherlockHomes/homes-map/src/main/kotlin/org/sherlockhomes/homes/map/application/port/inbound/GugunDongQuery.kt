package org.sherlockhomes.homes.map.application.port.inbound

import org.sherlockhomes.homes.map.application.service.legaldong.vo.GugunDongVO

interface GugunDongQuery {
    fun getGugunDong(gugun: String): List<GugunDongVO.Gugun>
}