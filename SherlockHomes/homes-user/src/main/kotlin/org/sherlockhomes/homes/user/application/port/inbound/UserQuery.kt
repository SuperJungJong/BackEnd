package org.sherlockhomes.homes.user.application.port.inbound

import org.sherlockhomes.homes.user.application.service.user.VO.UserVO

interface UserQuery {

    fun getUser(userId: Long): UserVO.User
}