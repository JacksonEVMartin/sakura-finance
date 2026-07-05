package br.edu.utfpr.sakurafinance.view.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.edu.utfpr.sakurafinance.data.TransactionEntity
import br.edu.utfpr.sakurafinance.model.Transaction

@Composable
fun TransactionItem(
  transaction: TransactionEntity,
  modifier: Modifier = Modifier
) {
  Card(
    modifier = modifier
      .fillMaxWidth()
      .padding(vertical = 8.dp)
  ) {
    Row(
      modifier = modifier
        .fillMaxWidth()
        .padding(16.dp)
    ) {
      Column(
        modifier = modifier
          .weight(1F),
      ) {
        Text(text = transaction.type)
        Text(text = transaction.description)
      }
      Column(
        modifier = modifier
          .weight(1F),
        horizontalAlignment = Alignment.End
      ) {
        Text(text = "R$ %.2f".format(transaction.value))
      }
    }
  }
}
