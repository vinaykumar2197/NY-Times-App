package com.vinay.myapplication.data.repository

import com.vinay.myapplication.data.remote.AppApi
import com.vinay.myapplication.domain.model.Results
import com.vinay.myapplication.domain.repository.AppRepository
import com.vinay.myapplication.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppRepositoryImpl @Inject constructor(
    private val api: AppApi,
): AppRepository {

    override suspend fun getCompanyListings(
        fetchFromRemote: Boolean
    ): Flow<Resource<List<Results>>> {
        return flow {
            emit(Resource.Loading(true))
            try {
                val response = api.getListings().results
                emit(
                    Resource.Success(
                    data = response
                ))
                emit(Resource.Loading(false))
            } catch(e: IOException) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't load data"))
                null
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't load data"))
                null
            }

        }
    }

}