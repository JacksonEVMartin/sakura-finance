package br.edu.utfpr.sakurafinance.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "transactions")
data class TransactionEntity(
  @PrimaryKey(autoGenerate = true)
  val id: Int = 0,
  val description: String,
  val value: Double,
  val date: String,
  val type: String
)