package org.sherlockhomes.homes.batch.adaptor.outbound.persistence

import org.sherlockhomes.homes.batch.application.port.outbound.persistence.AptTradeCommandPort
import org.sherlockhomes.homes.batch.domain.AptTrade
import org.sherlockhomes.homes.batch.domain.mapper.toEntity
import org.sherlockhomes.homes.infra.rdb.repository.apt.AptTradeRepository
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class AptTradeCommandAdaptor(
    private val aptTradeRepository: AptTradeRepository,
) : AptTradeCommandPort {

    override fun insertAptTradeList(aptTradeList: List<AptTrade>) {
        aptTradeRepository.saveAll(aptTradeList.map { it.toEntity() })
        println("insertAptTradeList")
    }
}