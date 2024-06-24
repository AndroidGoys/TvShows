package com.limelist.tvHistory.dataAccess.sqlite.repositories

import com.limelist.tvHistory.domain.models.shows.TvShowFullModel
import com.limelist.tvHistory.domain.models.shows.TvShowModel
import kotlinx.coroutines.sync.Mutex
import java.sql.Connection

import com.limelist.tvHistory.domain.repositories.ТvShowsRepository

class TvShowsSqliteRepository(
    connection: Connection,
    mutex: Mutex
) : BaseSqliteRepository(connection, mutex, showsTabelName),
    ТvShowsRepository {
    override suspend fun getAllShows(limit: Int?, offset: Int, playlistLimit: Int?): Iterable<TvShowModel> {
        TODO("Not yet implemented")
    }

    override suspend fun getShowDetails(id: Int): TvShowFullModel? {
        TODO("Not yet implemented")
    }

    override suspend fun count(): Int {
        TODO("Not yet implemented")
    }
}