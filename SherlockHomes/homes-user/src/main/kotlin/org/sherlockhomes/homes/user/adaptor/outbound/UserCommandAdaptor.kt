package org.sherlockhomes.homes.user.adaptor.outbound

import org.sherlockhomes.homes.infra.rdb.repository.UserRepository
import org.sherlockhomes.homes.user.application.port.outbound.UserCommandPort
import org.sherlockhomes.homes.user.application.port.outbound.UserQueryPort
import org.sherlockhomes.homes.user.domain.User
import org.sherlockhomes.homes.user.domain.mapper.toDomain
import org.sherlockhomes.homes.user.domain.mapper.toEntity
import org.springframework.stereotype.Component
import kotlin.jvm.optionals.getOrElse

@Component
class UserCommandAdaptor(
    private val userRepository: UserRepository,
) : UserCommandPort {

    override fun save(user: User): Long =
        userRepository.save(user.toEntity()).id!!

}