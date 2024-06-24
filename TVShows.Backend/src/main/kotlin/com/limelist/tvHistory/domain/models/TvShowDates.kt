package com.limelist.tvHistory.domain.models

import kotlinx.serialization.Serializable

@Serializable
class TvShowDates (
    val startTIme: Int,
    val endTIme: Int
)