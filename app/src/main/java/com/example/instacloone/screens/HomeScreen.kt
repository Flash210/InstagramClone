package com.example.instacloone.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposableOpenTarget
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.instacloone.R
import com.example.instacloone.details.Post
import com.example.instacloone.details.Story
import com.example.instacloone.ui.theme.InstaClooneTheme


var storyList = mutableListOf<Story>(
    Story("Your Story", R.drawable.user1),
    Story("Ahmed", R.drawable.user2),
    Story("ALi", R.drawable.user3),
    Story("Selma", R.drawable.user4),
    Story("Khalil", R.drawable.user5)

)

var postList= mutableListOf<Post>(
    Post("Selma",R.drawable.user4,R.drawable.img1),
    Post("Ali",R.drawable.user3,R.drawable.img2),
    Post("Khalil",R.drawable.user5,R.drawable.img3),
    Post("Ahmed",R.drawable.user1,R.drawable.img4),

    )


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(

) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Image(
                        modifier = Modifier
                            .width(140.dp)
                            .padding(0.dp, 10.dp, 0.dp, 0.dp),

                        painter = painterResource(id = R.drawable.insta),
                        contentDescription = null
                    )
                },
                actions = {
                    Image(
                        modifier = Modifier
                            .width(25.dp),
                        contentScale = ContentScale.FillWidth,
                        painter = painterResource(id = R.drawable.heart),
                        contentDescription = "like"
                    )

                    Spacer(modifier = Modifier.width(14.dp))
                    Image(
                        modifier = Modifier
                            .width(28.dp),
                        painter = painterResource(id = R.drawable.send),
                        contentScale = ContentScale.FillWidth,
                        contentDescription = ""
                    )

                    Spacer(modifier = Modifier.width(5.dp))

                }
            )
        },


        bottomBar = {
            Row(
                modifier = Modifier
                    .background(Color.White)
                    .border(1.dp, Color.Gray)
                    .fillMaxWidth()
                    .padding(0.dp, 10.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Image(
                    modifier = Modifier
                        .size(30.dp),
                    painter = painterResource(id = R.drawable.home),
                    contentDescription = ""
                )

                Image(
                    modifier = Modifier
                        .size(30.dp),
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = ""
                )



                Image(
                    modifier = Modifier
                        .size(30.dp),
                    painter = painterResource(id = R.drawable.more),
                    contentDescription = ""
                )

                Image(
                    modifier = Modifier
                        .size(30.dp),
                    painter = painterResource(id = R.drawable.video),
                    contentDescription = ""
                )


                Image(
                    modifier = Modifier
                        .size(30.dp),
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = ""
                )


            }
        }


    ) {
        LazyColumn() {
            item {
                LazyRow() {
                    items(storyList) { item ->
                        Column(
                            modifier = Modifier
                                .padding(10.dp, 80.dp)){
                            Image(
                                modifier= Modifier
                                    .size(64.dp)
                                    .clip(CircleShape)
                                    .border(1.dp, Color.Red, CircleShape)
                                    .padding(3.dp)
                                    .clip(CircleShape)
                                    .border(2.dp, Color.White, CircleShape),
                                painter = painterResource(id = item.profileImage),
                                contentDescription = "")
                            
                            Text(
                                text = item.name,
                                style = TextStyle(
                                    color=Color.Black)
                            )

                        }
                    }


                }

                items(postList){
                        item ->
                    Row (
                        modifier = Modifier
                            .padding(10.dp, 0.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){

                        Row(
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Image(
                                modifier =
                                Modifier
                                    .size(45.dp)
                                    .clip(CircleShape)
                                    .border(1.dp, Color.Red),

                                painter = painterResource(id = item.profile),
                                contentDescription = "")

                            Spacer(modifier = Modifier.width(10.dp))

                            Text(text = item.name)

                        }

                    }


                    Column(
                        modifier = Modifier.padding(0.dp,10.dp)
                    ) {



                        Image(

                            painter = painterResource(id = item.image),
                            contentDescription = "")

                    }
                }
            }
        }


    }
}


@Preview
@Composable
fun previewCom(

) {
    InstaClooneTheme {
        HomeScreen()

    }
}