package org.sherlockhomes.homes.map.application.port.inbound

import org.sherlockhomes.homes.map.application.service.legaldong.vo.GuVO
import org.sherlockhomes.homes.map.application.service.legaldong.vo.SiVO

interface LegalDongQuery {

    fun getSiList(): List<SiVO.Si>

    fun getGuList(code: String): List<GuVO.Gu>

}