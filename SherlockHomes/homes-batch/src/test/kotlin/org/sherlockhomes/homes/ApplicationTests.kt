package org.sherlockhomes.homes

import org.junit.jupiter.api.Test
import org.sherlockhomes.homes.batch.adaptor.outbound.SearchAptRentAdaptor
import org.sherlockhomes.homes.batch.adaptor.outbound.SearchMonoRentAdaptor
import org.sherlockhomes.homes.batch.adaptor.outbound.SearchMonoTradeAdaptor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ApplicationTests @Autowired constructor(
    private val searchMonoTradeAdaptor: SearchMonoTradeAdaptor,
    private val searchMonoRentAdaptor: SearchMonoRentAdaptor,
    private val searchApartmentTradeAdaptor: SearchMonoTradeAdaptor,
    private val searchAptRentAdaptor: SearchAptRentAdaptor,
) {

    @Test
    fun contextLoads() {
    }

}
