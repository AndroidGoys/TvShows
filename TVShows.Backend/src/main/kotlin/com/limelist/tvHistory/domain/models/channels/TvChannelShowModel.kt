package com.limelist.tvHistory.domain.models.channels

import com.limelist.tvHistory.domain.models.TvShowDates
import kotlinx.serialization.Serializable

@Serializable
data class TvChannelShowModel (
    val id: Int,
    val name: String,
    val previewUrl: String,
    val dates: Iterable<TvShowDates>
)