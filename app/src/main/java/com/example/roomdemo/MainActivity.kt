package com.example.roomdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.room.Entity
import com.example.roomdemo.ui.theme.RoomDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RoomDemoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ScreenSetup(modifier = Modifier.padding(innerPadding))
                }
            }

        }
    }
}
@Preview(showSystemUi = true)
@Composable
fun ScreenSetup(modifier: Modifier = Modifier) {
    MainScreen(modifier)
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    var productName by rememberSaveable { mutableStateOf("") }
    var quantity by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        OutlinedTextField(
            value = productName,
            onValueChange = { productName = it },
            label = { Text("Product Name") },
            textStyle = LocalTextStyle.current.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = quantity,
            onValueChange = { quantity = it },
            label = { Text("Quantity") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            textStyle = LocalTextStyle.current.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(20.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            val buttonColors = buttonColors(containerColor = Color(0xFF6050DC))
            val buttonModifier = Modifier
                .size(width = 93.dp, height = 38.dp)
                .padding(horizontal = 1.dp)

            Button(
                onClick = {},
                colors = buttonColors,
                shape = RoundedCornerShape(20.dp),
                modifier = buttonModifier
            ) {
                Text("Add",fontSize = 13.sp)
            }
            Button(
                onClick = {},
                colors = buttonColors,
                shape = RoundedCornerShape(20.dp),
                modifier = buttonModifier
            ) {
                Text("Search",fontSize = 13.sp)
            }
            Button(
                onClick = {},
                colors = buttonColors,
                shape = RoundedCornerShape(20.dp),
                modifier = buttonModifier
            ) {
                Text("Delete",fontSize = 13.sp)
            }
            Button(
                onClick = {},
                colors = buttonColors,
                shape = RoundedCornerShape(20.dp),
                modifier = buttonModifier
            ) {
                Text("Clear",fontSize = 13.sp)
            }
        }

        Spacer(modifier = Modifier.height(20.dp))


    }
}

