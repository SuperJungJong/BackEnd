package org.sherlockhomes.homes.map.application.service.legaldong

import org.sherlockhomes.homes.map.application.port.inbound.LegalDongQuery
import org.sherlockhomes.homes.map.application.port.outbound.LegalDongQueryPort
import org.sherlockhomes.homes.map.application.service.legaldong.vo.GuVO
import org.sherlockhomes.homes.map.application.service.legaldong.vo.SiVO
import org.sherlockhomes.homes.map.domain.mapper.toVO
import org.springframework.stereotype.Service

@Service
class LegalDongReader(
    private val legalDongQueryPort: LegalDongQueryPort,
) : LegalDongQuery {

    override fun getSiList(): List<SiVO.Si> =
        legalDongQueryPort.getSiList().map { it.toVO() }

    override fun getGuList(
        code: String
    ): List<GuVO.Gu> =
        legalDongQueryPort.getGuList(code).map { it.toVO() }

}
