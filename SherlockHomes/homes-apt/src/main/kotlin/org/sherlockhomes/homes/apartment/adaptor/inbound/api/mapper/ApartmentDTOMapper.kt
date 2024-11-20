package org.sherlockhomes.homes.apartment.adaptor.inbound.api.mapper

import org.sherlockhomes.homes.apartment.adaptor.inbound.api.dto.ApartmentRequestDTO
import org.sherlockhomes.homes.apartment.adaptor.inbound.api.dto.ApartmentResponseDTO
import org.sherlockhomes.homes.apartment.application.service.vo.rent.ApartmentRentVO
import org.sherlockhomes.homes.apartment.application.service.vo.trade.ApartmentTradeVO

fun ApartmentRequestDTO.SearchRent.toVO(

) {

}

fun ApartmentRequestDTO.SearchTrade.toVO(

) {

}

fun ApartmentRentVO.ApartmentRent.toResponse(): ApartmentResponseDTO.RentResponse =
    ApartmentResponseDTO.RentResponse(
        aptNm = aptNm,
        buildYear = buildYear,
        contractTerm = contractTerm,
        contractType = contractType,
        dealDay = dealDay,
        dealMonth = dealMonth,
        dealYear = dealYear,
        deposit = deposit,
        excluUseAr = excluUseAr,
        floor = floor,
        jibun = jibun,
        monthlyRent = monthlyRent,
        preDeposit = preDeposit,
        preMonthlyRent = preMonthlyRent,
        sggCd = sggCd,
        umdNm = umdNm,
        useRRRight = useRRRight,
    )

fun ApartmentTradeVO.ApartmentTrade.toResponse(): ApartmentResponseDTO.TradeResponse =
    ApartmentResponseDTO.TradeResponse(
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