package ucne.edu.prestamospersonalesap2s.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ucne.edu.prestamospersonalesap2s.Entity.Ocupacion
import ucne.edu.prestamospersonalesap2s.Entity.Persona
import ucne.edu.prestamospersonalesap2s.dao.DaoOcupaciones
import ucne.edu.prestamospersonalesap2s.dao.DaoPersonas

@Database(
    entities = [Ocupacion::class, Persona::class] ,
    version = 2,
    exportSchema = false
)
abstract class PrestamosDb: RoomDatabase(){
    abstract val daoOcupaciones: DaoOcupaciones
    abstract val daoPersonas: DaoPersonas

    companion object {
        @Volatile
        private var INSTANCE: PrestamosDb? = null
        fun getInstance(context: Context): PrestamosDb {
            synchronized(this) {
                var instance = INSTANCE

                if(instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        PrestamosDb::class.java,
                        "Prestamos.db"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
