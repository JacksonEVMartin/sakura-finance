package br.edu.utfpr.sakurafinance.model

data class Transaction(
  val description: String,
  val value: Double,
  val type: String
)