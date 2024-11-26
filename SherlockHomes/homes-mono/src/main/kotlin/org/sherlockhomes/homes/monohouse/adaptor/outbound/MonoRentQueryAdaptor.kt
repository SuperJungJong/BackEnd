package org.sherlockhomes.homes.monohouse.adaptor.outbound

import org.sherlockhomes.homes.infra.rdb.MonoRentRepository
import org.sherlockhomes.homes.monohouse.application.port.outbound.MonoRentQueryPort
import org.sherlockhomes.homes.monohouse.domain.MonoHouseRent
import org.sherlockhomes.homes.monohouse.domain.mapper.toDomain
import org.springframework.stereotype.Component

@Component
class MonoRentQueryAdaptor(
    private val monoRentRepository: MonoRentRepository,
) : MonoRentQueryPort {
    override fun findBySiGuDong(si: String, gu: String, dong: String): List<MonoHouseRent> =
        monoRentRepository.findAllBySiAndGuAndDong(
            si = si,
            gu = gu,
            dong = dong,
        ).map { it.toDomain() }

}