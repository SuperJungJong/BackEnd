package org.sherlockhomes.homes.monohouse.application.service.trade

import org.sherlockhomes.homes.monohouse.application.port.inbound.MonoHouseSearchUseCase
import org.sherlockhomes.homes.monohouse.application.port.outbound.MonoHouseSearchPort
import org.sherlockhomes.homes.monohouse.domain.mapper.toVO
import org.sherlockhomes.homes.monohouse.application.service.trade.vo.MonoHouseTradeVO
import org.sherlockhomes.homes.monohouse.domain.MonoHouseTrade
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class MonoHouseTradeSearchService(
    private val monoHouseTradeSearchPort: MonoHouseSearchPort<MonoHouseTrade>,
    private val kafkaTemplate: KafkaTemplate<String, String>
) : MonoHouseSearchUseCase<MonoHouseTradeVO.MonoHouseTrade> {

    override fun getList(lawdCd: Int, dealYmd: Int): List<MonoHouseTradeVO.MonoHouseTrade> {
        kafkaTemplate.send(
            "mono-log",
            "[mono][service] MonoHouseTradeSearchService.getList (lawdCd=${lawdCd}, dealYmd=${dealYmd})"
        )
        kafkaTemplate.send(
            "all-log",
            "[mono][service] MonoHouseTradeSearchService.getList (lawdCd=${lawdCd}, dealYmd=${dealYmd})"
        )

        return monoHouseTradeSearchPort.search(
            lawdCd = lawdCd,
            dealYmd = dealYmd,
        ).map { it.toVO() }
    }
}