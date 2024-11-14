package org.sherlockhomes.homes.apartment.application.port.inbound

interface ApartmentSearchUseCase<T> {

    fun getList(lawdCd: Int, dealYmd: Int): List<T>
}