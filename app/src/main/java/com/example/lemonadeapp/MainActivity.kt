package com.example.lemonadeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonadeapp.ui.theme.LemonadeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                LemonApp()


        }
    }
}


@Composable
fun LemonApp() {
    LemonTextAndImage(columnModifier = Modifier.fillMaxSize(), textModifier = Modifier.padding(bottom = 15.dp))
}


@Composable
fun LemonTextAndImage(columnModifier: Modifier, textModifier: Modifier) {
    var currentNumber by remember { mutableStateOf(1) }

    val currentImage = when(currentNumber) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }
    val currentText = when(currentNumber) {
        1 -> R.string.LemonTreeInstructions
        2 -> R.string.LemonInstructions
        3 -> R.string.FullGlassInstructions
        else -> R.string.EmptyGlassInstructions
    }


    var i = 1
    var clickableLogic = {
        if (currentNumber == 4)
            currentNumber = 1
        else currentNumber++

    }

    Column( horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = columnModifier)
    {
        Text(modifier = textModifier,
            text = stringResource(id = currentText))
        Image(painter = painterResource(id = currentImage),
            modifier = Modifier.clickable {
                if (currentNumber == 2){
                    var randomNumber = (2..4).random()
                    if (i  <= randomNumber){
                        i++
                    }
                    else {
                    currentNumber = 3
                    }
                }
                else {
                    clickableLogic()
                }
                                          },
            contentDescription = stringResource(
                id = R.string.LemonTreeDescription))
    }



}






@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LemonadeAppTheme {

    }
}