package org.sherlockhomes.homes.infra.rdb.entity

import jakarta.persistence.*

@Entity
@Table(catalog = "map", name = "do")
open class SiEntity(
    id: Long? = null,
    code: String,
    name: String
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Long? = id
        protected set

    open var code: String = code
        protected set

    open var name: String = name
        protected set

    protected constructor() : this(null, "", "")
}