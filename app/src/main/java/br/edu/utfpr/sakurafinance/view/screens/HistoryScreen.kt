package br.edu.utfpr.sakurafinance.view.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun HistoryScreen(onBackClick: () -> Unit) {
  Column() {
    Text(
      text = "HistoryScreen"
    )
    Button(onBackClick) {
      Text(
        text = "Voltar"
      )
    }
  }
}