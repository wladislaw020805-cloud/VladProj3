package com.example.unit2
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
class MainActivity: ComponentActivity(){ override fun onCreate(savedInstanceState: Bundle?){super.onCreate(savedInstanceState);setContent{Lemonade()}}}
@Composable fun Lemonade(){ var step by remember{mutableIntStateOf(1)}; var squeezes by remember{mutableIntStateOf(0)}; val (title,desc)=when(step){1->"Лимонное дерево" to "Нажмите, чтобы выбрать лимон";2->"Выбранный лимон" to "Нажмите несколько раз, чтобы выжать сок";3->"Выжимание" to "Осталось нажатий: $squeezes";else->"Стакан лимонада" to "Готово! Нажмите, чтобы начать заново"}; Column(Modifier.fillMaxSize().padding(28.dp),horizontalAlignment=Alignment.CenterHorizontally,verticalArrangement=Arrangement.Center){Text(title,style=MaterialTheme.typography.headlineSmall);Spacer(Modifier.height(12.dp));Text(desc,fontSize=17.sp);Spacer(Modifier.height(28.dp));Button(onClick={when(step){1->{step=2};2->{squeezes=(2..4).random();step=3};3->{if(squeezes>1)squeezes-- else step=4};4->{step=1}}},shape=RoundedCornerShape(18.dp)){Text(if(step==4)"RESET" else "TAP")}}}
