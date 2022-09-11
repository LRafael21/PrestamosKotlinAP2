package ucne.edu.prestamospersonalesap2s.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Ocupaciones")
data class Ocupacion (
    @PrimaryKey(autoGenerate = true)
    val Id: Int = 0,
    val descripcion: String,
    val salario: Double
)