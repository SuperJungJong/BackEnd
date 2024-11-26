package org.sherlockhomes.homes.apartment.application.service.trade

import org.sherlockhomes.homes.apartment.application.port.inbound.ApartmentSearchUseCase
import org.sherlockhomes.homes.apartment.application.port.outbound.ApartmentSearchPort
import org.sherlockhomes.homes.apartment.application.service.vo.trade.ApartmentTradeVO
import org.sherlockhomes.homes.apartment.domain.ApartmentTrade
import org.sherlockhomes.homes.apartment.domain.mapper.toVO
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class ApartmentTradeSearchService(
    private val apartmentTradeSearchPort: ApartmentSearchPort<ApartmentTrade>,
    private val kafkaTemplate: KafkaTemplate<String, String>
) : ApartmentSearchUseCase<ApartmentTradeVO.ApartmentTrade> {

    override fun getList(lawdCd: Int, dealYmd: Int): List<ApartmentTradeVO.ApartmentTrade> {
        kafkaTemplate.send(
            "apt-log",
            "[apt][service] getList (lawdCd=${lawdCd}, dealYmd=${dealYmd})"
        )
        kafkaTemplate.send(
            "all-log",
            "[apt][service] getList (lawdCd=${lawdCd}, dealYmd=${dealYmd})"
        )

        return apartmentTradeSearchPort.search(
            lawdCd = lawdCd,
            dealYmd = dealYmd,
        ).map { it.toVO() }
    }

    override fun getListBySiGuDong(si: String, gu: String, dong: String): List<ApartmentTradeVO.ApartmentTrade> {
        TODO("Not yet implemented")
    }
}