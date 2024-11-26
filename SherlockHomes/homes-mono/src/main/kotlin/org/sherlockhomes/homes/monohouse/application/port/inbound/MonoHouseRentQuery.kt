package org.sherlockhomes.homes.monohouse.application.port.inbound

import org.sherlockhomes.homes.monohouse.application.service.rent.vo.MonoHouseRentVO

interface MonoHouseRentQuery {
    fun getMonoRentListBySgg(
        si: String,
        gu: String,
        dong: String,
    ): List<MonoHouseRentVO.MonoHouseRent>
}