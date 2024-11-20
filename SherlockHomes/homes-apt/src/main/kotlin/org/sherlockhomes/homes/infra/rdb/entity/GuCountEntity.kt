package org.sherlockhomes.homes.infra.rdb.entity

import jakarta.persistence.*

@Entity
@Table(catalog = "apt", name = "gu_count")
open class GuCountEntity(
    id: Long,
    siName: String,
    guName: String,
    count: Int,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Long = id
        protected set

    open var siName: String = siName
        protected set

    open var guName: String = guName
        protected set

    open var count: Int = count
        protected set
}