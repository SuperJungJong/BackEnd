package org.sherlockhomes.homes.apartment.adaptor.outbound

import org.sherlockhomes.homes.apartment.application.port.outbound.GuCountQueryPort
import org.sherlockhomes.homes.apartment.domain.GuCount
import org.sherlockhomes.homes.apartment.domain.mapper.toDomain
import org.sherlockhomes.homes.infra.rdb.repository.GuCountRepository
import org.springframework.stereotype.Component

@Component
class GuCountQueryAdaptor(
    private val guCountRepository: GuCountRepository
) : GuCountQueryPort {
    override fun findAllBySi(si: String): List<GuCount> =
        guCountRepository.findAllBySiName(si).map { it.toDomain() }
}