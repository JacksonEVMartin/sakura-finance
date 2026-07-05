package br.edu.utfpr.sakurafinance.repository

import br.edu.utfpr.sakurafinance.data.TransactionDao
import br.edu.utfpr.sakurafinance.data.TransactionEntity

class TransactionRepository(
  private val dao: TransactionDao
) {

  val transactions = dao.getAllTransactions()

  suspend fun insert(
    transaction: TransactionEntity
  ) {
    dao.insert(transaction)
  }
}