package ucne.edu.prestamospersonalesap2s.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Personas")
data class Persona(
    @PrimaryKey(autoGenerate = true)
    val personaId: Int = 0,
    val nombres: String,
    val telefono: String,
    val celular: String,
    val email: String,
    val direccion: String,
    val fechaNacimiento: String,
    val ocupacionId: Int = 0
    //val ocupacionId : Ocupacion

)