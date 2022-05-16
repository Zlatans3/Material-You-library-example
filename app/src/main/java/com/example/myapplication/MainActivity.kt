package com.example.myapplication
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.ui.theme.Typography

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Zlatan")
                }
            }
        }
    }
}


@Composable
fun Greeting(name: String) {
    Column (modifier = Modifier.padding(16.dp)) {
    Box()
    {
        Text(text = "Hello $name!",
            style = Typography.titleSmall,
            color = MaterialTheme.colorScheme.onBackground)
    }
    BalanceInfo()
    ButtonLayout()
    }

}

@Composable
fun ButtonLayout() {
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
            .height(60.dp),
        shape = RoundedCornerShape(8.dp),

        ) {
        Text(text = "SEND")

    }
}


@Composable
fun BalanceInfo() {
 Card(
     backgroundColor = MaterialTheme.colorScheme.secondaryContainer,
     modifier = Modifier
         .fillMaxWidth()
         .padding(top = 16.dp)
     .height(32.dp),
     shape = RoundedCornerShape(8.dp)
 ) {
     Text("Hello World",
         modifier = Modifier.padding(top = 5.dp),
     style = TextStyle(color = MaterialTheme.colorScheme.onSecondaryContainer)
     )
 }

}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
 Greeting(name = "Pjuske")
}