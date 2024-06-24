package com.limelist.tvHistory.domain.models.shows

import com.limelist.tvHistory.domain.models.channels.TvChannelModel
import kotlinx.serialization.Serializable

@Serializable
class TvShowModel (
    val id: Int,
    val name: String,
    val channels: Iterable<TvChannelModel>
)