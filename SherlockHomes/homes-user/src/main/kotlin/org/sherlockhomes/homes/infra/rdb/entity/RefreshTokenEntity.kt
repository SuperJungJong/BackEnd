package org.sherlockhomes.homes.infra.rdb.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
import java.time.ZoneId

@Entity
@Table(schema = "user", name = "refresh_token")
open class RefreshTokenEntity(
    id: Long? = null,
    userId: Long,
    ci: String,
    refreshToken: String,
    createdAt: LocalDateTime? = LocalDateTime.now(ZoneId.of("Asia/Seoul")),
    modifiedAt: LocalDateTime? = LocalDateTime.now(ZoneId.of("Asia/Seoul")),
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Long? = id
        protected set

    open var userId: Long = userId
        protected set

    open var ci: String = ci
        protected set

    open var refreshToken: String = refreshToken
        protected set

    @CreatedDate
    open var createdAt: LocalDateTime? = createdAt
        protected set

    @LastModifiedDate
    open var modifiedAt: LocalDateTime? = modifiedAt
        protected set

    fun update(userId: Long, refreshToken: String): RefreshTokenEntity {
        this.userId = userId
        this.refreshToken = refreshToken

        return this
    }
}