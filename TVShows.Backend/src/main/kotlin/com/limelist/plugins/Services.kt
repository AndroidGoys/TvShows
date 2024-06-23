package com.limelist.plugins

import java.sql.Connection;
import java.sql.DriverManager;
import io.ktor.server.application.*

import com.limelist.ApplicationServices
import com.limelist.tvHistory.TvHistoryServices
import com.limelist.tvHistory.dataAccess.sqlite.repositories.TvChannelsSqliteRepository
import com.limelist.tvHistory.dataAccess.sqlite.repositories.TvShowsSqliteRepository
import com.limelist.tvHistory.services.TvService

fun Application.configureServices() : ApplicationServices {
    val tvHistoryServices = configureTvHistoryServices()
    return ApplicationServices(tvHistoryServices)
}

fun Application.configureTvHistoryServices(): TvHistoryServices {
    val conn = DriverManager.getConnection("jdbc:sqlite:tvHisotry.sql")

    val channels = TvChannelsSqliteRepository(conn)
    val shows = TvShowsSqliteRepository(conn)

    val tvService = TvService(shows, channels);
    return TvHistoryServices(tvService)
}