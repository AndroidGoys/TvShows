package com.limelist.tvHistory.domain.models

import com.limelist.tvHistory.domain.models.shows.TvShowModel
import kotlinx.serialization.Serializable

@Serializable
data class TvShows (
    val leftAmount: Int,
    val shows: Iterable<TvShowModel>,
)