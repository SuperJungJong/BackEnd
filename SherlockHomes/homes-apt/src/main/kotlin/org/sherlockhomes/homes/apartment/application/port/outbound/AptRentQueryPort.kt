package org.sherlockhomes.homes.apartment.application.port.outbound

import org.sherlockhomes.homes.apartment.domain.AptRent

interface AptRentQueryPort {

    fun findAllRentInDong(
        si: String,
        gu: String,
        dong: String,
    ): List<AptRent>

    fun findAptRentDetail(
        si: String,
        gu: String,
        dong: String,
        name: String,
    ): List<AptRent>
}