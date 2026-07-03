package br.edu.utfpr.sakurafinance.view.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun HomeScreen(
  onNavigateToHistoryScreen: () -> Unit,
  onNavigateToAddTransactionScreen: () -> Unit,
) {
  Column() {
    Text(
      text = "HomeScreen"
    )
    Button(onNavigateToHistoryScreen) {
      Text(
        text = "HistoryScreen"
      )
    }
    Button(onNavigateToAddTransactionScreen) {
      Text(
        text = "AddTransactionScreen"
      )
    }
  }
}