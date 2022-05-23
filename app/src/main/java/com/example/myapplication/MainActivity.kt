package com.example.myapplication
import android.os.Bundle
import android.widget.ScrollView
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.Shapes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.*
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.ui.theme.Typography

import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHost
import androidx.navigation.NavHostController

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
                    Column {
                    TopNavBar()
                    Greeting("Zlatan")
                        Spacer(modifier = Modifier.height(120.dp))
                        Navbar()

                    }

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
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onBackground)
        }
        val painter = painterResource(id = R.drawable.flowers_image)
        val description = "Card image"
        BalanceInfo(painter = painter, contentDescription = description)
        ButtonLayout()
    }

}

@Composable
fun TopNavBar(){
 Column() { TopAppBar(
     title = {
         Text(text = "AppBar", color = MaterialTheme.colorScheme.onPrimary)
     },
         backgroundColor = MaterialTheme.colorScheme.primary,
     navigationIcon = {
         Icon(Icons.Filled.Menu, contentDescription = null, tint = MaterialTheme.colorScheme.onPrimary)

     }
     )
 }
}





@Composable
fun Navbar(){
    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf("Flowers", "Pots", "Settings", "Inbox")

    NavigationBar (modifier = Modifier.clip(MaterialTheme.shapes.medium)) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = { Icon(Icons.Filled.Favorite, contentDescription = null)  },
                label = { Text(item) },
                selected = selectedItem == index,
                onClick = { selectedItem = index },

            )
        }
    }
}





@Composable
fun ButtonLayout() {
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
            .height(60.dp)
        ,
        shape = MaterialTheme.shapes.medium,

        ) {
        Text(text = "SEND")

    }
}


@Composable
fun BalanceInfo(
    painter: Painter,
    contentDescription: String
) {
 Card(
     backgroundColor = MaterialTheme.colorScheme.secondaryContainer,
     modifier = Modifier
         .fillMaxWidth()
         .padding(top = 16.dp)
         .height(IntrinsicSize.Max)
         .clip(MaterialTheme.shapes.medium),
     shape = RoundedCornerShape(8.dp)
 ) {
     Box(modifier = Modifier
         .fillMaxSize()
     ){
         Column {
         Image(modifier = Modifier
             .clip(MaterialTheme.shapes.medium)
             .aspectRatio(2F),
             painter = painter,
             contentDescription = contentDescription,
             contentScale = ContentScale.Crop)
             Spacer(modifier = Modifier
                 .height(16.dp))
            Column (modifier = Modifier
                .padding(start = 16.dp)) {
                Text(text = "Zlatan",
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                fontSize = 30.sp
            )
            Text(text = "This is more Zlatan")
            }
             Spacer(modifier = Modifier.height(16.dp))
         }
     }
 }
}





@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
 Column {
     TopNavBar()
    Greeting(name = "Zlatan")
     Spacer(modifier = Modifier.height(120.dp))
     Navbar()

 }

}