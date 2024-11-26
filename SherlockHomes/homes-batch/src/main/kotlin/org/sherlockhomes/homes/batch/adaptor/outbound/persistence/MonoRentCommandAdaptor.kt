package org.sherlockhomes.homes.batch.adaptor.outbound.persistence

import org.sherlockhomes.homes.batch.application.port.outbound.persistence.MonoRentCommandPort
import org.sherlockhomes.homes.batch.domain.MonoRent
import org.sherlockhomes.homes.batch.domain.mapper.toEntity
import org.sherlockhomes.homes.infra.rdb.repository.mono.MonoRentRepository
import org.springframework.stereotype.Component

@Component
class MonoRentCommandAdaptor(
    private val monoRentRepository: MonoRentRepository,
) : MonoRentCommandPort {
    override fun insertMonoRentList(monoRentList: List<MonoRent>) {
        monoRentRepository.saveAll(monoRentList.map { it.toEntity() })
    }
}