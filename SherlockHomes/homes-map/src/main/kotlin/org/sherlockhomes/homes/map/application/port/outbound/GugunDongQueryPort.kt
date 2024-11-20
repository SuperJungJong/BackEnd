package org.sherlockhomes.homes.map.application.port.outbound

import org.sherlockhomes.homes.map.domain.GugunDong

interface GugunDongQueryPort {
    fun findDongListByGugun(gugun: String): List<GugunDong>
}