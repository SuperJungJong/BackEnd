package org.sherlockhomes.homes.infra.rdb.entity

import jakarta.persistence.*

@Entity
@Table(catalog = "map", name = "gu")
open class GuEntity(
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