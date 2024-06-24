package com.limelist.tvHistory.dataAccess.sqlite.repositories

import com.limelist.tvHistory.domain.models.channels.TvChannelFullModel
import com.limelist.tvHistory.domain.models.channels.TvChannelModel
import kotlinx.coroutines.sync.Mutex
import java.sql.Connection

import com.limelist.tvHistory.domain.repositories.TvChannelsRepository

class TvChannelsSqliteRepository(
    connection: Connection,
    mutex: Mutex
) : BaseSqliteRepository(connection, mutex, channelsTabelName),
    TvChannelsRepository {
    override suspend fun getAllChannels(limit: Int?, offset: Int, playlistLimit: Int?): Iterable<TvChannelModel> {
        TODO("Not yet implemented")
    }

    override suspend fun getChannelDetails(id: Int): TvChannelFullModel? {
        TODO("Not yet implemented")
    }

    override suspend fun count(): Int {
        TODO("Not yet implemented")
    }
}