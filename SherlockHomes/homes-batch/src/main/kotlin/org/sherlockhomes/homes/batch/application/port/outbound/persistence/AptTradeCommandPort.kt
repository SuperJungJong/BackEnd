package org.sherlockhomes.homes.batch.application.port.outbound.persistence

import org.sherlockhomes.homes.batch.domain.AptTrade

interface AptTradeCommandPort {

    fun insertAptTradeList(aptTradeList: List<AptTrade>)
}