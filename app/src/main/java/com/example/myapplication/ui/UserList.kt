package com.example.myapplication.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.example.myapplication.viewmodel.UserListViewModel


@Composable
fun UserList(){
    val viewModel:UserListViewModel = hiltViewModel()
    val userList by viewModel.allUsers.collectAsState()



    LazyColumn {
        items(userList?: emptyList()) { element ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Column (
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Text(text = "Name : ${element?.firstName}" )
                    Image(painter =  rememberImagePainter(data = "${element?.image}" ),
                        contentDescription = "Image",
                        modifier = Modifier
                            .size(128.dp)
                            .padding(8.dp)
                    )
                }
            }

        }
    }

}
