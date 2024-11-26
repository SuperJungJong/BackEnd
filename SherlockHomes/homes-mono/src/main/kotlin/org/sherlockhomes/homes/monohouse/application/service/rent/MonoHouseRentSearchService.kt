package org.sherlockhomes.homes.monohouse.application.service.rent

import org.sherlockhomes.homes.monohouse.application.port.inbound.MonoHouseSearchUseCase
import org.sherlockhomes.homes.monohouse.application.port.outbound.MonoHouseSearchPort
import org.sherlockhomes.homes.monohouse.domain.mapper.toVO
import org.sherlockhomes.homes.monohouse.application.service.rent.vo.MonoHouseRentVO
import org.sherlockhomes.homes.monohouse.domain.MonoHouseRent
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class MonoHouseRentSearchService(
    private val monoHouseRentSearchPort: MonoHouseSearchPort<MonoHouseRent>,
    private val kafkaTemplate: KafkaTemplate<String, String>
) : MonoHouseSearchUseCase<MonoHouseRentVO.MonoHouseRent> {

    override fun getList(lawdCd: Int, dealYmd: Int): List<MonoHouseRentVO.MonoHouseRent> {
        kafkaTemplate.send(
            "mono-log",
            "[mono][service] MonoHouseRentSearchService.getList (lawdCd=${lawdCd}, dealYmd=${dealYmd})"
        )
        kafkaTemplate.send(
            "all-log",
            "[mono][service] MonoHouseRentSearchService.getList (lawdCd=${lawdCd}, dealYmd=${dealYmd})"
        )

        return monoHouseRentSearchPort.search(
            lawdCd = lawdCd,
            dealYmd = dealYmd,
        ).map { it.toVO() }
    }
}