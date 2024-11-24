package org.sherlockhomes.homes.batch.application.service

import org.sherlockhomes.homes.batch.application.port.outbound.SearchAptRentQueryPort
import org.sherlockhomes.homes.batch.application.port.outbound.SearchAptTradeQueryPort
import org.springframework.stereotype.Service

@Service
class AptSearchService(
    private val searchAptRentQueryPort: SearchAptRentQueryPort,
    private val searchAptTradeQueryPort: SearchAptTradeQueryPort,
) {

    fun searchAptTrade(lawdCd: Int, ym: Int) {
        searchAptTradeQueryPort.searchAptTrade(lawdCd, ym)
    }

    fun searchAptRent(lawdCd: Int, ym: Int) {
        searchAptRentQueryPort.searchAptRent(lawdCd, ym)
    }
}