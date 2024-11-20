package org.sherlockhomes.homes.map.application.port.outbound

import org.sherlockhomes.homes.map.domain.Gu
import org.sherlockhomes.homes.map.domain.Si

interface LegalDongQueryPort {

    fun getSiList(): List<Si>

    fun getGuList(code: String): List<Gu>
}