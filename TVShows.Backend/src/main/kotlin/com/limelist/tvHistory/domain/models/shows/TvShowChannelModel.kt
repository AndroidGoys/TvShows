package com.limelist.tvHistory.domain.models.shows

import com.limelist.tvHistory.domain.models.TvShowDates
import com.limelist.tvHistory.domain.models.channels.TvChannelShowModel

class TvShowChannelModel (
    val id: Int,
    val name: String,
    val showDates: Iterable<TvShowDates>
)