package org.sherlockhomes.homes.infra.rdb.entity

import jakarta.persistence.*


@Entity
@Table(catalog = "mono", name = "mono_trade")
open class MonoTradeEntity(
    no: Long? = null,
    sgg: String? = "-",
    si: String? = "-",
    gu: String? = "-",
    dong: String? = "-",
    buildYear: String? = "-",
    buyerGbn: String? = null,
    cdealDay: String? = null,
    cdealType: String? = null,
    dealAmount: String? = "-",
    dealDay: Int? = 0,
    dealMonth: Int? = 0,
    dealYear: Int? = 0,
    dealingGbn: String? = null,
    estateAgentSggNm: String? = null,
    houseType: String? = null,
    jibun: String? = null,
    plottageAr: Double? = 0.0,
    sggCd: Int? = 0,
    slerGbn: String? = null,
    totalFloorAr: Double? = null,
    umdNm: String? = "-",
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

    open var buyerGbn = buyerGbn
        protected set

    open var cdealDay = cdealDay
        protected set

    open var cdealType = cdealType
        protected set

    open var dealAmount = dealAmount
        protected set

    open var dealDay = dealDay
        protected set

    open var dealMonth = dealMonth
        protected set

    open var dealYear = dealYear
        protected set

    open var dealingGbn = dealingGbn
        protected set

    open var estateAgentSggNm = estateAgentSggNm
        protected set

    open var houseType = houseType
        protected set

    open var jibun = jibun
        protected set

    open var plottageAr = plottageAr
        protected set

    open var sggCd = sggCd
        protected set

    open var slerGbn = slerGbn
        protected set

    open var totalFloorAr = totalFloorAr
        protected set

    open var umdNm = umdNm
        protected set

}