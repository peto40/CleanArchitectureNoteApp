package com.example.cleanarchitecturenoteapp.feature_note.domain.use_case

import com.example.cleanarchitecturenoteapp.feature_note.domain.model.Note
import com.example.cleanarchitecturenoteapp.feature_note.domain.repository.NoteRepository
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class DeleteNoteUseCase(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(note: Note){
        return repository.deleteNote(note = note)
    }
}