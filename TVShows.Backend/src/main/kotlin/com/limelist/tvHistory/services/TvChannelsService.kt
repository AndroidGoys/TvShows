package com.limelist.tvHistory.services

import com.limelist.tvHistory.dataAccess.interfaces.TvChannelsRepository
import com.limelist.tvHistory.models.TvChannels
import com.limelist.tvHistory.models.channels.TvChannelFullModel

class TvChannelsService (
    private val tvChannels: TvChannelsRepository
){
    suspend fun getAllChannels(limit: Int?, offset: Int?, playlistLimit:Int?): TvChannels {
        val offset = offset ?: 0;
        val channels = tvChannels.getAllChannels(limit, offset, playlistLimit)
        val totalCount = tvChannels.count();

        val leftAmount = Math.max(totalCount - channels.count() - offset , 0)

        return TvChannels(
            leftAmount,
            channels
        )
    }

    suspend fun getChannelDetails(id: Int): TvChannelFullModel? {
        return tvChannels.getChannelDetails(id)
    }
}