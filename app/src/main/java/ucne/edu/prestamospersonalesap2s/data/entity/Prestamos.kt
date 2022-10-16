package ucne.edu.prestamospersonalesap2s.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Prestamos")
data class Prestamo(
    @PrimaryKey(autoGenerate = true)
    val prestamoId: Int = 0,
    val fecha: String,
    val vence: String,
    val personaId: Int = 0,
    val concepto: String,
    val monto: Double,
    val balance: Double,

)