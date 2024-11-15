package org.sherlockhomes.homes.apartment.application.service.trade

import org.sherlockhomes.homes.apartment.application.port.inbound.ApartmentSearchUseCase
import org.sherlockhomes.homes.apartment.application.port.outbound.ApartmentSearchPort
import org.sherlockhomes.homes.apartment.application.service.trade.vo.ApartmentTradeVO
import org.sherlockhomes.homes.apartment.domain.ApartmentTrade
import org.sherlockhomes.homes.apartment.domain.mapper.toVO
import org.springframework.stereotype.Component

@Component
class ApartmentTradeSearchService(
    private val apartmentTradeSearchPort: ApartmentSearchPort<ApartmentTrade>
) : ApartmentSearchUseCase<ApartmentTradeVO.ApartmentTrade> {

    override fun getList(lawdCd: Int, dealYmd: Int): List<ApartmentTradeVO.ApartmentTrade> =
        apartmentTradeSearchPort.search(
            lawdCd = lawdCd,
            dealYmd = dealYmd,
        ). map { it.toVO() }
}