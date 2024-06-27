package com.limelist.tvHistory.domain.models.shows

import com.limelist.tvHistory.domain.models.channels.TvChannelModel
import jdk.jfr.Description
import kotlinx.serialization.Serializable

@Serializable
class TvShowFullModel (
    val id: Int,
    val name: String,
    val description: String,
    val previewUrl: String,
)