package org.sherlockhomes.homes.map.adaptor.outbound

import org.sherlockhomes.homes.infra.rdb.repository.DongCodeRepository
import org.sherlockhomes.homes.map.application.port.outbound.GugunDongQueryPort
import org.sherlockhomes.homes.map.domain.GugunDong
import org.sherlockhomes.homes.map.domain.mapper.toGugunDong
import org.springframework.stereotype.Component

@Component
class GugunDongQueryAdaptor(
    private val dongCodeRepository: DongCodeRepository,
) : GugunDongQueryPort {

    override fun findDongListByGugun(gugun: String): List<GugunDong> =
        dongCodeRepository.findAllByGugunNameAndDongNameNotNull(gugun).map { it.toGugunDong() }

}