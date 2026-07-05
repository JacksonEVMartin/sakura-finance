package br.edu.utfpr.sakurafinance.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.edu.utfpr.sakurafinance.data.TransactionEntity
import br.edu.utfpr.sakurafinance.repository.TransactionRepository
import kotlinx.coroutines.launch

class TransactionViewModel (
  private val repository: TransactionRepository
) : ViewModel() {
  val transactions = repository.transactions

  fun saveTransaction(
    description: String,
    value: Double,
    date: String,
    type: String
  ) {
    viewModelScope.launch {
      repository.insert(
        TransactionEntity(
          description = description,
          value = value,
          date = date,
          type = type,
        )
      )
    }
  }
}
