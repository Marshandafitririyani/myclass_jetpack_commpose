package com.example.project1.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import com.example.project1.R
import com.example.project1.ui.home.HomeActivity
import com.example.project1.ui.login.LoginActivity
import com.example.project1.ui.theme.Project1Theme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    Perent()
                }
            }
        }

        lifecycleScope.launch {
            delay(2_000)
            startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
            finish()

        }
    }
}

@Preview(showBackground = true)
@Composable
fun Perent(){
  Box(modifier = Modifier
      .fillMaxSize()
      .background(colorResource(id = R.color.green_10))
  ){
      MyImage(

          Modifier
              .width(165.dp)
              .align(Alignment.Center)
      )
  }
}


@Composable
fun MyImage(modifier: Modifier){
    Image(painter = painterResource(id = R.drawable.img_logo),
        contentDescription ="Image",
        contentScale = ContentScale.FillWidth,
        modifier = modifier
    )
}




