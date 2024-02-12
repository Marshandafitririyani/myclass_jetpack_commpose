package com.example.project1.ui.detail

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.project1.R
import com.example.project1.data.local.Friend
import com.example.project1.ui.theme.Project1Theme

class DetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val data = intent.getParcelableExtra<Friend>(DATA)
                    DetailView(this, data)
                }
            }
        }
    }
    companion object{
        const val DATA = "data"
    }
}

@Preview
@Composable
fun DetailView(context: Activity? = null, data: Friend? = null){
    ConstraintLayout {
        val (viewInformation, viewAction) = createRefs()
        Column( modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight()
            .background(colorResource(id = R.color.green_1_5))
            .constrainAs(viewInformation){
                start.linkTo(parent.start)
                top.linkTo(parent.top)
                end.linkTo(parent.end)
            }
        ) {
            Box (modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
            ) {
                ImageBack(modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
                    .clickable {
                        context?.finish()
                    }
                )

                ImageLike(modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
                    .align(Alignment.BottomEnd)

                )

            }
            ImagePerson(
                modifier = Modifier
                    .width(200.dp)
                    .height(200.dp)
                    .padding(top = 10.dp)
                    .align(Alignment.CenterHorizontally)
            )

            DataInformation(icon = R.drawable.ic_person, label = "Name", value = data?.name?: "")
            DataInformation(icon = R.drawable.ic_school, label = "School", value = data?.schoolName?: "")
            DataInformation(icon = R.drawable.ic_phone, label = "Phone", value = data?.phoneNumber?: "")


        }

        Row(modifier = Modifier
            .constrainAs(viewAction){
                start.linkTo(parent.start)
                bottom.linkTo(parent.bottom,24.dp)
                end.linkTo(parent.end)


        }) {
            ButtonView(label = "Collek", color = R.color.green_40)
            Spacer(modifier = Modifier.width(16.dp))
            ButtonView(label = "Colek WhatsApp", color = R.color.green_wa)


        }

    }
}

/*@Composable
@Preview(showBackground = true)
fun DetailView(data: Friend? = null) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight()
            .background(colorResource(id = R.color.green_1_5))
    ) {

        Box (modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
        ) {
            ImageBack(modifier = Modifier
                .width(50.dp)
                .height(50.dp)
               )

            ImageLike(modifier = Modifier
                .width(50.dp)
                .height(50.dp)
                .align(Alignment.BottomEnd)

                )

        }
        ImagePerson(
            modifier = Modifier
                .width(200.dp)
                .height(200.dp)
                .padding(top = 10.dp)
                .align(Alignment.CenterHorizontally)
        )

        DataInformation(icon = R.drawable.ic_person, label = "Name", value = data?.name?: "")
        DataInformation(icon = R.drawable.ic_school, label = "School", value = data?.schoolName?: "")
        DataInformation(icon = R.drawable.ic_phone, label = "Phone", value = data?.phoneNumber?: "")



    ConstraintLayout(
        modifier = Modifier
        .align(Alignment.CenterHorizontally)
        .verticalScroll(rememberScrollState())
        .weight(1f, false)) {
        val (buttonAction) = createRefs()
        ButtonAction(Modifier.constrainAs(buttonAction) {
            bottom.linkTo(parent.bottom, margin = 24.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })
    }

    }
}*/

@Composable
fun DataInformation(icon: Int, label:String, value: String){
    Row(modifier = Modifier.padding(vertical = 12.dp, horizontal = 24.dp)
    ){
     Image(
         modifier = Modifier
             .align(Alignment.CenterVertically)
             .width(35.dp)
             .height(35.dp),
         contentDescription = "person image",
         painter = painterResource(id = icon)
     )
        Spacer(modifier = Modifier.width(16.dp))
        Column(modifier = Modifier.align(Alignment.CenterVertically)
        ){
            Text(text = label,
                fontSize = 16.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(text = value, fontSize = 19.sp, maxLines = 1, overflow = TextOverflow.Ellipsis)

        }




    }
}

@Composable
fun ButtonView(label: String, color: Int){
   Button(
       modifier = Modifier
           .width(156.dp)
           .height(48.dp),
       colors = ButtonDefaults.buttonColors(colorResource(id = color)),
       shape = RoundedCornerShape(16.dp),
       onClick = { /*TODO*/ }
   ) {
       Text(text = label)
   }
}

@Composable
fun ButtonAction(modifier: Modifier){
    Row(modifier = Modifier) {
        ButtonView(label = "Collek", color = R.color.green_40)
        Spacer(modifier = Modifier.width(16.dp))
        ButtonView(label = "Colek WhatsApp", color = R.color.green_wa)

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
fun ImagePerson(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.ic_person),
        contentDescription = "Image",
        modifier = modifier,


    )
}

@Composable
fun ImageLike(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.ic_favorite),
        contentDescription = "Image",
        modifier = modifier

    )
}