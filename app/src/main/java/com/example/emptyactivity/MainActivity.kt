package com.example.emptyactivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
                    ChoixCouleur(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun ChoixCouleur(modifier: Modifier = Modifier) {
    var couleur by remember { mutableStateOf(Color.Red) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // Carré coloré
        Box(
            modifier = Modifier
                .size(150.dp)
                .background(couleur)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Boutons
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(onClick = { couleur = Color.Red }) {
                Text("Rouge")
            }
            Button(onClick = { couleur = Color.Green }) {
                Text("Vert")
            }
            Button(onClick = { couleur = Color.Blue }) {
                Text("Bleu")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChoixCouleurPreview() {
    EmptyActivityTheme {
        ChoixCouleur()
    }
}