package org.sherlockhomes.homes.batch.adaptor.outbound.persistence

import org.sherlockhomes.homes.batch.application.port.outbound.persistence.AptRentCommandPort
import org.sherlockhomes.homes.batch.domain.AptRent
import org.sherlockhomes.homes.batch.domain.mapper.toEntity
import org.sherlockhomes.homes.infra.rdb.repository.apt.AptRentRepository
import org.springframework.stereotype.Component

@Component
class AptRentCommandAdaptor(
    private val aptRentRepository: AptRentRepository,
) : AptRentCommandPort {
    override fun insertAptRentList(aptRentList: List<AptRent>) {
        aptRentRepository.saveAll(aptRentList.map { it.toEntity() })
    }
}