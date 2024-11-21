package org.sherlockhomes.homes.apartment.application.port.inbound

import org.sherlockhomes.homes.apartment.application.service.vo.trade.AptTradeVO
import org.sherlockhomes.homes.apartment.application.service.vo.trade.ListPageVO
import org.sherlockhomes.homes.apartment.domain.AptTrade

interface AptTradeQuery {
    fun getAptTrade(
        aptName: String,
        offset: Int,
        limit: Int,
    ): ListPageVO<AptTradeVO.AptTrade>

    fun getAptInDong(dong: String): List<AptTradeVO.AptTrade>
}