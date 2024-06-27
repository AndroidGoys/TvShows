package com.limelist.tvHistory.dataAccess.interfaces

import com.limelist.tvHistory.models.channels.TvChannelFullModel
import com.limelist.tvHistory.models.channels.TvChannelModel

interface TvChannelsRepository : TvRepository {
    suspend fun getAllChannels(limit: Int?, offset: Int, playlistLimit:Int?): Iterable<TvChannelModel>
    suspend fun getChannelDetails(id: Int): TvChannelFullModel?
}