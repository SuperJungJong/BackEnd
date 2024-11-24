package org.sherlockhomes.homes.batch.application.service

import org.sherlockhomes.homes.batch.adaptor.outbound.persistence.AptTradeCommandAdaptor
import org.sherlockhomes.homes.batch.application.port.outbound.persistence.AptRentCommandPort
import org.sherlockhomes.homes.batch.application.port.outbound.persistence.AptTradeCommandPort
import org.sherlockhomes.homes.batch.domain.AptRent
import org.sherlockhomes.homes.batch.domain.AptTrade
import org.springframework.stereotype.Service

@Service
class AptWriter(
    private val aptRentCommandPort: AptRentCommandPort,
    private val aptTradeCommandPort: AptTradeCommandPort,
) {

    fun saveAllRent(aptRentList: List<AptRent>) {
        aptRentCommandPort.insertAptRentList(aptRentList)
    }

    fun saveAllTrade(aptTradeList: List<AptTrade>) {
        aptTradeCommandPort.insertAptTradeList(aptTradeList)
    }
}