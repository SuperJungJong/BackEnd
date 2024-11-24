package org.sherlockhomes.homes.batch.application.service

import org.sherlockhomes.homes.batch.application.port.outbound.SearchMonoRentQueryPort
import org.sherlockhomes.homes.batch.application.port.outbound.SearchMonoTradeQueryPort

class MonoSearchService(
    private val searchMonoRentQueryPort: SearchMonoRentQueryPort,
    private val searchMonoTradeQueryPort: SearchMonoTradeQueryPort,
) {

    fun searchMonoRent(lawd: Int, ym: Int) {
        searchMonoRentQueryPort.searchMonoRent(lawd, ym)
    }

    fun searchMonoTrade(lawd: Int, ym: Int) {
        searchMonoTradeQueryPort.searchMonoTrade(lawd, ym)
    }
}