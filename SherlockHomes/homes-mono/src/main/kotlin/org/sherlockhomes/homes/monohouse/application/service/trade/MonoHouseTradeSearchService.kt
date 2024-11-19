package org.sherlockhomes.homes.monohouse.application.service.trade

import org.sherlockhomes.homes.monohouse.application.port.inbound.MonoHouseSearchUseCase
import org.sherlockhomes.homes.monohouse.application.port.outbound.MonoHouseSearchPort
import org.sherlockhomes.homes.monohouse.domain.mapper.toVO
import org.sherlockhomes.homes.monohouse.application.service.trade.vo.MonoHouseTradeVO
import org.sherlockhomes.homes.monohouse.domain.MonoHouseTrade
import org.springframework.stereotype.Component

@Component
class MonoHouseTradeSearchService(
    private val monoHouseTradeSearchPort: MonoHouseSearchPort<MonoHouseTrade>
) : MonoHouseSearchUseCase<MonoHouseTradeVO.MonoHouseTrade> {

    override fun getList(lawdCd: Int, dealYmd: Int): List<MonoHouseTradeVO.MonoHouseTrade> =
        monoHouseTradeSearchPort.search(
            lawdCd = lawdCd,
            dealYmd = dealYmd,
        ).map { it.toVO() }
}