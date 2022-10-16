package ucne.edu.prestamospersonalesap2s.repository

import ucne.edu.prestamospersonalesap2s.data.PrestamosDb
import ucne.edu.prestamospersonalesap2s.data.entity.Persona
import javax.inject.Inject

class PersonasRepository @Inject constructor(
    val db: PrestamosDb
) {
    suspend fun insertPersona(persona: Persona) {
        db.daoPersonas.insert(persona)
    }

    suspend fun deletePersona(persona: Persona) {
        db.daoPersonas.delete(persona)
    }


    fun getAll() = db.daoPersonas.getPersonas()

    suspend fun getPersonaById(personaId: Int) = db.daoPersonas.getPersonasById(personaId)
}