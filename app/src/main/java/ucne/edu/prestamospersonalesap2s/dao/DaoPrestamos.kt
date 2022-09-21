package ucne.edu.prestamospersonalesap2s.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import ucne.edu.prestamospersonalesap2s.Entity.Persona
import ucne.edu.prestamospersonalesap2s.Entity.Prestamo

@Dao
interface DaoPrestamos  {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(prestamo: Prestamo)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun modificar (prestamo: Prestamo)


    @Delete
    suspend fun delete(prestamo: Prestamo)


    @Query("SELECT * FROM Prestamos")
    fun getPrestamos(): Flow<List<Prestamo>>


    @Query("SELECT * FROM Prestamos WHERE prestamoId = :id")
    suspend fun getPrestamosById(id:Int): Prestamo
}