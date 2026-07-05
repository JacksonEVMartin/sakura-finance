package br.edu.utfpr.sakurafinance.view.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import br.edu.utfpr.sakurafinance.view.components.DatePickerSelect
import br.edu.utfpr.sakurafinance.view.components.TransactionTypeSelector


@Composable
fun HomeScreen(
  onNavigateToHistoryScreen: () -> Unit,
  onNavigateToAddTransactionScreen: () -> Unit,
  modifier: Modifier = Modifier
) {
  var selectedType by rememberSaveable() {
    mutableStateOf("Receita")
  }

  var amount by rememberSaveable() {
    mutableStateOf("")
  }
  var description by rememberSaveable() {
    mutableStateOf("")
  }

  var date by rememberSaveable {
    mutableStateOf("")
  }


  Column(
    modifier = modifier
      .fillMaxWidth()
      .padding(horizontal = 16.dp),
  ) {
    Column(
      modifier = modifier
        .fillMaxWidth()
        .padding(bottom = 24.dp),
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      Text("\uD83C\uDF38 Sakura Finance")
    }

    Column(
      modifier = modifier
        .fillMaxWidth()
        .padding(bottom = 24.dp),
    ) {
      Text("Olá, bem-vindo de volta! \uD83C\uDF38")
      Text("Vamos cuidar das suas finanças hoje?")
    }

    Card(
      modifier = modifier
        .fillMaxWidth()
    ) {
      Column(modifier = modifier.padding(16.dp)) {
        TransactionTypeSelector(
          selectedType = selectedType,
          modifier = modifier,
          onTypeSelected = {
            selectedType = it
          }
        )

        Column(modifier = modifier.padding(top = 24.dp)) {
          OutlinedTextField(
            value = amount,
            onValueChange = { amount = it },
            label = {
              Text("Valor")
            },
            placeholder = {
              Text("Ex.: R$ 100,00")
            },
            keyboardOptions = KeyboardOptions(
              keyboardType = KeyboardType.Decimal
            ),
            shape = RoundedCornerShape(12.dp),
            modifier = modifier
              .fillMaxWidth()
              .height(60.dp)
          )

          Column(modifier = modifier.padding(top = 8.dp)) {
            OutlinedTextField(
              value = description,
              onValueChange = { description = it },
              label = {
                Text("Descrição")
              },
              placeholder = {
                Text("Ex.: Mercado")
              },
              maxLines = 1,
              shape = RoundedCornerShape(12.dp),
              modifier = modifier
                .fillMaxWidth()
                .height(60.dp)
            )
          }
          DatePickerSelect(
            selectedDate = date,
            onDateSelected = {
              date = it
            }
          )
        }
      }
    }
  }
}

//Button(onNavigateToHistoryScreen) {
//  Text(
//    text = "HistoryScreen"
//  )
//}
//Button(onNavigateToAddTransactionScreen) {
//  Text(
//    text = "AddTransactionScreen"
//  )
//}