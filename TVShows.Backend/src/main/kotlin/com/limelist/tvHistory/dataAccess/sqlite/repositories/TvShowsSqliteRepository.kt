package com.limelist.tvHistory.dataAccess.sqlite.repositories

import com.limelist.tvHistory.domain.repositories.ТvShowsRepository
import java.sql.Connection

class TvShowsSqliteRepository(
    connection: Connection,
) : BaseSqliteRepository(connection),
    ТvShowsRepository {
}