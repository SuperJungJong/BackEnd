package org.sherlockhomes.homes.common.application.port.inbound

import org.sherlockhomes.homes.common.application.service.legaldong.vo.GuVO
import org.sherlockhomes.homes.common.application.service.legaldong.vo.SiVO

interface LegalDongQuery {

    fun getSiList(): List<SiVO.Si>

    fun getGuList(code: String): List<GuVO.Gu>

}