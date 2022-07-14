package com.vinay.myapplication.domain.repository

import com.vinay.myapplication.domain.model.Results
import com.vinay.myapplication.util.Resource
import kotlinx.coroutines.flow.Flow

interface AppRepository {
    suspend fun getCompanyListings(
        fetchFromRemote: Boolean
    ): Flow<Resource<List<Results>>>
}