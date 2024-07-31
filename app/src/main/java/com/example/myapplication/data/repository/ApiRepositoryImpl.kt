package com.example.myapplication.data.repository

import com.example.myapplication.data.api.IApiEndpoint
import com.example.myapplication.data.model.UserModel
import javax.inject.Inject

class ApiRepositoryImpl @Inject constructor(val apiEndpoint: IApiEndpoint): IApiRepository {
    override suspend fun getAllUserList(): UserModel = apiEndpoint.getAllUsers()

}