package org.sherlockhomes.homes.apartment.domain.mapper

import org.sherlockhomes.homes.apartment.application.service.vo.trade.AptTradeVO
import org.sherlockhomes.homes.apartment.domain.AptTrade
import org.sherlockhomes.homes.infra.rdb.entity.AptTradeEntity

fun AptTradeEntity.toDomain(): AptTrade =
    AptTrade(
        no = no,
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
        aptDong = aptDong,
        floor = floor,
        buy = buy,
        seller = seller,
        buildYear = buildYear,
        roadNm = roadNm,
        specialDay = specialDay,
        type = type,
        middleAddr = middleAddr,
    )

fun AptTrade.toVO(): AptTradeVO.AptTrade =
    AptTradeVO.AptTrade(
        no = no,
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
        aptDong = aptDong,
        floor = floor,
        buy = buy,
        seller = seller,
        buildYear = buildYear,
        roadNm = roadNm,
        specialDay = specialDay,
        type = type,
        middleAddr = middleAddr,
    )