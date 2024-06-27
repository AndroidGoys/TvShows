package com.limelist.tvHistory.domain.models

import kotlinx.serialization.Serializable

@Serializable
class TvShowDates (
    val startTime: Int,
    val endTime: Int
)