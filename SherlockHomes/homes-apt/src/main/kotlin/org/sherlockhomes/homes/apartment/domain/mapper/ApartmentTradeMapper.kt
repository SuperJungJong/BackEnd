package org.sherlockhomes.homes.apartment.domain.mapper

import org.sherlockhomes.homes.apartment.application.service.rent.vo.ApartmentTradeVO
import org.sherlockhomes.homes.apartment.domain.ApartmentTrade

fun ApartmentTrade.toVO(): ApartmentTradeVO.ApartmentTrade =
    ApartmentTradeVO.ApartmentTrade(
        aptDong = aptDong,
        aptNm = aptNm,
        aptSeq = aptSeq,
        bonbun = bonbun,
        bubun = bubun,
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
        excluUseAr = excluUseAr,
        floor = floor,
        jibun = jibun,
        landCd = landCd,
        landLeaseholdGbn = landLeaseholdGbn,
        rgstDate = rgstDate,
        roadNm = roadNm,
        roadNmBonbun = roadNmBonbun,
        roadNmBubun = roadNmBubun,
        roadNmCd = roadNmCd,
        roadNmSeq = roadNmSeq,
        roadNmSggCd = roadNmSggCd,
        roadNmbCd = roadNmbCd,
        sggCd = sggCd,
        slerGbn = slerGbn,
        umdCd = umdCd,
        umdNm = umdNm,
    )
