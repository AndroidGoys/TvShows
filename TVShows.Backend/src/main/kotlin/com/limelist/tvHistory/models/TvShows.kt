package com.limelist.tvHistory.models

import com.limelist.tvHistory.models.shows.TvShowModel
import kotlinx.serialization.Serializable

@Serializable
data class TvShows (
    val leftAmount: Int,
    val shows: Iterable<TvShowModel>,
)