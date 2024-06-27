package com.limelist.tvHistory.domain.models.channels

import kotlinx.serialization.Serializable

@Serializable
data class TvChannelFullModel(
    val id: Int,
    val name: String,
    val description: String,
    val channelViewUrls: Iterable<String>
)