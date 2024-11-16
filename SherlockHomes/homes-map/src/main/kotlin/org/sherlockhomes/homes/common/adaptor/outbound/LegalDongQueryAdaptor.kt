package org.sherlockhomes.homes.common.adaptor.outbound

import org.sherlockhomes.homes.common.application.port.outbound.LegalDongQueryPort
import org.sherlockhomes.homes.common.domain.Gu
import org.sherlockhomes.homes.common.domain.Si
import org.sherlockhomes.homes.common.domain.mapper.toDomain
import org.sherlockhomes.homes.infra.rdb.repository.GuRepository
import org.sherlockhomes.homes.infra.rdb.repository.SiRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class LegalDongQueryAdaptor(
    private val guRepository: GuRepository,
    private val siRepository: SiRepository,

    ) : LegalDongQueryPort {

    @Transactional(readOnly = true)
    override fun getSiList(): List<Si> {
        println("siRepository.findAll() = ${siRepository.findAll()}")
        return siRepository.findAll()
            .map { it.toDomain() }

    }

    @Transactional(readOnly = true)
    override fun getGuList(code: String): List<Gu> =
        guRepository.findAllByCodeStartsWith(code)
            .map { it.toDomain() }

}