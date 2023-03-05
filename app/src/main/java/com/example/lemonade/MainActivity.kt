package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
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
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LemonadeApp()
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun LemonadeApp() {
    var result by remember {
        mutableStateOf(1)
    }

    val cardType = when(result) {
        1 -> LemonTree()
        2 -> Lemon()
        3 -> Lemon()
        4 -> Lemon()
        5 -> Lemon()
        6 -> LemonAde()
        7 -> EmptyGlass()
        else -> LemonTree()
    }
Surface {
    when (result) {
        1 -> {
            Button(onClick = { result = 2 }) {
                LemonTree()
            }
        }
        2 -> {
            Button(onClick = { result = (2..6).random() }) {
                Lemon()
            }
        }
        3 -> {
            Button(onClick = { result = (2..6).random() }) {
                Lemon()
            }
        }
        4 -> {
            Button(onClick = { result = (2..6).random() }) {
                Lemon()
            }
        }
        5 -> {
            Button(onClick = { result = (2..6).random() }) {
                Lemon()
            }
        }
        6 -> {
            Button(onClick = { result = 7 }) {
                LemonAde()
            }
        }
        7 -> {
            Button(onClick = { result = 1 }) {
                LemonTree()
            }
        }
    }
  }
}

@Composable
fun LemonTree() {
        Card(
            modifer = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center),
            text = stringResource(R.string.lemon_tree_resource),
            drawable = R.drawable.lemon_tree
        )
}

@Composable
fun Lemon() {
        Card(
            modifer = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center),
            text = stringResource(R.string.lemon_squeeze),
            drawable = R.drawable.lemon_squeeze
        )
}

@Composable
fun LemonAde() {
        Card(
            modifer = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center),
            text = stringResource(R.string.tap_lemonade),
            drawable = R.drawable.lemon_drink
        )
}

@Composable
fun EmptyGlass() {
        Card(
            modifer = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center),
            text = stringResource(R.string.lemon_restart),
            drawable = R.drawable.lemon_restart
        )
}

@Composable
fun Card(modifer: Modifier = Modifier, text: String, drawable: Int) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifer
            .padding(10.dp)
    ) {
        Text(text)
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(id = drawable),
            contentDescription = stringResource(
                R.string.lemon_tree,
            ),
        )
    }
}
