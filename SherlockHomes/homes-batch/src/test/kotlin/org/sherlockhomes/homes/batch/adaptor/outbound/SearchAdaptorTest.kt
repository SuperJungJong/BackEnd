package org.sherlockhomes.homes.batch.adaptor.outbound

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class SearchAdaptorTest @Autowired constructor(
    private val searchMonoTradeAdaptor: SearchMonoTradeAdaptor,
    private val searchMonoRentAdaptor: SearchMonoRentAdaptor,
    private val searchApartmentTradeAdaptor: SearchMonoTradeAdaptor,
    private val searchAptRentAdaptor: SearchAptRentAdaptor,
) {

    @Test
    fun searchMonoTradeAdaptor() {
        val search = searchMonoTradeAdaptor.searchMonoTrade(51110, 202410)
        println("search = ${search}")
    }

    @Test
    fun searchMonoRentAdaptor() {
        val search = searchMonoRentAdaptor.searchMonoRent(51110, 202410)
        println("search = ${search}")
    }

    @Test
    fun searchApartmentTradeAdaptor() {
        val search = searchApartmentTradeAdaptor.searchMonoTrade(51110, 202410)
        println("search = ${search}")
    }

    @Test
    fun searchAptRentAdaptor() {
        val search = searchAptRentAdaptor.searchAptRent(51110, 202410)
        println("search = ${search}")
    }
}
