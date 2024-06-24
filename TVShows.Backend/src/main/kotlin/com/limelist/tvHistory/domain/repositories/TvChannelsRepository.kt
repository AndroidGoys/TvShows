package com.limelist.tvHistory.domain.repositories

import com.limelist.tvHistory.domain.models.channels.TvChannelFullModel
import com.limelist.tvHistory.domain.models.channels.TvChannelModel

interface TvChannelsRepository : Repository {
    suspend fun getAllChannels(limit: Int?, offset: Int, playlistLimit:Int?): Iterable<TvChannelModel>
    suspend fun getChannelDetails(id: Int): TvChannelFullModel?
}