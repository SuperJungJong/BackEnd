package org.sherlockhomes.homes.apartment.application.port.inbound

import org.sherlockhomes.homes.apartment.application.service.vo.trade.AptTradeVO
import org.sherlockhomes.homes.apartment.application.service.vo.trade.ListPageVO
import org.sherlockhomes.homes.apartment.domain.AptTrade

interface AptTradeQuery {
    fun getAptTrade(
        sgg: String,
        aptName: String,
        offset: Int,
        limit: Int,
    ): ListPageVO<AptTradeVO.AptTrade>

    fun getAptInDong(
        si: String,
        gu: String,
        dong: String,
    ): List<AptTradeVO.AptTrade>
}