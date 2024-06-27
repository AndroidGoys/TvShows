package com.limelist.tvHistory.models.channels

import com.limelist.tvHistory.models.TvShowDates
import kotlinx.serialization.Serializable

@Serializable
data class TvChannelShowModel (
    val id: Int,
    val name: String,
    val previewUrl: String,
    val dates: Iterable<TvShowDates>
)