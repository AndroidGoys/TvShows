package com.limelist.tvHistory.routing

import com.limelist.tvHistory.services.TvChannelsService
import io.ktor.resources.*
import io.ktor.server.application.*
import io.ktor.server.resources.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.Serializable

fun Route.channels(tvChannelsService: TvChannelsService) {
    route("channels"){
        get<AllChannels>(){ args ->
            val channels = tvChannelsService.getAllChannels(
                args.limit,
                args.offset,
                args.playlistLimit
            )
            call.respond(channels);
        }
        get<AllChannels.Channel>(){ args ->
            val channel = tvChannelsService.getChannelDetails(
                args.id
            );
            if (channel != null)
                call.respond(channel);
            else
                call.respondText("{}")

        }

    }
}

@Serializable
@Resource("/")
data class AllChannels(
    val limit: Int? = null,
    val offset: Int? = null,
    val playlistLimit: Int? = null
){
    @Resource("{id}")
    data class Channel(
        val id: Int,
    )
}