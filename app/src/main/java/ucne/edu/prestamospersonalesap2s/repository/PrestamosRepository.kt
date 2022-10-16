package ucne.edu.prestamospersonalesap2s.repository

import ucne.edu.prestamospersonalesap2s.data.PrestamosDb
import ucne.edu.prestamospersonalesap2s.data.entity.Prestamo
import javax.inject.Inject

class PrestamosRepository @Inject constructor(
    val db: PrestamosDb
) {
    suspend fun insertPrestamo(prestamo: Prestamo) {
        db.daoPrestamos.insert(prestamo)
    }

    suspend fun deletePrestamo(prestamo: Prestamo) {
        db.daoPrestamos.delete(prestamo)
    }


    fun getAll() = db.daoPrestamos.getPrestamos()

    suspend fun getPrestamosById(prestamoId: Int) = db.daoPrestamos.getPrestamosById(prestamoId)
}