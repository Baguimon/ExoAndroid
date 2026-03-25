package com.example.emptyactivity

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase
import kotlinx.coroutines.flow.Flow

@Entity
data class Task(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String
)

@Dao
interface TaskDao {
    @Query("SELECT * FROM Task")
    fun getAll(): Flow<List<Task>>

    @Insert
    suspend fun insert(task: Task)

    @Delete
    suspend fun delete(task: Task)
}

@Database(entities = [Task::class], version = 1)
abstract class AppDb : RoomDatabase() {
    abstract fun dao(): TaskDao
}