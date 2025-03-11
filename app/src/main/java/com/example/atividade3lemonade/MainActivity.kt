package com.example.atividade3lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.atividade3lemonade.R
import com.example.atividade3lemonade.ui.theme.Atividade3LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Atividade3LemonadeTheme {
                LimonadaApp()
            }
        }
    }
}

@Composable
fun LimonadaApp() {
    var currentStep by remember { mutableIntStateOf(1) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(color = Color(red = 249, green = 228, blue = 76, alpha = 255))
                    .align(Alignment.TopCenter)
            ) {
                Text(
                    text = "Limonada",
                    fontSize = 24.sp,
                    color = Color.Black,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            when (currentStep) {
                1 -> {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Image(
                            painter = painterResource(R.drawable.lemon_tree),
                            contentDescription = stringResource(R.string.lemon_tree_content_description),
                            modifier = Modifier
                                .wrapContentSize()
                                .background(color = Color(0xFFC3ECD2), shape = RoundedCornerShape(20.dp))
                                .padding(horizontal = 20.dp)
                                .border(width = 2.dp, color = Color(0xFFC3ECD2), shape = RoundedCornerShape(20.dp))
                                .clickable { currentStep = 2 }
                        )
                        Spacer(modifier = Modifier.height(32.dp))
                        Text(text = stringResource(R.string.lemon_tree_content_description), fontSize = 19.sp)
                    }
                }
                2 -> {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        var limao = (1..4).random()
                        Image(
                            painter = painterResource(R.drawable.lemon_squeeze),
                            contentDescription = stringResource(R.string.lemon_content_description),
                            modifier = Modifier
                                .wrapContentSize()
                                .background(color = Color(0xFFC3ECD2), shape = RoundedCornerShape(20.dp))
                                .padding(horizontal = 20.dp)
                                .border(width = 2.dp, color = Color(0xFFC3ECD2), shape = RoundedCornerShape(20.dp))
                                .clickable {
                                    when (limao) {
                                        1 -> currentStep = 3
                                        else -> limao -= 1
                                    }
                                }
                        )
                        Spacer(modifier = Modifier.height(32.dp))
                        Text(text = stringResource(R.string.lemon_content_description), fontSize = 19.sp)
                    }
                }
                3 -> {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Image(
                            painter = painterResource(R.drawable.lemon_drink),
                            contentDescription = stringResource(R.string.lemonade_content_description),
                            modifier = Modifier
                                .wrapContentSize()
                                .background(color = Color(0xFFC3ECD2), shape = RoundedCornerShape(20.dp))
                                .padding(horizontal = 20.dp)
                                .border(width = 2.dp, color = Color(0xFFC3ECD2), shape = RoundedCornerShape(20.dp))
                                .clickable { currentStep = 4 }
                        )
                        Spacer(modifier = Modifier.height(32.dp))
                        Text(text = stringResource(R.string.lemonade_content_description), fontSize = 19.sp)
                    }
                }
                else -> {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Image(
                            painter = painterResource(R.drawable.lemon_restart),
                            contentDescription = stringResource(R.string.empty_glass_content_description),
                            modifier = Modifier
                                .wrapContentSize()
                                .background(color = Color(0xFFC3ECD2), shape = RoundedCornerShape(20.dp))
                                .padding(horizontal = 20.dp)
                                .border(width = 2.dp, color = Color(0xFFC3ECD2), shape = RoundedCornerShape(20.dp))
                                .clickable { currentStep = 1 }
                        )
                        Spacer(modifier = Modifier.height(32.dp))
                        Text(text = stringResource(R.string.empty_glass_content_description), fontSize = 19.sp)
                    }
                }
            }
        }
    }
}