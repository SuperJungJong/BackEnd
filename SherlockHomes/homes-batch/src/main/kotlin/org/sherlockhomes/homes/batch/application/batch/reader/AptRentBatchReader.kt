package org.sherlockhomes.homes.batch.application.batch.reader

import org.sherlockhomes.homes.batch.application.port.outbound.SearchAptRentQueryPort
import org.sherlockhomes.homes.batch.domain.AptRent
import org.springframework.batch.item.ExecutionContext
import org.springframework.batch.item.ItemStreamException
import org.springframework.batch.item.ItemStreamReader
import org.springframework.stereotype.Component


@Component
class AptRentBatchReader(
    private val aptRentQueryPort: SearchAptRentQueryPort,
) : ItemStreamReader<AptRent> {

    private var currentId = 0
    private var offset = 0
    private var lawdCdList = arrayListOf(
        "11530",
        "51110",
    )
    private var cur_idx = 0
    private var max_idx = lawdCdList.size

    private val CURRENT_ID_KEY = "batch.apt.rent.id"
    var aptRentList: List<AptRent> = ArrayList()
    var dealYm: Int = 0

    override fun open(executionContext: ExecutionContext) {

        if (cur_idx >= max_idx) throw ItemStreamException("out bound lawdCdList")
        if (dealYm == 0) dealYm = executionContext.getString("dealYm").toInt()

        aptRentList = aptRentQueryPort.searchAptRent(
            lawdCdList[cur_idx].toInt(),
            dealYm
        )

        offset = aptRentList.size
        if (executionContext.containsKey(CURRENT_ID_KEY)) {
            currentId = executionContext.getInt(CURRENT_ID_KEY)
        }
    }

    override fun read(): AptRent? {
        if (currentId >= offset) {
            cur_idx++
            if (cur_idx >= max_idx) return null
            open(ExecutionContext())
            currentId = 0
        }

        val get = aptRentList.get(currentId)
        currentId++

        return get
    }

    override fun update(executionContext: ExecutionContext) {
        executionContext.putInt(CURRENT_ID_KEY, currentId)
    }

}