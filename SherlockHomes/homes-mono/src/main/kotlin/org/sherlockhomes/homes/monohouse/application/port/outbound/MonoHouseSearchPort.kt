package org.sherlockhomes.homes.monohouse.application.port.outbound

interface MonoHouseSearchPort<T> {

    fun search(lawdCd: Int, dealYmd: Int): List<T>
}