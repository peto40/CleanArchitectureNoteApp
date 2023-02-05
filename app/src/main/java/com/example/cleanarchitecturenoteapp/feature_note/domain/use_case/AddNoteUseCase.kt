package com.example.cleanarchitecturenoteapp.feature_note.domain.use_case

import com.example.cleanarchitecturenoteapp.feature_note.domain.model.InvalidNoteException
import com.example.cleanarchitecturenoteapp.feature_note.domain.model.Note
import com.example.cleanarchitecturenoteapp.feature_note.domain.repository.NoteRepository

class AddNoteUseCase(private val repository: NoteRepository) {


    @kotlin.jvm.Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note){
        if (note.title.isBlank()){
            throw InvalidNoteException("The title of the note can't be empty!")
        }
        if (note.content.isBlank()){
            throw InvalidNoteException("The content of the note can't be empty!")
        }
        return repository.insertNote(note = note)
    }
}