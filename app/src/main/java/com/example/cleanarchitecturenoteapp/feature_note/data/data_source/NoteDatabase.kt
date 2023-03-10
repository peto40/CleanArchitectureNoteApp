package com.example.cleanarchitecturenoteapp.feature_note.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cleanarchitecturenoteapp.feature_note.domain.model.Note

@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase: RoomDatabase() {

    abstract val notedDao: NotedDao

    companion object {
        const val DATABASE_NAME = "name_db"
    }
}