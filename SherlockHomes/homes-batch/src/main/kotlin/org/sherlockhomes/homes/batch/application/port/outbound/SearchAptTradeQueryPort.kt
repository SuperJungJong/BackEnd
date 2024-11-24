package org.sherlockhomes.homes.batch.application.port.outbound

import org.sherlockhomes.homes.batch.domain.AptTrade

interface SearchAptTradeQueryPort {
    fun searchAptTrade(lawdCd: Int, dealYmd: Int): List<AptTrade>
}