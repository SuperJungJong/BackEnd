package org.sherlockhomes.homes.common.application.port.outbound

import org.sherlockhomes.homes.common.domain.Gu
import org.sherlockhomes.homes.common.domain.Si

interface LegalDongQueryPort {

    fun getSiList(): List<Si>

    fun getGuList(code: String): List<Gu>
}