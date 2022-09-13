package ucne.edu.prestamospersonalesap2s.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ucne.edu.prestamospersonalesap2s.data.PrestamosDb
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Volatile
    private var INSTANCE: PrestamosDb.PrestamoDb? = null

    fun getInstance(context: Context): PrestamosDb.PrestamoDb {
        synchronized(this) {
            var instance = INSTANCE

            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    PrestamosDb.PrestamoDb::class.java,
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