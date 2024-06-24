package com.limelist.tvHistory.services

import com.limelist.tvHistory.domain.models.TvShows
import com.limelist.tvHistory.domain.models.shows.TvShowFullModel
import com.limelist.tvHistory.domain.models.shows.TvShowModel
import com.limelist.tvHistory.domain.repositories.ТvShowsRepository

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