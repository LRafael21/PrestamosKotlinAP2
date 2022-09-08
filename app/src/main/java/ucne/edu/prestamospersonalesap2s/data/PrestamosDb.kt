package ucne.edu.prestamospersonalesap2s.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ucne.edu.prestamospersonalesap2s.Entity.Ocupacion
import ucne.edu.prestamospersonalesap2s.dao.DaoOcupaciones

class PrestamosDb {

    @Database(
        entities = [Ocupacion::class],
        version = 1,
        exportSchema = false
    )

    abstract class PrestamoDb : RoomDatabase() {
        abstract val DaoOcupaciones: DaoOcupaciones
    }

    companion object {

        @Volatile
        private var INSTANCE: PrestamoDb? = null

        fun getInstance(context: Context): PrestamoDb {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        PrestamoDb::class.java,
                        "Prestamos.Db"
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