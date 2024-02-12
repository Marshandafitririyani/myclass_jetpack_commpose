package com.example.project1.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.project1.R
import com.example.project1.ui.home.HomeActivity
import com.example.project1.ui.theme.Project1Theme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginView {
                        val homeIntent = Intent(this, HomeActivity::class.java)
                        startActivity(homeIntent)
                        finish()
                    }
                }
            }
        }
    }
}

@Composable
fun LoginView(loginCallback: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(modifier = Modifier.padding(bottom = 78.dp)) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(234.dp)
                        .background(
                            color = colorResource(id = R.color.green_30),
                            shape = RoundedCornerShape(0.dp, 0.dp, 100.dp, 100.dp)
                        )
                )
            }
            Image(
                modifier = Modifier
                    .width(156.dp)
                    .align(Alignment.BottomCenter)
                    .padding(top = 32.dp),
                contentScale = ContentScale.FillWidth,
                painter = painterResource(id = R.drawable.img_logo),
                contentDescription = "image logo"
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = "Login",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(24.dp))
        FormLogin(label = "Phone Number", hint = "Add Phone")
        FormLogin(label = "Password", hint = "Add Password")
        Button(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth()
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.green_20)),
            shape = RoundedCornerShape(16.dp),
            onClick = loginCallback
        ) {
            Text(text = "Login", color = colorResource(id = R.color.black))
        }
        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = "Don't have an account? Sign up",
            color = colorResource(id = R.color.green)
        )
    }
}

@Composable
fun FormLogin(label: String, hint: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 8.dp)
    ) {
        Text(
            text = label,
            fontSize = 16.sp
        )
        OutlinedTextField(
            modifier = Modifier
                .padding(top = 12.dp)
                .fillMaxWidth()
                .background(colorResource(id = R.color.abu_1), RoundedCornerShape(10.dp))
                .border(2.dp, colorResource(id = R.color.abu_1), RoundedCornerShape(10.dp)),
            value = "",
            shape = RoundedCornerShape(10.dp),
            placeholder = {Text(text = hint, fontSize = 13.sp)},
            onValueChange = {})
    }
}

@Preview(showBackground = true)
@Composable
fun LoginViewPreview() {
    LoginView { }
}

