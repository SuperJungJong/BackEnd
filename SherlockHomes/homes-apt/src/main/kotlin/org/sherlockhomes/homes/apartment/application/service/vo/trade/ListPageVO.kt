package org.sherlockhomes.homes.apartment.application.service.vo.trade

class ListPageVO<T>(
    val items: List<T>,
    val totalPage: Int,
    val total: Long,
)