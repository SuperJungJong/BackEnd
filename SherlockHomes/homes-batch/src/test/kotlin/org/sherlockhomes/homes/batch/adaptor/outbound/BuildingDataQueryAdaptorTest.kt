package org.sherlockhomes.homes.batch.adaptor.outbound

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.web.reactive.function.client.WebClient

@SpringBootTest
class BuildingDataQueryAdaptorTest @Autowired constructor(
    private val webClient: WebClient,
    private val buildingDataQueryAdaptor: BuildingDataQueryAdaptor
) {

    @Test
    fun test() {
        buildingDataQueryAdaptor.getBuildingData()
    }
}