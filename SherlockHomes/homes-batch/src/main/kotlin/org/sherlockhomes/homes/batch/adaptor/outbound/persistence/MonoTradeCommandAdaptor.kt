package org.sherlockhomes.homes.batch.adaptor.outbound.persistence

import org.sherlockhomes.homes.batch.application.port.outbound.persistence.MonoTradeCommandPort
import org.sherlockhomes.homes.batch.domain.MonoTrade
import org.sherlockhomes.homes.batch.domain.mapper.toEntity
import org.sherlockhomes.homes.infra.rdb.repository.mono.MonoTradeRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
@Transactional
class MonoTradeCommandAdaptor(
    private val monoTradeRepository: MonoTradeRepository,
) : MonoTradeCommandPort {

    @Transactional
    override fun insertMonoTradeList(monoTradeList: List<MonoTrade>) {
        monoTradeRepository.saveAll(monoTradeList.map { it.toEntity() })
        val toEntity = monoTradeList.get(0).toEntity()

        monoTradeRepository.saveAndFlush(toEntity)

        val findAll = monoTradeRepository.findAll()
    }
}