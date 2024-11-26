package org.sherlockhomes.homes.user.application.service.user

import org.sherlockhomes.homes.user.application.port.inbound.UserQuery
import org.sherlockhomes.homes.user.application.port.outbound.UserQueryPort
import org.sherlockhomes.homes.user.application.service.user.VO.UserVO
import org.sherlockhomes.homes.user.domain.mapper.toVO
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class UserReader(
    private val userQueryPort: UserQueryPort,
    private val kafkaTemplate: KafkaTemplate<String, String>
) : UserQuery {

    override fun getUser(userId: Long): UserVO.User {
        kafkaTemplate.send(
            "user-log",
            "[user][service] UserReader.getUser"
        )
        kafkaTemplate.send(
            "all-log",
            "[user][service] UserReader.getUser"
        )

        return userQueryPort.findById(userId).toVO()
    }
}