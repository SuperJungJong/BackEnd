package org.sherlockhomes.homes.infra.rdb.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
open class AptTradeEntity(
    no: Long?,
    sgg: String,
    si: String,
    gu: String,
    dong: String,
    jibun: String,
    aptNm: String?,
    exduUseAr: Double,
    dealY: String?,
    dealM: String?,
    dealD: String?,
    dealAmount: String,
    aptDong: String,
    floor: String,
    buy: String,
    seller: String,
    buildYear: String,
    roadNm: String,
    specialDay: String,
    type: String,
    middleAddr: String,
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

    var jibun = jibun
        protected set

    open var aptNm = aptNm
        protected set

    open var exduUseAr = exduUseAr
        protected set

    open var dealY = dealY
        protected set

    open var dealM = dealM
        protected set

    open var dealD = dealD
        protected set

    open var dealAmount = dealAmount
        protected set

    open var aptDong = aptDong
        protected set

    open var floor = floor
        protected set

    open var buy = buy
        protected set

    open var seller = seller
        protected set

    open var buildYear = buildYear
        protected set

    open var roadNm = roadNm
        protected set

    open var specialDay = specialDay
        protected set

    open var type = type
        protected set

    open var middleAddr = middleAddr
        protected set

}