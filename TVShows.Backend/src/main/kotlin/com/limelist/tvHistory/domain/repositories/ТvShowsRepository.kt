package com.limelist.tvHistory.domain.repositories

import com.limelist.tvHistory.domain.models.shows.TvShowFullModel
import com.limelist.tvHistory.domain.models.shows.TvShowModel

interface ТvShowsRepository : Repository {
    suspend fun getAllShows(limit: Int?, offset: Int, playlistLimit:Int?): Iterable<TvShowModel>
    suspend fun getShowDetails(id: Int): TvShowFullModel?
}