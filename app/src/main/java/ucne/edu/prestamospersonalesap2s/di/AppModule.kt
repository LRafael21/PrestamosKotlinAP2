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
    @Singleton
    @Provides
    fun providesDataBase(@ApplicationContext context: Context): PrestamosDb {
        return Room.databaseBuilder(
            context,
            PrestamosDb::class.java,
            "Prestamos.db"
        ).fallbackToDestructiveMigration().build()
    }


}