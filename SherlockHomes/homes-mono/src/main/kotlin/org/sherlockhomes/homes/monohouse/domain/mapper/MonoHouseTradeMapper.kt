package org.sherlockhomes.homes.monohouse.domain.mapper

import org.sherlockhomes.homes.infra.rdb.entity.MonoTradeEntity
import org.sherlockhomes.homes.monohouse.application.service.trade.vo.MonoHouseTradeVO
import org.sherlockhomes.homes.monohouse.domain.MonoHouseTrade

fun MonoHouseTrade.toVO(): MonoHouseTradeVO.MonoHouseTrade =
    MonoHouseTradeVO.MonoHouseTrade(
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
        sgg = sgg,
        si = si,
        gu = gu,
        dong = dong,
    )

fun MonoTradeEntity.toDomain() =
    MonoHouseTrade(
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
        sgg = sgg,
        si = si,
        gu = gu,
        dong = dong,
    )