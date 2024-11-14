package org.sherlockhomes.homes.apartment.application.port.outbound

interface ApartmentSearchPort<T> {

    fun search(lawdCd: Int, dealYmd: Int): List<T>
}