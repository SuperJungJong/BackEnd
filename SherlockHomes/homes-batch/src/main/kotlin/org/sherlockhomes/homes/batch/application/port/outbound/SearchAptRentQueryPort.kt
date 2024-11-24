package org.sherlockhomes.homes.batch.application.port.outbound

import org.sherlockhomes.homes.batch.domain.AptRent

interface SearchAptRentQueryPort {
    fun searchAptRent(lawdCd: Int, dealYmd: Int): List<AptRent>
}