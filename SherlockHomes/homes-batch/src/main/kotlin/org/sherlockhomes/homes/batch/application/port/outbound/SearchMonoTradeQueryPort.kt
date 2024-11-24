package org.sherlockhomes.homes.batch.application.port.outbound

import org.sherlockhomes.homes.batch.domain.MonoTrade

interface SearchMonoTradeQueryPort {
    fun searchMonoTrade(lawdCd: Int, dealYmd: Int): List<MonoTrade>
}