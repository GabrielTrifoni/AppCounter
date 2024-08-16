package com.example.appcounter

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appcounter.ui.theme.AppCounterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppCounterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFB4D6CD)
                ) {
                    CountingButtons()
                }
            }
        }
    }
}

@Composable
fun CountingButtons() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        // Upper button
        CountingButton(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            color = Color(0xFFFFDA76)
        )

        // Lower button
        CountingButton(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            color = Color(0xFFFF4E88)
        )
    }
}

@Composable
fun CountingButton(modifier: Modifier = Modifier, color: Color) {
    // State to hold the counter value
    var count by remember { mutableIntStateOf(0) }

    // Button with an onClick listener to increment the counter
    Button(
        onClick = { count++ },
        colors = androidx.compose.material3.ButtonDefaults.buttonColors(containerColor = color),
        shape = RoundedCornerShape(16.dp),
        modifier = modifier
            .padding(8.dp)
            .fillMaxSize()
    ) {
        Text(
            text = "$count",
            fontSize = 128.sp  // Set the font size here
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AppCounterTheme {
        CountingButtons()
    }
}
