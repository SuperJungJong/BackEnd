package org.sherlockhomes.homes.batch.application.port.outbound.persistence

import org.sherlockhomes.homes.batch.domain.MonoTrade

interface MonoTradeCommandPort {

    fun insertMonoTradeList(monoTradeList: List<MonoTrade>)
}