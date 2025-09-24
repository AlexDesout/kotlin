package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation3.runtime.entry
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.example.myapplication.ui.InscriptionScreen
import com.example.myapplication.ui.ShrekScreen
import com.example.myapplication.ui.theme.MyApplicationTheme

data object ShrekDestination
data object InscriptionDestination
data object Destination3

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                val backStack = remember { mutableStateListOf<Any>(ShrekDestination) }
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text("Ma TopBar") },

                            actions = {
                                IconButton(onClick = { /* Handle favorite action */ }) {
                                    Icon(Icons.Default.FavoriteBorder, contentDescription = "Favorite")
                                }
                            },
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = Color(0xFFF0F0F8) // A light lavender color
                            )
                        )
                    },
                    containerColor = Color(0xFFF0F0F8) // A light lavender color
                ) { innerPadding ->
                    NavDisplay(
                        modifier = Modifier.padding(innerPadding),
                        backStack = backStack,
                        entryProvider = entryProvider {
                            entry<ShrekDestination> {
                                ShrekScreen(onInscriptionClick = {
                                    backStack.add(
                                        InscriptionDestination
                                    )
                                })
                            }
                            entry<InscriptionDestination> { InscriptionScreen(onRetourClick = {backStack.removeLastOrNull()}) }
                        }
                    )
                }
            }
        }
    }
}
