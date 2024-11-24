package org.sherlockhomes.homes.batch.application.port.outbound

interface BuildingDataQueryPort<T> {

    fun getBuildingData(): T
}