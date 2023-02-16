package `in`.nareshtechnologies.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(color = Color.Yellow),
                horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween) {
                Button(modifier = Modifier.fillMaxWidth(),onClick = { /*TODO*/ }) {
                    Text(text = "Plus")
                }

                Text(text = "0", fontSize = 100.sp, fontStyle = FontStyle.Italic)
                
                Button(modifier = Modifier.fillMaxWidth(),onClick = { /*TODO*/ }) {
                    Text(text = "minus")
                }
            }
        }
    }
}

