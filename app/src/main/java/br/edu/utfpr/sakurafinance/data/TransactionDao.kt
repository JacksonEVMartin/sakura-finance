package br.edu.utfpr.sakurafinance.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TransactionDao{
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun  insert(
    transaction: TransactionEntity
  )

  @Query("SELECT * FROM transactions ORDER BY id DESC")
  fun getAllTransactions(): Flow<List<TransactionEntity>>
}