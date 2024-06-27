package com.limelist.tvHistory.models.shows

import com.limelist.tvHistory.models.TvShowDates

class TvShowChannelModel (
    val id: Int,
    val name: String,
    val showDates: Iterable<TvShowDates>
)