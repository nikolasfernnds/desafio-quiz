package com.aulasandroid.desafioquiz

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF00A6FF)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {

        Image(
            painter = painterResource(id = R.drawable.quiz),
            contentDescription = "Logo",
            modifier = Modifier.size(120.dp)
        )

        Text(
            text = "QUIZATRON 300",
            fontSize = 30.sp,
            color = Color.Black

        )

        Button(
            onClick = {},
            shape = RoundedCornerShape(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFFD54F)
            ),
            border = BorderStroke(1.dp, Color.Black),
            modifier = Modifier
                .width(300.dp)
                .padding(horizontal = 40.dp)
                .height(55.dp)
        ) {
            Text(
                text = "COMEÇAR!",
                color = Color.Black,
                fontSize = 20.sp
            )
        }
    }
}