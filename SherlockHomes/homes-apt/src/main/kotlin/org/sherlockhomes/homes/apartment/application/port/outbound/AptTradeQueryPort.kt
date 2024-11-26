package org.sherlockhomes.homes.apartment.application.port.outbound

import org.sherlockhomes.homes.apartment.domain.AptTrade
import org.sherlockhomes.homes.apartment.domain.ListPage
import org.springframework.data.domain.PageRequest

interface AptTradeQueryPort {
    fun findByAptNmWithPage(sgg: String, aptName: String, pageRequest: PageRequest): ListPage<AptTrade>

    fun findAllByDong(
        si: String,
        gu: String,
        dong: String,
    ): List<AptTrade>
}