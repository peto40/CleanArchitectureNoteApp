package com.example.cleanarchitecturenoteapp.di

import android.app.Application
import android.provider.DocumentsContract.Root
import androidx.room.Room
import com.example.cleanarchitecturenoteapp.feature_note.data.data_source.NoteDatabase
import com.example.cleanarchitecturenoteapp.feature_note.data.data_source.NotedDao
import com.example.cleanarchitecturenoteapp.feature_note.data.repository.NoteRepositoryImpl
import com.example.cleanarchitecturenoteapp.feature_note.domain.repository.NoteRepository
import com.example.cleanarchitecturenoteapp.feature_note.domain.use_case.AddNoteUseCase
import com.example.cleanarchitecturenoteapp.feature_note.domain.use_case.DeleteNoteUseCase
import com.example.cleanarchitecturenoteapp.feature_note.domain.use_case.GetNoteUseCase
import com.example.cleanarchitecturenoteapp.feature_note.domain.use_case.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(dao = db.notedDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            GetNoteUseCase(repository = repository),
            DeleteNoteUseCase(repository = repository),
            AddNoteUseCase(repository = repository)
        )
    }
}