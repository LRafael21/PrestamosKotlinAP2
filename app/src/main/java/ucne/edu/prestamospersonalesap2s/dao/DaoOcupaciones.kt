package ucne.edu.prestamospersonalesap2s.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import ucne.edu.prestamospersonalesap2s.Entity.Ocupacion

@Dao
interface DaoOcupaciones {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(Ocupacion: Ocupacion)


    @Delete
    suspend fun delete(Ocupacion: Ocupacion)


    @Query("SELECT * FROM Ocupaciones")
    fun getOcupaciones(): Flow<List<Ocupacion>>


    @Query("SELECT * FROM Ocupaciones WHERE Id = :id")
    suspend fun getOcupacionesById(id:Int): Ocupacion?
}