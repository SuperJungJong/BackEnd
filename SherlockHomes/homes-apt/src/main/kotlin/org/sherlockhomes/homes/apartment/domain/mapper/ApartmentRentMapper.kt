package org.sherlockhomes.homes.apartment.domain.mapper

import org.sherlockhomes.homes.apartment.application.service.rent.vo.ApartmentRentVO
import org.sherlockhomes.homes.apartment.domain.ApartmentRent


fun ApartmentRent.toVO(): ApartmentRentVO.ApartmentRent =
    ApartmentRentVO.ApartmentRent(
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
