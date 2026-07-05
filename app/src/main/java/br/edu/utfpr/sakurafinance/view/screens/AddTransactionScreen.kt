package br.edu.utfpr.sakurafinance.view.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.edu.utfpr.sakurafinance.view.components.TransactionItem
import br.edu.utfpr.sakurafinance.viewModel.TransactionViewModel
import kotlin.collections.emptyList

@Composable
fun AddTransactionScreen(
  viewModel: TransactionViewModel,
  onBackClick: () -> Unit,
  modifier: Modifier = Modifier
) {
  val transactions by viewModel.transactions.collectAsState(
    initial = emptyList()
  )

  val totalCredit =
    transactions
      .filter { it.type == "Receita" }
      .sumOf { it.value }

  val totalDebit =
    transactions
      .filter { it.type == "Despesa" }
      .sumOf { it.value }

  val balance = totalCredit - totalDebit

  Column(modifier = modifier.padding(16.dp)) {
    Card(
      modifier = modifier
        .fillMaxWidth()
    ) {
      Column(
        modifier = modifier
          .fillMaxWidth()
          .padding(20.dp)
      ) {
        Column(
          modifier = modifier
            .fillMaxWidth(),
          horizontalAlignment = Alignment.CenterHorizontally
        ) {
          Text("Saldo Atual")
          Text(text = "R$ %.2f".format(balance))
        }
        Box(
          modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 24.dp)
            .fillMaxWidth()
            .height(1.dp)
            .background(MaterialTheme.colorScheme.outlineVariant)
        )
        Row(
          modifier = modifier
            .fillMaxWidth()
        ) {
          Column(
            modifier = modifier
              .weight(1F),
            horizontalAlignment = Alignment.CenterHorizontally
          ) {
            Text("Credito")
            Text(text = "R$ %.2f".format(totalCredit))
          }
          Box(
            modifier = Modifier
              .padding(horizontal = 16.dp)
              .width(1.dp)
              .height(50.dp)
              .background(MaterialTheme.colorScheme.outlineVariant)
          )
          Column(
            modifier = modifier
              .weight(1F),
            horizontalAlignment = Alignment.CenterHorizontally
          ) {
            Text("Debito")
            Text(text = "R$ %.2f".format(totalDebit))
          }
        }
      }
    }

    Text(
      text = "Lançamentos",
      modifier = Modifier.padding(top = 24.dp)
    )

    if (transactions.isEmpty()) {
      Box(
        modifier = Modifier
          .fillMaxWidth()
          .weight(1f),
        contentAlignment = Alignment.Center
      ) {
        Text("Nenhum lançamento cadastrado 🌸")
      }
    } else {
      LazyColumn(
        modifier = Modifier
          .weight(1f)
      ) {
        items(transactions) { transaction ->
          TransactionItem(transaction)
        }
      }
    }

    Button(
      onClick = onBackClick,
      modifier = modifier
        .fillMaxWidth()
        .padding(top = 16.dp)
    ) {
      Text("Voltar")
    }
  }
}
