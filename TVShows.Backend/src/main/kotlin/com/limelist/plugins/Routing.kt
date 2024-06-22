package com.limelist.plugins

import io.ktor.resources.*
import io.ktor.server.application.*
import io.ktor.server.resources.*
import io.ktor.server.resources.Resources
import io.ktor.server.response.*
import io.ktor.server.routing.*

import com.limelist.tvHistory.routing.useTvHistory;

fun Application.configureRouting() {
    install(Resources)
    routing {
        useTvHistory("/")
    }
}