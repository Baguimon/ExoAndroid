package com.example.emptyactivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.emptyactivity.ui.theme.EmptyActivityTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EmptyActivityTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MeteoRow(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MeteoRow(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.Info,
            contentDescription = "Info"
        )
        Text(text = "24°C")
        Text(text = "Ensoleillé")
    }
}

@Preview(showBackground = true)
@Composable
fun MeteoPreview() {
    EmptyActivityTheme {
        MeteoRow()
    }
}