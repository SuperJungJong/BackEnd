package org.sherlockhomes.homes.apartment.domain

class ListPage<T>(
    val items: List<T>,
    val totalPage: Int,
    val total: Long,
)