package org.sherlockhomes.homes.user.application.service.user

import org.sherlockhomes.homes.user.application.port.inbound.UserQuery
import org.sherlockhomes.homes.user.application.port.outbound.UserQueryPort
import org.sherlockhomes.homes.user.application.service.user.VO.UserVO
import org.sherlockhomes.homes.user.domain.mapper.toVO
import org.springframework.stereotype.Service

@Service
class UserReader(
    private val userQueryPort: UserQueryPort
) : UserQuery {

    override fun getUser(userId: Long): UserVO.User =
        userQueryPort.findById(userId).toVO()

}