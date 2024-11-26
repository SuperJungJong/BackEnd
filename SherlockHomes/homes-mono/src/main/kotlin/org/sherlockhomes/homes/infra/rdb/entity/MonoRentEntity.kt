package org.sherlockhomes.homes.infra.rdb.entity

import jakarta.persistence.*

@Entity
@Table(catalog = "mono", name = "mono_rent")
open class MonoRentEntity(
    no: Long? = null,
    sgg: String? = "-",
    si: String? = "-",
    gu: String? = "-",
    dong: String? = "-",
    buildYear: Int? = 0,
    contractTerm: String? = "-",
    contractType: String? = "-",
    dealDay: Int? = 0,
    dealMonth: Int? = 0,
    dealYear: Int? = 0,
    deposit: String? = "-",
    houseType: String? = "-",
    monthlyRent: Int? = 0,
    preDeposit: String? = "-",
    preMonthlyRent: String? = "-",
    sggCd: String? = "-",
    totalFloorAr: Double? = 0.0,
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

    open var houseType = houseType
        protected set

    open var monthlyRent = monthlyRent
        protected set

    open var preDeposit = preDeposit
        protected set

    open var preMonthlyRent = preMonthlyRent
        protected set

    open var sggCd = sggCd
        protected set

    open var totalFloorAr = totalFloorAr
        protected set

    open var umdNm = umdNm
        protected set

    open var useRRRight = useRRRight
        protected set

}