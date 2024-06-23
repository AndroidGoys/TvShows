package com.limelist.tvHistory.dataAccess.sqlite.repositories

import com.limelist.tvHistory.domain.repositories.TvChannelsRepository
import java.sql.Connection

class TvChannelsSqliteRepository(
    connection: Connection
) : BaseSqliteRepository(connection),
    TvChannelsRepository {
}