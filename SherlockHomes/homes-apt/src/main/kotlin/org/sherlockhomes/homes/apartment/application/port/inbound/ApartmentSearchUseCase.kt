package org.sherlockhomes.homes.apartment.application.port.inbound

interface ApartmentSearchUseCase<T> {

    fun getList(lawdCd: Int, dealYmd: Int): List<T>

    fun getListBySiGuDong(si: String, gu: String, dong: String): List<T>
}