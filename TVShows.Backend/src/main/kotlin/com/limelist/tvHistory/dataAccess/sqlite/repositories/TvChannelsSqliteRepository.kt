package com.limelist.tvHistory.dataAccess.sqlite.repositories

import com.limelist.tvHistory.domain.models.channels.TvChannelFullModel
import com.limelist.tvHistory.domain.models.channels.TvChannelModel
import kotlinx.coroutines.sync.Mutex
import java.sql.Connection

import com.limelist.tvHistory.domain.repositories.TvChannelsRepository
import kotlinx.coroutines.sync.withLock

class TvChannelsSqliteRepository(
    connection: Connection,
    mutex: Mutex
) : BaseSqliteRepository(connection, mutex, channelsTabelName),
    TvChannelsRepository {

        override suspend fun getAllChannels(limit: Int?, offset: Int, playlistLimit: Int?): Iterable<TvChannelModel> {
        return mutex.withLock {
            val statement = connection.prepareStatement("""
            SELECT id, name, description 
            FROM channels
            LIMIT ?
            OFFSET ?
        """)

            statement.setInt(1, limit ?: Int.MAX_VALUE)
            statement.setInt(2, offset)

            val resultSet = statement.executeQuery()

            return@withLock buildList {
                while (resultSet.next()) {
                    add(
                        TvChannelModel(
                            id = resultSet.getInt("id"),
                            name = resultSet.getString("name"),
                            shows = listOf()
                        )
                    )
                }
            }
        }
    }

    override suspend fun getChannelDetails(id: Int): TvChannelFullModel? {
        return mutex.withLock {
            return@withLock connection.prepareStatement("""
                    SELECT channels.id, channels.name, channels.description,(
                        SELECT GROUP_CONCAT(url, ',')
                        FROM channel_view_urls
                        WHERE channel_view_urls.channel_id = channels.id
                    ) AS view_urls
                    FROM channels
                    WHERE channels.id = ?
                """).use { statement ->
                statement.setInt(1, id)
                statement.executeQuery().use { resultSet ->
                    if (resultSet.next()) {
                        TvChannelFullModel(
                            id = resultSet.getInt("id"),
                            name = resultSet.getString("name"),
                            description = resultSet.getString("description"),
                            channelViewUrls = resultSet.getString("channel_view_urls")?.split(",")?.toList() ?: emptyList()
                        )
                    } else {
                        null
                    }
                }
            }
        }
    }
    }
