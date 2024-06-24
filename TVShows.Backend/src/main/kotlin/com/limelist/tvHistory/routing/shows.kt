package com.limelist.tvHistory.routing

import com.limelist.tvHistory.services.TvShowsService
import io.ktor.resources.*
import io.ktor.server.application.*
import io.ktor.server.resources.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.Serializable

fun Route.shows(tvShowsService: TvShowsService) {
    route("shows"){
        get<AllShows>(){ args ->
            val shows = tvShowsService.getAllShows(
                args.limit,
                args.offset,
                args.playlistLimit
            )
            call.respond(shows);
        }
        get<AllShows.Show>(){ args ->
            val show = tvShowsService.getShowDetails(args.id);
            if (show != null)
                call.respond(show)
            else
                call.respondText("{}")
        }

    }
}


@Serializable
@Resource("/")
data class AllShows(
    val limit: Int? = null,
    val offset: Int? = null,
    val playlistLimit: Int? = null
){
    @Resource("{id}")
    data class Show(
        val id: Int,
    )
}