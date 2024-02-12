package com.example.project1.ui.home

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract.Profile
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.project1.R
import com.example.project1.data.local.Friend
import com.example.project1.ui.detail.DataDummy
import com.example.project1.ui.detail.DetailActivity
import com.example.project1.ui.profile.ProfileActivity
import com.example.project1.ui.theme.Project1Theme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background

                ) {

                    HomeView(
                        {
                            val detailIntent = Intent(this, DetailActivity::class.java).apply {
                                putExtra(DetailActivity.DATA, it)
                            }
                            startActivity(detailIntent)
                        },
                        {
                            val profileIntent = Intent(this, ProfileActivity::class.java)
                            startActivity(profileIntent)
                        }
                    )
                }
            }

        }
    }
}


@Composable
fun HomeView(onClickFriend: (Friend) -> Unit, onClickProfile: () -> Unit) {
    val friends = remember { DataDummy.friendList }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight()
            .background(colorResource(id = R.color.green_10))
    ) {

        ConstraintLayout(
            modifier = Modifier
                .padding(top = 36.dp)
                .fillMaxWidth()
        ) {
            val (titleImage, profileButton) = createRefs()
            Image(
                modifier = Modifier
                    .width(42.dp)
                    .height(42.dp)
                    .constrainAs(profileButton) {
                        top.linkTo(titleImage.top)
                        bottom.linkTo(titleImage.bottom)
                        start.linkTo(parent.start, 24.dp)
                    }
                    .clickable {
                        onClickProfile()
                    },
                painter = painterResource(id = R.drawable.img_edit_poto),
                contentDescription = "profile"
            )
            Image(
                painter = painterResource(id = R.drawable.img_my_classroom),
                contentDescription = "title image",
                modifier = Modifier
                    .height(24.dp)
                    .constrainAs(titleImage) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                contentScale = ContentScale.FillHeight
            )
            /*Image(
                painter = painterResource(id = R.drawable.img_my_classroom),
                contentDescription = "title image",
                modifier = Modifier
                    .height(24.dp)
                    .constrainAs(titleImage) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                contentScale = ContentScale.FillWidth

            )*/
        }
        OutlinedTextField(
            leadingIcon = {
                Icon(
                    modifier = Modifier.padding(start = 24.dp, end = 8.dp),
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = "search icon",
                    tint = colorResource(
                        id = R.color.green_30
                    )
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
                .background(colorResource(id = R.color.green_5), RoundedCornerShape(16.dp))
                .border(2.dp, colorResource(id = R.color.green_5), RoundedCornerShape(16.dp)),
            shape = RoundedCornerShape(16.dp),
            placeholder = { Text(text = "Search") },
            value = "",
            onValueChange = {}
        )
        LazyColumn(modifier = Modifier.fillMaxSize().padding(bottom = 10.dp),
            contentPadding = PaddingValues(horizontal = 24.dp)
        ){
            itemsIndexed(friends){index, data ->
                ItemFriend(friend = data) {
                    onClickFriend(data)
                }
                if (index != friends.size - 1){
                    Spacer(modifier = Modifier.fillMaxWidth().height(16.dp))
                }
                
            }
        }
    }
}


@kotlin.OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemFriend(friend: Friend, onClick: () -> Unit) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.green_1_5)
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 3.dp
        ),
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(13.dp),
        onClick = onClick
    ) {
        Row(
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .width(78.dp),
                contentScale = ContentScale.FillWidth,
                painter = painterResource(id = R.drawable.ic_person),
                contentDescription = "person image"
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier.align(Alignment.CenterVertically)
            ) {
                Text(
                    text = friend.name ?: "",
                    fontSize = 19.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = friend.schoolName ?: "",
                    fontSize = 16.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeViewPreview() {
    HomeView(
        { },
        { }
    )
}

@Preview(showBackground = false)
@Composable
fun ShowItemFriend() {
    ItemFriend(friend = DataDummy.friendList[0]) {}
}
