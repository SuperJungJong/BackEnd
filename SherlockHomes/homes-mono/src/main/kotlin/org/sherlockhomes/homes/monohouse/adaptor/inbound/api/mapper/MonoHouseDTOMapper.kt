package org.sherlockhomes.homes.monohouse.adaptor.inbound.api.mapper

import org.sherlockhomes.homes.monohouse.adaptor.inbound.api.dto.MonoHouseRequestDTO
import org.sherlockhomes.homes.monohouse.application.service.rent.vo.MonoHouseRentVO
import org.sherlockhomes.homes.monohouse.adaptor.inbound.api.dto.MonoHouseResponseDTO
import org.sherlockhomes.homes.monohouse.application.service.trade.vo.MonoHouseTradeVO


fun MonoHouseRequestDTO.SearchRent.toVO(

) {

}

fun MonoHouseRequestDTO.SearchTrade.toVO(

) {

}

fun MonoHouseTradeVO.MonoHouseTrade.toResponse(): MonoHouseResponseDTO.TradeResponse =
    MonoHouseResponseDTO.TradeResponse(
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

fun MonoHouseRentVO.MonoHouseRent.toResponse(): MonoHouseResponseDTO.RentResponse =
    MonoHouseResponseDTO.RentResponse(
        buildYear = buildYear,
        contractTerm = contractTerm,
        contractType = contractType,
        dealDay = dealDay,
        dealMonth = dealMonth,
        dealYear = dealYear,
        deposit = deposit,
        houseType = houseType,
        monthlyRent = monthlyRent,
        preDeposit = preDeposit,
        preMonthlyRent = preMonthlyRent,
        sggCd = sggCd,
        totalFloorAr = totalFloorAr,
        umdNm = umdNm,
        useRRRight = useRRRight,
    )