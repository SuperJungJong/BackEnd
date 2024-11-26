package org.sherlockhomes.homes.monohouse.application.port.inbound

import org.sherlockhomes.homes.monohouse.application.service.rent.vo.MonoHouseRentVO
import org.sherlockhomes.homes.monohouse.application.service.trade.vo.MonoHouseTradeVO

interface MonoHouseTradeQuery {
    fun getMonoTradeListBySgg(
        si: String,
        gu: String,
        dong: String,
    ): List<MonoHouseTradeVO.MonoHouseTrade>
}