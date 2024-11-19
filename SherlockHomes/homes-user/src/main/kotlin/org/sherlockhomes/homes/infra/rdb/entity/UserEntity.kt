package org.sherlockhomes.homes.infra.rdb.entity

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
import java.time.ZoneId

@Entity
@Table(schema = "user", name = "user")
open class UserEntity(
    id: Long? = null,
    nickname: String,
    method: String,
    ci: String,
    image: ByteArray?,
    role: Int?,
    registeredAt: LocalDateTime? = LocalDateTime.now(ZoneId.of("Asia/Seoul")),
    modifiedAt: LocalDateTime? = LocalDateTime.now(ZoneId.of("Asia/Seoul")),
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Long? = id
        protected set

    open var nickname: String = nickname
        protected set

    open var method: String = method
        protected set

    open var ci: String = ci
        protected set

    open var image: ByteArray? = image
        protected set

    open var role: Int? = role
        protected set

    @CreatedDate
    open var registeredAt: LocalDateTime? = registeredAt
        protected set

    @LastModifiedDate
    open var modifiedAt: LocalDateTime? = modifiedAt
        protected set
}