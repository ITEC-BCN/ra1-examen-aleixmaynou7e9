package com.example.adivinaapp.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.adivinaapp.R
import com.example.adivinaapp.Routes

@Composable
fun MenuScreen(navController: NavController) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.LightGray),
        contentAlignment = Alignment.Center) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,){
            Text("Adivina el número by Aleix Maynou")
            Spacer(Modifier.height(30.dp))
            Image(
                painter = painterResource (id = R.drawable .ic_game),
                contentDescription = "Example",
                Modifier.size(80.dp, 80.dp)
            )
            Spacer(Modifier.height(30.dp))
            Button(
                onClick = { navController.navigate(Routes.Game.route)},
                colors = ButtonDefaults.buttonColors (
                    containerColor = Color(0xFF6650A4),
                    contentColor = Color.White
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Iniciar Partida")
            }
        }
    }
}
