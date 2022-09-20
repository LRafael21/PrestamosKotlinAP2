package ucne.edu.prestamospersonalesap2s.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import ucne.edu.prestamospersonalesap2s.Entity.Ocupacion
import ucne.edu.prestamospersonalesap2s.Entity.Persona

@Dao
interface DaoPersonas  {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(persona: Persona)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun modificar (persona: Persona)


    @Delete
    suspend fun delete(persona: Persona)


    @Query("SELECT * FROM Personas")
    fun getPersonas(): Flow<List<Persona>>


    @Query("SELECT * FROM Personas WHERE personaId = :id")
    suspend fun getPersonasById(id:Int): Persona
}