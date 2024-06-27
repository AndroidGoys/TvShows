package com.limelist.tvHistory.domain.models

import kotlinx.serialization.Serializable

@Serializable
class TvShowDates (
    val index: Int,
    val startTime: Int,
    val endTime: Int
)