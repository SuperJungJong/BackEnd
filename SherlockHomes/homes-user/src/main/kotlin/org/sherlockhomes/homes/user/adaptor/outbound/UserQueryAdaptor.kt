package org.sherlockhomes.homes.user.adaptor.outbound

import org.sherlockhomes.homes.infra.rdb.repository.UserRepository
import org.sherlockhomes.homes.user.application.port.outbound.UserQueryPort
import org.sherlockhomes.homes.user.domain.User
import org.sherlockhomes.homes.user.domain.mapper.toDomain
import org.springframework.stereotype.Component
import kotlin.jvm.optionals.getOrElse

@Component
class UserQueryAdaptor(
    private val userRepository: UserRepository,
) : UserQueryPort {

    override fun findById(userId: Long): User =
        userRepository.findById(userId)
            .orElseThrow()
            .toDomain()

    override fun findByCi(ci: String): User =
        userRepository.findByCi(ci)
            .toDomain()
}