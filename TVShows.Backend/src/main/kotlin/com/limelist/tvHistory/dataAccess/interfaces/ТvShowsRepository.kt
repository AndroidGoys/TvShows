package com.limelist.tvHistory.dataAccess.interfaces

import com.limelist.tvHistory.models.shows.TvShowFullModel
import com.limelist.tvHistory.models.shows.TvShowModel

interface ТvShowsRepository : TvRepository {
    suspend fun getAllShows(limit: Int?, offset: Int, playlistLimit:Int?): Iterable<TvShowModel>
    suspend fun getShowDetails(id: Int): TvShowFullModel?
}