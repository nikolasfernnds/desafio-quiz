import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aulasandroid.desafioquiz.R

@Composable
fun QuizScreen() {

    val perguntas = listOf(
        Triple(
            "Qual seleção ganhou a Copa do Mundo de 2002?",
            listOf("Alemanha", "Brasil", "França", "Argentina"),
            1
        ),
        Triple(
            "Quem é o maior artilheiro da história das Copas?",
            listOf("Pelé", "Ronaldo", "Klose", "Messi"),
            2
        ),
        Triple(
            "Em que ano o Brasil ganhou o penta?",
            listOf("1998", "2002", "2006", "2010"),
            1
        )
    )

    var indice by remember { mutableStateOf(0) }
    var selecionado by remember { mutableStateOf(-1) }
    var respondeu by remember { mutableStateOf(false) }

    val perguntaAtual = perguntas[indice]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE07BB5)),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Spacer(modifier = Modifier.height(30.dp))

        Image(
            painter = painterResource(R.drawable.quiz),
            contentDescription = "",
            modifier = Modifier.size(60.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .background(
                    color = Color(0xFF6FD1A6),
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(horizontal = 24.dp, vertical = 8.dp)
        )
        {
            Text(
                text = "Pergunta ${indice + 1} de ${perguntas.size}",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )}

            Spacer(modifier = Modifier.height(16.dp))

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                colors = CardDefaults.cardColors(Color.White)
            ) {

                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {

                    Text(
                        text = perguntaAtual.first,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )

                    perguntaAtual.second.forEachIndexed { index, opcao ->

                        val cor = when {
                            respondeu && index == perguntaAtual.third -> Color.Green
                            respondeu && index == selecionado -> Color.Red
                            else -> Color.White
                        }

                        OutlinedButton(
                            onClick = {
                                if (!respondeu) {
                                    selecionado = index
                                    respondeu = true
                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(48.dp),
                            border = BorderStroke(1.dp, Color.Black),
                            colors = ButtonDefaults.outlinedButtonColors(
                                containerColor = cor
                            )
                        ) {
                            Text(
                                text = opcao,
                                color = Color.Black
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Button(
                        onClick = {
                            if (indice < perguntas.size - 1) {
                                indice++
                                selecionado = -1
                                respondeu = false
                            }
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Próxima")
                    }
                }
            }
        }
    }