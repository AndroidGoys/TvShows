package com.limelist.tvHistory.models.channels

import kotlinx.serialization.Serializable

@Serializable
data class TvChannelModel(
    val id: Int,
    val name: String,
    val shows: Iterable<TvChannelShowModel>
)