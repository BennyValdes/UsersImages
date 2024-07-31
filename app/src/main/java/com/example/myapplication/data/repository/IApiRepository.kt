package com.example.myapplication.data.repository

import com.example.myapplication.data.model.UserModel

interface IApiRepository {
    suspend fun getAllUserList():UserModel
}