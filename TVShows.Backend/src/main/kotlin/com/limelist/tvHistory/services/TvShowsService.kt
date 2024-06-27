package com.limelist.tvHistory.services

import com.limelist.tvHistory.models.TvShows
import com.limelist.tvHistory.models.shows.TvShowFullModel
import com.limelist.tvHistory.dataAccess.interfaces.ТvShowsRepository

class TvShowsService(
    private val tvShows: ТvShowsRepository
) {
    suspend fun getAllShows(limit: Int?, offset: Int?, playlistLimit:Int?): TvShows {
        val offset = offset ?: 0;
        val shows = tvShows.getAllShows(limit, offset, playlistLimit)
        val totalCount = tvShows.count();

        val leftAmount = Math.max(totalCount - shows.count() - offset , 0)

        return TvShows(
            leftAmount,
            shows
        )
    }

    suspend fun getShowDetails(id: Int): TvShowFullModel? {
        return tvShows.getShowDetails(id);
    }

}