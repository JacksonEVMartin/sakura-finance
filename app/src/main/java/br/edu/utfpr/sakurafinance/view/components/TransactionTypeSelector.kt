package br.edu.utfpr.sakurafinance.view.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun TransactionTypeSelector(
  selectedType: String,
  onTypeSelected : (String) -> Unit,
  modifier: Modifier = Modifier
) {
  SingleChoiceSegmentedButtonRow(
    modifier = modifier
      .fillMaxWidth()
  ) {
    SegmentedButton(
      selected = selectedType == "Receita",
      onClick = {
        onTypeSelected ("Receita")
      },
      shape = SegmentedButtonDefaults.itemShape(
        index = 0,
        count = 2
      ),
    ) {
      Text("\uD83C\uDF38 Receita")
    }
    SegmentedButton(
      selected = selectedType == "Despesa",
      onClick = {
        onTypeSelected ("Despesa")
      },
      shape = SegmentedButtonDefaults.itemShape(
        index = 1,
        count = 2
      ),
    ) {
      Text("\uD83C\uDF42 Despesa")
    }
  }
}