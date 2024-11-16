package org.sherlockhomes.homes.common.application.service.legaldong

import org.sherlockhomes.homes.common.application.port.inbound.LegalDongQuery
import org.sherlockhomes.homes.common.application.port.outbound.LegalDongQueryPort
import org.sherlockhomes.homes.common.application.service.legaldong.vo.GuVO
import org.sherlockhomes.homes.common.application.service.legaldong.vo.SiVO
import org.sherlockhomes.homes.common.domain.mapper.toVO
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
