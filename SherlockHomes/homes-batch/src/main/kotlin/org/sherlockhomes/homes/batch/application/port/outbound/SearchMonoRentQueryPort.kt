package org.sherlockhomes.homes.batch.application.port.outbound

import org.sherlockhomes.homes.batch.domain.MonoRent

interface SearchMonoRentQueryPort {
    fun searchMonoRent(lawdCd: Int, dealYmd: Int): List<MonoRent>
}