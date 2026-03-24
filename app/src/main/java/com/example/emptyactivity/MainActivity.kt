package com.example.emptyactivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
                    PreferencesUtilisateur(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun PreferencesUtilisateur(modifier: Modifier = Modifier) {
    var notifications by remember { mutableStateOf(false) }
    var newsletter by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {

        // Switch Notifications
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Activer notifications")
            Row(verticalAlignment = Alignment.CenterVertically) {
                Switch(
                    checked = notifications,
                    onCheckedChange = { notifications = it }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(if (notifications) "ON" else "OFF")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Checkbox Newsletter
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Recevoir newsletter")
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = newsletter,
                    onCheckedChange = { newsletter = it }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(if (newsletter) "Coché" else "Décoché")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreferencesPreview() {
    EmptyActivityTheme {
        PreferencesUtilisateur()
    }
}