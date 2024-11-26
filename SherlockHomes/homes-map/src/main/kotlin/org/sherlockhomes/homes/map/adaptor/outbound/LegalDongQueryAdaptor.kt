package org.sherlockhomes.homes.map.adaptor.outbound

import org.sherlockhomes.homes.map.domain.Gu
import org.sherlockhomes.homes.map.domain.Si
import org.sherlockhomes.homes.map.domain.mapper.toDomain
import org.sherlockhomes.homes.infra.rdb.repository.GuRepository
import org.sherlockhomes.homes.infra.rdb.repository.SiRepository
import org.sherlockhomes.homes.map.application.port.outbound.LegalDongQueryPort
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class LegalDongQueryAdaptor(
    private val guRepository: GuRepository,
    private val siRepository: SiRepository,

    ) : LegalDongQueryPort {

    @Transactional(readOnly = true)
    override fun getSiList(): List<Si> {
        return siRepository.findAll()
            .map { it.toDomain() }

    }

    @Transactional(readOnly = true)
    override fun getGuList(code: String): List<Gu> =
        guRepository.findAllByCodeStartsWith(code)
            .map { it.toDomain() }

}