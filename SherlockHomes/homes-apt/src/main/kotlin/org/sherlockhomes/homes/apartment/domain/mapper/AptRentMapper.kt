package org.sherlockhomes.homes.apartment.domain.mapper

import org.sherlockhomes.homes.apartment.application.service.vo.rent.AptRentVO
import org.sherlockhomes.homes.apartment.domain.AptRent
import org.sherlockhomes.homes.infra.rdb.entity.AptRentEntity

fun AptRentEntity.toDomain() =
    AptRent(
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
        sgg = sgg,
        si = si,
        gu = gu,
        dong = dong,
    )

fun AptRent.toVO(): AptRentVO.ApartmentRent =
    AptRentVO.ApartmentRent(
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
