package org.sherlockhomes.homes.infra.webclient.mapper

import org.sherlockhomes.homes.apartment.domain.ApartmentTrade
import org.sherlockhomes.homes.infra.webclient.VO.ApartmentTradeSearchVO

fun ApartmentTradeSearchVO.ResponseResults.toDomain(
): List<ApartmentTrade> =
    response.body.items.item.map {
        it.toDomain()
    }


fun ApartmentTradeSearchVO.Item.toDomain(
): ApartmentTrade = ApartmentTrade(
    aptDong =aptDong,
    aptNm =aptNm,
    aptSeq =aptSeq,
    bonbun =bonbun,
    bubun =bubun,
    buildYear =buildYear,
    buyerGbn =buyerGbn,
    cdealDay =cdealDay,
    cdealType =cdealType,
    dealAmount =dealAmount,
    dealDay =dealDay,
    dealMonth =dealMonth,
    dealYear =dealYear,
    dealingGbn =dealingGbn,
    estateAgentSggNm =estateAgentSggNm,
    excluUseAr =excluUseAr,
    floor =floor,
    jibun =jibun,
    landCd =landCd,
    landLeaseholdGbn =landLeaseholdGbn,
    rgstDate =rgstDate,
    roadNm =roadNm,
    roadNmBonbun =roadNmBonbun,
    roadNmBubun =roadNmBubun,
    roadNmCd =roadNmCd,
    roadNmSeq =roadNmSeq,
    roadNmSggCd =roadNmSggCd,
    roadNmbCd =roadNmbCd,
    sggCd =sggCd,
    slerGbn = slerGbn,
    umdCd =umdCd,
    umdNm =umdNm,
)
