package org.sherlockhomes.homes.infra.rdb.entity

import jakarta.persistence.*

@Entity
@Table(catalog = "map", name = "dongcodes")
open class DongCodeEntity(
    dongCode: String,
    sidoName: String,
    gugunName: String? = " ",
    dongName: String? = " ",
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var dongCode: String? = dongCode
        protected set

    open var sidoName: String? = sidoName
        protected set

    open var gugunName: String? = gugunName
        protected set

    open var dongName: String? = dongName
        protected set
}