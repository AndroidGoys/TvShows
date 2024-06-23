package com.limelist.tvHistory

import com.limelist.tvHistory.services.TvService
import io.ktor.server.application.*

data class TvHistoryServices (
    val TvService: TvService
)