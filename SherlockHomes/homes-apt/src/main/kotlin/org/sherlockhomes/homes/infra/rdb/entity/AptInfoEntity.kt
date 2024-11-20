//package org.sherlockhomes.homes.infra.rdb.entity
//
//import jakarta.persistence.*
//
//@Entity
//@Table(catalog = "apt", name = "houseinfos")
//open class AptInfoEntity(
//    aptSeq: String? = null,
//    sggCd: String? = null,
//    umdCd: String? = null,
//    umdNm: String? = null,
//    jibun: String? = null,
//    roadNmSggCd: String? = null,
//    roadNm: String? = null,
//    roadNmBonbun: String? = null,
//    roadNmBubun: String? = null,
//    aptNm: String? = null,
//    buildYear: String? = null,
//    latitude: String? = null,
//    longitude: String? = null,
//) {
//    @Id
//    open var aptSeq = aptSeq
//        protected set
//
//    open var sggCd = sggCd
//        protected set
//
//    open var umdCd = umdCd
//        protected set
//
//    open var umdNm = umdNm
//        protected set
//
//    open var jibun = jibun
//        protected set
//
//    open var roadNmSggCd = roadNmSggCd
//        protected set
//
//    open var roadNm = roadNm
//        protected set
//
//    open var roadNmBonbun = roadNmBonbun
//        protected set
//
//    open var roadNmBubun = roadNmBubun
//        protected set
//
//    open var aptNm = aptNm
//        protected set
//
//    open var buildYear = buildYear
//        protected set
//
//    open var latitude = latitude
//        protected set
//
//    open var longitude = longitude
//        protected set
//}