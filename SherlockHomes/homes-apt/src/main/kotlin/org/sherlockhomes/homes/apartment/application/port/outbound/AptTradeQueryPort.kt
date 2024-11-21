package org.sherlockhomes.homes.apartment.application.port.outbound

import org.sherlockhomes.homes.apartment.domain.AptTrade
import org.sherlockhomes.homes.apartment.domain.ListPage
import org.springframework.data.domain.PageRequest

interface AptTradeQueryPort {
    fun findByAptNmWithPage(aptName: String, pageRequest: PageRequest): ListPage<AptTrade>

    fun findAllByDong(dong: String): List<AptTrade>
}