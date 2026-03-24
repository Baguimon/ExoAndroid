package com.example.emptyactivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
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
                ListeTaches()
            }
        }
    }
}

// Modèle de données
data class Tache(val titre: String, val description: String)

@Composable
fun ListeTaches() {
    val taches = listOf(
        Tache("Courses", "Acheter du lait et du pain"),
        Tache("Sport", "Aller à la salle"),
        Tache("Travail", "Finir le projet"),
        Tache("Ménage", "Nettoyer la chambre"),
        Tache("Lecture", "Lire 20 pages")
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(taches) { tache ->
            CarteTache(tache)
        }
    }
}

@Composable
fun CarteTache(tache: Tache) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 12.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = tache.titre)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = tache.description)

            Spacer(modifier = Modifier.height(12.dp))

            Button(onClick = { /* Action terminé */ }) {
                Text("Terminé")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListeTachesPreview() {
    EmptyActivityTheme {
        ListeTaches()
    }
}