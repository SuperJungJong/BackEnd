package org.sherlockhomes.homes.monohouse.adaptor.outbound

import org.sherlockhomes.homes.infra.rdb.MonoTradeRepository
import org.sherlockhomes.homes.monohouse.application.port.outbound.MonoTradeQueryPort
import org.sherlockhomes.homes.monohouse.domain.MonoHouseTrade
import org.sherlockhomes.homes.monohouse.domain.mapper.toDomain
import org.springframework.stereotype.Component

@Component
class MonoTradeQueryAdaptor(
    private val monoTradeRepository: MonoTradeRepository,
) : MonoTradeQueryPort {
    override fun findBySiGuDong(si: String, gu: String, dong: String): List<MonoHouseTrade> =
        monoTradeRepository.findAllBySiAndGuAndDong(si, gu, dong).map { it.toDomain() }

}