package org.sherlockhomes.homes.apartment.adaptor.inbound.api.mapper

import org.sherlockhomes.homes.apartment.adaptor.inbound.api.dto.AptTradeResponse
import org.sherlockhomes.homes.apartment.application.service.vo.trade.AptTradeVO

fun AptTradeVO.AptTrade.toResponse() =
    AptTradeResponse.Response(
        sgg = sgg,
        si = si,
        gu = gu,
        dong = dong,
        jibun = jibun,
        aptNm = aptNm,
        exduUseAr = exduUseAr,
        dealY = dealY,
        dealM = dealM,
        dealD = dealD,
        dealAmount = dealAmount,
        floor = floor,
        buildYear = buildYear,
        roadNm = roadNm,
    )