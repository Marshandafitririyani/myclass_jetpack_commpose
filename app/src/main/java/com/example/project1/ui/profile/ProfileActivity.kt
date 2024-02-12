package com.example.project1.ui.profile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.project1.R
import com.example.project1.ui.theme.Project1Theme

class ProfileActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Profile()
                }
            }
        }
    }
}


@Preview
@Composable
fun Profile(){
   ConstraintLayout {
       val (buttonAction) = createRefs()

       Column(
           modifier = Modifier
               .fillMaxSize()
               .background(colorResource(id = R.color.green_10))
       ) {
           Image(
               modifier = Modifier
                   .padding(24.dp)
                   .width(30.dp)
                   .height(30.dp),
               painter = painterResource(id = R.drawable.ic_back),
               contentDescription = "button back"
           )
           Box(
               modifier = Modifier.align(Alignment.CenterHorizontally)
           ) {
               Image(
                   painter = painterResource(id = R.drawable.img_edit_poto),
                   contentDescription = "image person"
               )
               Box(
                   modifier = Modifier
                       .align(Alignment.BottomEnd)
                       .padding(8.dp)
               ) {

                   Image(
                       painter = painterResource(id = R.drawable.ic_edit_pen_white),
                       contentDescription = "icon edit",
                       modifier = Modifier
                           .background(
                               colorResource(id = R.color.green_30),
                               shape = CircleShape
                           )
                           .padding(8.dp)
                   )
               }
           }
           Component(
               icon = R.drawable.ic_person,
               label = "Name",
               value = "Empty Name",
               showButton = true
           )
           Component(
               icon = R.drawable.ic_person,
               label = "School",
               value = "Empty School",
               showButton = true
           )
           Component(
               icon = R.drawable.ic_person,
               label = "Phone",
               value = "Empty Phone",
               showButton = true
           )

   }
       Column(modifier = Modifier
           .fillMaxWidth()
           .padding(24.dp)
           .constrainAs(buttonAction) {
               bottom.linkTo(parent.bottom)
           }
       ) {

           Button(modifier = Modifier
               .height(48.dp)
               .fillMaxWidth(),
               colors = ButtonDefaults.buttonColors(colorResource(id = R.color.green_20)),
               shape = RoundedCornerShape(16.dp),
               onClick = {  }
           ) {
               Text(text = "Edit Password", color = colorResource(id = R.color.black))
           }
           Spacer(modifier = Modifier.height(16.dp))
           Button(modifier = Modifier
               .fillMaxWidth()
               .height(48.dp),
               colors = ButtonDefaults.buttonColors(colorResource(id = R.color.green)),
               shape = RoundedCornerShape(16.dp),
               onClick = {}
           ){
               Text(text = "Logout", color = colorResource(id = R.color.white))
           }
       }
   }}

@Composable
fun Component(icon: Int, label: String, value: String, showButton: Boolean = false){
    Row(modifier = Modifier
        .padding(vertical = 16.dp, horizontal = 24.dp)
    ) {
Image(
    modifier = Modifier
        .align(Alignment.CenterVertically)
        .width(32.dp),
    contentScale = ContentScale.FillWidth,
    painter = painterResource(id = icon),
    contentDescription = "person image"
)
        Spacer(modifier = Modifier.width(16.dp))
        Column(modifier = Modifier.align(Alignment.CenterVertically)
        ) {
            Text(
                color = colorResource(id = R.color.green_30),
                text = label,
                fontSize = 16.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Row {
                Text(
                    modifier = Modifier.weight(1f),
                    text = value,
                    fontSize = 19.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                if(showButton){
                    Image(painter = painterResource(id = R.drawable.ic_edit_pen_white),
                        contentDescription = "edit icon",
                        colorFilter = ColorFilter.tint(colorResource(id = R.color.green)))
                }
            }
        }
    }
    
}


@Composable
fun ImageBack(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.ic_back),
        contentDescription = "Image",
        modifier = modifier

    )
}

@Composable
fun ImageProfile(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.img_edit_poto),
        contentDescription = "Image",
        modifier = modifier

    )
}

