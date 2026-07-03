package br.edu.utfpr.sakurafinance.view.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun AddTransactionScreen(onBackClick: () -> Unit) {
  Column() {
    Text(
      text = "AddTransactionScreen"
    )
    Button(onBackClick) {
      Text(
        text = "Voltar"
      )
    }
  }
}