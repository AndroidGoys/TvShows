package com.limelist.tvHistory.models.shows

import kotlinx.serialization.Serializable

@Serializable
class TvShowFullModel (
    val id: Int,
    val name: String,
    val description: String,
    val previewUrl: String,
)