package br.edu.utfpr.sakurafinance

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import br.edu.utfpr.sakurafinance.data.AppDatabase
import br.edu.utfpr.sakurafinance.repository.TransactionRepository
import br.edu.utfpr.sakurafinance.ui.theme.SakuraFinanceTheme
import br.edu.utfpr.sakurafinance.view.screens.AddTransactionScreen
import br.edu.utfpr.sakurafinance.view.screens.HomeScreen
import br.edu.utfpr.sakurafinance.viewModel.TransactionViewModel
import br.edu.utfpr.sakurafinance.viewModel.TransactionViewModelFactory

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      val database = Room.databaseBuilder(
        applicationContext,
        AppDatabase::class.java,
        "sakura_finace"
      ).build()

      val dao = database.transactionDao()
      val repository = TransactionRepository(dao)

      val viewModel: TransactionViewModel = viewModel(
        factory = TransactionViewModelFactory(repository)
      )

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
                viewModel = viewModel,
                onNavigateToAddTransactionScreen = {
                  navController.navigate("addTransaction")
                },
              )
            }

            composable("addTransaction") {
              AddTransactionScreen(
                viewModel = viewModel,
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
