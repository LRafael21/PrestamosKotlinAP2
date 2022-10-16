package ucne.edu.prestamospersonalesap2s.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ucne.edu.prestamospersonalesap2s.data.entity.Ocupacion
import ucne.edu.prestamospersonalesap2s.data.entity.Persona
import ucne.edu.prestamospersonalesap2s.data.entity.Prestamo
import ucne.edu.prestamospersonalesap2s.dao.DaoOcupaciones
import ucne.edu.prestamospersonalesap2s.dao.DaoPersonas
import ucne.edu.prestamospersonalesap2s.dao.DaoPrestamos

@Database(
    entities = [Ocupacion::class, Persona::class, Prestamo::class] ,
    version = 4,
    exportSchema = false
)
abstract class PrestamosDb: RoomDatabase(){
    abstract val daoOcupaciones: DaoOcupaciones
    abstract val daoPersonas: DaoPersonas
    abstract val daoPrestamos: DaoPrestamos

}
