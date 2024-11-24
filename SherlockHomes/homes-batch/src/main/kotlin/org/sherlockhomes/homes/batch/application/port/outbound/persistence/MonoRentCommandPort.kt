package org.sherlockhomes.homes.batch.application.port.outbound.persistence

import org.sherlockhomes.homes.batch.domain.MonoRent

interface MonoRentCommandPort {

    fun insertMonoRentList(monoRentList: List<MonoRent>)
}