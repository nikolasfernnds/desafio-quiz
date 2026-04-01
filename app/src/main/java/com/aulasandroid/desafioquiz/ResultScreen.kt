package com.aulasandroid.desafioquiz

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.aulasandroid.desafioquiz.R

@Composable
fun ResultScreen(navController: NavController, pontuacao: Int) {
    Column(
        modifier = Modifier
            .background(Color(0, 188, 212, 255))
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Row(
            modifier = Modifier
        ) {
            Image(
                modifier = Modifier.size(80.dp),
                painter = painterResource(R.drawable.quiz),
                contentDescription = "Icon Quiz"
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        OutlinedButton(
            onClick = { },
            modifier = Modifier
                .width(285.dp)
                .height(55.dp),
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(1.dp, Color.Black),
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = Color(77, 203, 75, 195)
            )
        ) {
            Text(
                text = "Bom trabalho!",
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Você acertou $pontuacao de 3 perguntas",
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                navController.navigate("quiz")
            },
            colors = ButtonDefaults.buttonColors(
                Color.Yellow
            )
        ) {
            Text(
                text = "JOGAR NOVAMENTE",
                color = Color.Black
            )
        }
    }
}
