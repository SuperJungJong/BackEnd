package org.sherlockhomes.homes.monohouse.application.port.outbound

import org.sherlockhomes.homes.monohouse.domain.MonoHouseTrade

interface MonoTradeQueryPort {

    fun findBySiGuDong(si: String, gu: String, dong: String): List<MonoHouseTrade>
}