package com.limelist.tvHistory.domain.models

import kotlinx.serialization.Serializable

import com.limelist.tvHistory.domain.models.channels.TvChannelModel

@Serializable
data class TvChannels (
    val leftAmount: Int,
    val channels: Iterable<TvChannelModel>,
)