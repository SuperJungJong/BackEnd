package org.sherlockhomes.homes.infra.webclient.mapper

import org.sherlockhomes.homes.infra.webclient.VO.MonoHouseTradeSearchVO
import org.sherlockhomes.homes.monohouse.domain.MonoHouseTrade

fun MonoHouseTradeSearchVO.ResponseResults.toDomain(
): List<MonoHouseTrade> =
    response.body.items.item.map {
        it.toDomain()
    }


fun MonoHouseTradeSearchVO.Item.toDomain(
): MonoHouseTrade = MonoHouseTrade(
    buildYear = buildYear,
    buyerGbn = buyerGbn,
    cdealDay = cdealDay,
    cdealType = cdealType,
    dealAmount = dealAmount,
    dealDay = dealDay,
    dealMonth = dealMonth,
    dealYear = dealYear,
    dealingGbn = dealingGbn,
    estateAgentSggNm = estateAgentSggNm,
    houseType = houseType,
    jibun = jibun,
    plottageAr = plottageAr,
    sggCd = sggCd,
    slerGbn = slerGbn,
    totalFloorAr = totalFloorAr,
    umdNm = umdNm,
)
