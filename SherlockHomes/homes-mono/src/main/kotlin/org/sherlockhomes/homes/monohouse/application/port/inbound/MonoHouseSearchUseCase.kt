package org.sherlockhomes.homes.monohouse.application.port.inbound

interface MonoHouseSearchUseCase<T> {

    fun getList(lawdCd: Int, dealYmd: Int): List<T>
}