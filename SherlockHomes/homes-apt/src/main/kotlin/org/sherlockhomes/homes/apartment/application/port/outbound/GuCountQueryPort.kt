package org.sherlockhomes.homes.apartment.application.port.outbound

import org.sherlockhomes.homes.apartment.domain.GuCount

interface GuCountQueryPort {
    fun findAllBySi(si: String): List<GuCount>
}