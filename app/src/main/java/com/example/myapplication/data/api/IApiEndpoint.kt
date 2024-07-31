package com.example.myapplication.data.api

import com.example.myapplication.data.model.User
import com.example.myapplication.data.model.UserModel
import retrofit2.http.GET

interface IApiEndpoint {
    @GET (APIDetails.ENPOINT_USERS)
    suspend fun getAllUsers():UserModel
}