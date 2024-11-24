package org.sherlockhomes.homes.infra.rdb.entity.apt

import jakarta.persistence.*

@Entity
@Table(catalog = "apt", name = "apt_rent")
open class AptRentEntity(
    no: Long? = null,
    sgg: String? = "-",
    si: String? = "-",
    gu: String? = "-",
    dong: String? = "-",
    aptNm: String? = "-",
    buildYear: Int? = 0,
    contractTerm: String? = "-",
    contractType: String? = "-",
    dealDay: Int? = 0,
    dealMonth: Int? = 0,
    dealYear: Int? = 0,
    deposit: String? = "-",
    excluUseAr: Double? = 0.0,
    floor: Int? = 0,
    jibun: String? = "-",
    monthlyRent: Int? = 0,
    preDeposit: String? = "-",
    preMonthlyRent: Int? = 0,
    sggCd: Int? = 0,
    umdNm: String? = "-",
    useRRRight: String? = "-",
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var no = no
        protected set
    open var sgg = sgg
        protected set

    open var si = si
        protected set

    open var gu = gu
        protected set

    open var dong = dong
        protected set
    open var aptNm = aptNm
        protected set

    open var buildYear = buildYear
        protected set

    open var contractTerm = contractTerm
        protected set

    open var contractType = contractType
        protected set

    open var dealDay = dealDay
        protected set

    open var dealMonth = dealMonth
        protected set

    open var dealYear = dealYear
        protected set

    open var deposit = deposit
        protected set

    open var excluUseAr = excluUseAr
        protected set

    open var floor = floor
        protected set

    open var jibun = jibun
        protected set

    open var monthlyRent = monthlyRent
        protected set

    open var preDeposit = preDeposit
        protected set

    open var preMonthlyRent = preMonthlyRent
        protected set

    open var sggCd = sggCd
        protected set

    open var umdNm = umdNm
        protected set

    open var useRRRight = useRRRight
        protected set


}