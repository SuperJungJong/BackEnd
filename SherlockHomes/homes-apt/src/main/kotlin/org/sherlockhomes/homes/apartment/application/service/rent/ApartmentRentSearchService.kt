package org.sherlockhomes.homes.apartment.application.service.rent

import org.sherlockhomes.homes.apartment.application.port.inbound.ApartmentSearchUseCase
import org.sherlockhomes.homes.apartment.application.port.outbound.ApartmentSearchPort
import org.sherlockhomes.homes.apartment.application.service.vo.rent.ApartmentRentVO
import org.sherlockhomes.homes.apartment.domain.ApartmentRent
import org.sherlockhomes.homes.apartment.domain.mapper.toVO
import org.springframework.stereotype.Component

@Component
class ApartmentRentSearchService(
    private val apartmentRentSearchPort: ApartmentSearchPort<ApartmentRent>
) : ApartmentSearchUseCase<ApartmentRentVO.ApartmentRent> {

    override fun getList(lawdCd: Int, dealYmd: Int): List<ApartmentRentVO.ApartmentRent> =
        apartmentRentSearchPort.search(
            lawdCd = lawdCd,
            dealYmd = dealYmd,
        ).map { it.toVO() }
}