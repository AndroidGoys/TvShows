package com.limelist.tvHistory.models

import kotlinx.serialization.Serializable

import com.limelist.tvHistory.models.channels.TvChannelModel

@Serializable
data class TvChannels (
    val leftAmount: Int,
    val channels: Iterable<TvChannelModel>,
)