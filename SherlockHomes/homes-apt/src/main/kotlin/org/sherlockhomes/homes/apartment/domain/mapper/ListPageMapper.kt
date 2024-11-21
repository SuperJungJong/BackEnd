package org.sherlockhomes.homes.apartment.domain.mapper

import org.sherlockhomes.homes.apartment.application.service.vo.trade.AptTradeVO
import org.sherlockhomes.homes.apartment.application.service.vo.trade.ListPageVO
import org.sherlockhomes.homes.apartment.domain.AptTrade
import org.sherlockhomes.homes.apartment.domain.ListPage

fun ListPage<AptTrade>.toVO(): ListPageVO<AptTradeVO.AptTrade> =
    ListPageVO<AptTradeVO.AptTrade>(
        items = items.map { it.toVO() },
        totalPage = totalPage,
        total = total,
    )
