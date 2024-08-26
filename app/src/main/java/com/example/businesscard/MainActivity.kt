package com.example.businesscard

import android.graphics.drawable.shapes.OvalShape
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.MailOutline
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
                    BusinessCard(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCard(name: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .background(color = Color.LightGray)
            .height(600.dp)
            .width(300.dp)

    ) {
        NameInfo(modifier.align(alignment= Alignment.CenterHorizontally))
        Spacer(modifier.height(30.dp))
        Contact(modifier.align(alignment= Alignment.CenterHorizontally)
        )
    }

}

@Composable
fun Contact(modifier: Modifier) {
    Column() {
        Row {
            Icon(
                Icons.Rounded.Call,
                contentDescription = null,
            )
            Text(
                text = "+00 (00) 000 0000",
                modifier = modifier

            )
        }
        Row {
            Icon(
                Icons.Rounded.Share,
                contentDescription = null,
            )
            Text(
                text = "@socialmediahandle",
                modifier = modifier

            )
        }
        Row {
            Icon(
                Icons.Rounded.MailOutline,
                contentDescription = null,
            )
            Text(
                text = "email@domain.com",
                modifier = modifier


            )
        }
    }
}

@Composable
fun NameInfo(modifier: Modifier) {
    val image = painterResource(R.drawable.android_logo)
    Column() {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Fit,
            alpha = 0.7f,
            modifier = modifier
                .padding(24.dp)
                .height(150.dp)
                .width(150.dp)
                .background(color = Color.Black)
        )

        Text(
            text = "Jasper White",
            modifier = modifier


        )
        Text(
            text = "Computer Science Student",
            modifier = modifier


        )
    }

}

@Preview(showBackground = true)
@Composable
fun CardPreview() {
    BusinessCardTheme {
        BusinessCard("Jasper White", modifier = Modifier)
    }
}