package com.limelist.tvHistory.domain.repositories

interface Repository {
    suspend fun count(): Int
}