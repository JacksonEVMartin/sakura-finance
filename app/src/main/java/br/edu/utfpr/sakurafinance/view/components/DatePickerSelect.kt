package br.edu.utfpr.sakurafinance.view.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerSelect(
  selectedDate: String,
  onDateSelected: (String) -> Unit,
  modifier: Modifier = Modifier
) {

  var showDatePicker by remember {
    mutableStateOf(false)
  }

  val datePickerState = rememberDatePickerState()

  val interactionSource = remember {
    MutableInteractionSource()
  }

  val isPressed by interactionSource.collectIsPressedAsState()

  if (isPressed) {
    showDatePicker = true
  }

  OutlinedTextField(
    value = selectedDate,
    onValueChange = {},
    readOnly = true,
    interactionSource = interactionSource,
    label = {
      Text("Data")
    },
    placeholder = {
      Text("Selecione a data")
    },
    trailingIcon = {
      Icon(
        imageVector = Icons.Default.DateRange,
        contentDescription = null
      )
    },
    shape = RoundedCornerShape(12.dp),
    modifier = modifier
      .fillMaxWidth()
      .height(60.dp),
    colors = OutlinedTextFieldDefaults.colors()
  )
  if (showDatePicker) {
    DatePickerDialog(
      onDismissRequest = {
        showDatePicker = false
      },
      confirmButton = {
        TextButton(
          onClick = {
            datePickerState.selectedDateMillis?.let {
              val formatter = SimpleDateFormat(
                "dd/MM/yyyy",
                Locale("pt", "BR")
              )
              onDateSelected(
                formatter.format(Date(it))
              )
            }
            showDatePicker = false
          }
        ) {
          Text("OK")
        }
      },
      dismissButton = {
        TextButton(
          onClick = {
            showDatePicker = false
          }
        ) {
          Text("Cancelar")
        }
      }
    ) {
      DatePicker(
        state = datePickerState
      )
    }
  }

}