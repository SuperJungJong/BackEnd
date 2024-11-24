package org.sherlockhomes.homes.batch.application.port.outbound.persistence

import org.sherlockhomes.homes.batch.domain.AptRent

interface AptRentCommandPort {

    fun insertAptRentList(aptRentList: List<AptRent>)
}