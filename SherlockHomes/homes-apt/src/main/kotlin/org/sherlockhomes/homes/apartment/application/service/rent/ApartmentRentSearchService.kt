package org.sherlockhomes.homes.apartment.application.service.rent

import org.sherlockhomes.homes.apartment.application.port.inbound.ApartmentSearchUseCase
import org.sherlockhomes.homes.apartment.application.port.outbound.ApartmentSearchPort
import org.sherlockhomes.homes.apartment.application.service.vo.rent.AptRentVO
import org.sherlockhomes.homes.apartment.domain.AptRent
import org.sherlockhomes.homes.apartment.domain.mapper.toVO
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class ApartmentRentSearchService(
    private val aptRentSearchPort: ApartmentSearchPort<AptRent>,
    private val kafkaTemplate: KafkaTemplate<String, String>,
) : ApartmentSearchUseCase<AptRentVO.ApartmentRent> {

    override fun getList(lawdCd: Int, dealYmd: Int): List<AptRentVO.ApartmentRent> {
        kafkaTemplate.send(
            "apt-log",
            "[apt][service] getList (lawdCd=${lawdCd}, dealYmd=${dealYmd})"
        )
        kafkaTemplate.send(
            "all-log",
            "[apt][service] getList (lawdCd=${lawdCd}, dealYmd=${dealYmd})"
        )

        return aptRentSearchPort.search(
            lawdCd = lawdCd,
            dealYmd = dealYmd,
        ).map { it.toVO() }
    }

    override fun getListBySiGuDong(si: String, gu: String, dong: String): List<AptRentVO.ApartmentRent> {
        TODO("Not yet implemented")
    }
}