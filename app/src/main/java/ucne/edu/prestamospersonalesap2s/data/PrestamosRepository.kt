package ucne.edu.prestamospersonalesap2s.data

import ucne.edu.prestamospersonalesap2s.Entity.Persona
import ucne.edu.prestamospersonalesap2s.Entity.Prestamo
import javax.inject.Inject

class PrestamosRepository @Inject constructor(
    val db: PrestamosDb
) {
    suspend fun insertPrestamo(prestamo: Prestamo) {
        db.daoPrestamos.insert(prestamo)
    }

    suspend fun updatePrestamo(prestamo: Prestamo) {
        db.daoPrestamos.modificar(prestamo)
    }

    suspend fun deletePrestamo(prestamo: Prestamo) {
        db.daoPrestamos.delete(prestamo)
    }

    suspend fun getPrestamo(prestamoId: Int) = db.daoPrestamos.getPrestamosById(prestamoId)

    fun getAll() = db.daoPrestamos.getPrestamos()
}