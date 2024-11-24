package org.sherlockhomes.homes.batch.application.batch.reader

import org.sherloc.GuCode
import org.sherlockhomes.homes.batch.application.port.outbound.SearchMonoTradeQueryPort
import org.sherlockhomes.homes.batch.domain.MonoTrade
import org.springframework.batch.item.ExecutionContext
import org.springframework.batch.item.ItemStreamException
import org.springframework.batch.item.ItemStreamReader
import org.springframework.stereotype.Component


@Component
class MonoTradeBatchReader(
    private val monoTradeQueryPort: SearchMonoTradeQueryPort,
) : ItemStreamReader<MonoTrade> {

    private var currentId = 0
    private var offset = 0
    private var lawdCdList = GuCode.dongList
    private var cur_idx = 0
    private var max_idx = lawdCdList.size

    private val CURRENT_ID_KEY = "batch.mono.trade.id"
    var monoTradeList: List<MonoTrade> = ArrayList()
    var dealYm: Int = 0

    override fun open(executionContext: ExecutionContext) {

        if (cur_idx >= max_idx) throw ItemStreamException("out bound lawdCdList")
        if (dealYm == 0) dealYm = executionContext.getString("dealYm").toInt()

        try {
            monoTradeList = monoTradeQueryPort.searchMonoTrade(
                lawdCdList[cur_idx].toInt(),
                dealYm
            )
        } catch (e: Exception) {
            println(e)
        }

        offset = monoTradeList.size
        if (executionContext.containsKey(CURRENT_ID_KEY)) {
            currentId = executionContext.getInt(CURRENT_ID_KEY)
        }
    }

    override fun read(): MonoTrade? {
        if (currentId >= offset) {
            cur_idx++
            if (cur_idx >= max_idx) return null
            println("asssssssssssssssssssss")
            open(ExecutionContext())
            currentId = 0
        }

        val get = monoTradeList.get(currentId)
        println("get.jibun = ${get.jibun}")
        currentId++

        return get
    }

    override fun update(executionContext: ExecutionContext) {
        executionContext.putInt(CURRENT_ID_KEY, currentId)
    }

}