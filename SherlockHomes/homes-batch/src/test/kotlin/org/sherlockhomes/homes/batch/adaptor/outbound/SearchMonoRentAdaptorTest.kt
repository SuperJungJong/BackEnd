package org.sherlockhomes.homes.batch.adaptor.outbound

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.web.reactive.function.client.WebClient

@SpringBootTest
class SearchMonoRentAdaptorTest @Autowired constructor(
    private val webClient: WebClient,
    private val adaptor: SearchAptTradeAdaptor
) {

    @Test
    fun test() {
        val search = adaptor.searchAptTrade(51150, 202410)
        println("search = ${search}")
        search.map { print("name = ${it.aptNm}") }

    }
}