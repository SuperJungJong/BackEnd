package org.sherlockhomes.homes.batch.application.service

import org.sherlockhomes.homes.batch.application.port.outbound.persistence.MonoRentCommandPort
import org.sherlockhomes.homes.batch.application.port.outbound.persistence.MonoTradeCommandPort
import org.sherlockhomes.homes.batch.domain.MonoRent
import org.sherlockhomes.homes.batch.domain.MonoTrade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MonoWriter(
    private val monoRentCommandPort: MonoRentCommandPort,
    private val monoTradeCommandPort: MonoTradeCommandPort,
) {

    @Transactional
    fun saveAllRent(monoRentList: List<MonoRent>) {
        monoRentCommandPort.insertMonoRentList(monoRentList)
    }

    @Transactional
    fun saveAllTrade(monoTradeList: List<MonoTrade>) {
        monoTradeCommandPort.insertMonoTradeList(monoTradeList)
    }

}