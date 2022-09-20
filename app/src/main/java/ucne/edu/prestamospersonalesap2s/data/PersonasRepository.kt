package ucne.edu.prestamospersonalesap2s.data

import ucne.edu.prestamospersonalesap2s.Entity.Ocupacion
import ucne.edu.prestamospersonalesap2s.Entity.Persona
import javax.inject.Inject

class PersonasRepository @Inject constructor(
    val db: PrestamosDb
) {
    suspend fun insertPersona(persona: Persona) {
        db.daoPersonas.insert(persona)
    }

   suspend fun updatePersona(persona: Persona) {
        db.daoPersonas.modificar(persona)
    }

    suspend fun deletePersona(persona: Persona) {
        db.daoPersonas.delete(persona)
    }

    suspend fun getPersona(personaId: Int) = db.daoPersonas.getPersonasById(personaId)

    fun getAll() = db.daoPersonas.getPersonas()
}