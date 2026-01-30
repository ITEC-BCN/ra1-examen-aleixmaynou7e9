package com.example.adivinaapp.view

import android.R.attr.color
import android.text.Layout
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DividerDefaults.color
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.SnackbarDefaults.color
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.HorizontalAlign
import androidx.navigation.NavController
import com.example.adivinaapp.Routes
import java.lang.Math.random


@Composable
fun GameScreen(navController: NavController) {

    var myText = ""
    var valueMsg = ""
    var secretNumberText = "?"
    var numerosErronis = ""
    var secretNumber = "2"
    var progressStatus = 1.0f
    val pattern = remember { Regex("^\\d+\$") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray),
        contentAlignment = Alignment.Center,

    ) {
        Column(modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally
            ){
            Text(secretNumberText)

            Spacer(Modifier.height(30.dp))

            LinearProgressIndicator(
                progress = {progressStatus},
                color = Color.Red,
                trackColor = Color.Black
            )

            Spacer(Modifier.height(30.dp))

            var myText by remember { mutableStateOf("") }

            TextField (
                value = myText,
                onValueChange = {
                    if (it.matches(pattern)) myText = it
                },
                label = { Text(text = "Introdueix un número (1-10)")},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Button(onClick = {
                if (myText !="1" && myText !="2" && myText !="3" && myText !="4" && myText !="5" && myText !="6" && myText !="7" && myText !="8" && myText !="9" && myText !="10"){
                    valueMsg = "Introdueix un número entre 1 i 10."
                }
                else {
                    if (myText == "2") {
                        secretNumberText = secretNumber
                        valueMsg = "Número Correcte"
                    } else {
                        progressStatus -= 0.1f
                        numerosErronis += myText
                    }
                }
            },
                colors = ButtonDefaults.buttonColors (
                    containerColor = Color(0xFF6650A4),
                    contentColor = Color.White
                )
            ) {Text("Comprovar")}

            Text(valueMsg)

            Text(numerosErronis)

            Row() {
                Button(
                    onClick = { navController.navigate(Routes.Game.route)},
                    colors = ButtonDefaults.buttonColors (
                        containerColor = Color(0xFF246860),
                        contentColor = Color.White
                    )
                ) {
                    Text(text = "Tornar a jugar")
                }

                Spacer(Modifier.width(30.dp))

                Button(
                    onClick = { navController.navigate(Routes.Menu.route)},
                    colors = ButtonDefaults.buttonColors (
                        containerColor = Color(0xFF537770),
                        contentColor = Color.White
                    )
                ) {
                    Text(text = "Menu Principal")
                }
    }
}}}