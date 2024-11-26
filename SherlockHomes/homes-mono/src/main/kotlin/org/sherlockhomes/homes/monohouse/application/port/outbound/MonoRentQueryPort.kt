package org.sherlockhomes.homes.monohouse.application.port.outbound

import org.sherlockhomes.homes.monohouse.domain.MonoHouseRent

interface MonoRentQueryPort {

    fun findBySiGuDong(si: String, gu: String, dong: String): List<MonoHouseRent>

}