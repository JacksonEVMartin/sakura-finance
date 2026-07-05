package br.edu.utfpr.sakurafinance

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.edu.utfpr.sakurafinance.ui.theme.SakuraFinanceTheme
import br.edu.utfpr.sakurafinance.view.screens.AddTransactionScreen
import br.edu.utfpr.sakurafinance.view.screens.HistoryScreen
import br.edu.utfpr.sakurafinance.view.screens.HomeScreen

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      SakuraFinanceTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
          val navController = rememberNavController()

          NavHost(
            navController,
            startDestination = "home",
            modifier = Modifier.padding(innerPadding)
          ) {
            composable("home") {
              HomeScreen(
                onNavigateToHistoryScreen = {
                  navController.navigate("history")
                },
                onNavigateToAddTransactionScreen = {
                  navController.navigate("addTransaction")
                },
              )
            }

            composable("history") {
              HistoryScreen(
                onBackClick = {
                  navController.popBackStack()
                }
              )
            }

            composable("addTransaction") {
              AddTransactionScreen(
                onBackClick = {
                  navController.popBackStack()
                }
              )
            }
          }
        }
      }
    }
  }
}
