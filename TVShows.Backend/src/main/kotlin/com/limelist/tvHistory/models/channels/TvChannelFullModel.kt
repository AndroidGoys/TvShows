package com.limelist.tvHistory.models.channels

import kotlinx.serialization.Serializable

@Serializable
data class TvChannelFullModel(
    val id: Int,
    val name: String,
    val description: String,
    val channelViewUrls: Iterable<String>
)