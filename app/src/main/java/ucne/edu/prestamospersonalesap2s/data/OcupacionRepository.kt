package ucne.edu.prestamospersonalesap2s.data

import ucne.edu.prestamospersonalesap2s.Entity.Ocupacion
import javax.inject.Inject

class OcupacionRepository @Inject constructor(
    val db: PrestamosDb
) {
    suspend fun insertOcupacion(ocupacion: Ocupacion) {
        db.daoOcupaciones.insert(ocupacion)
    }

    suspend fun updateOcupacion(ocupacion: Ocupacion) {
        db.daoOcupaciones.modificar(ocupacion)
    }

    suspend fun deleteOcupacion(ocupacion: Ocupacion) {
        db.daoOcupaciones.delete(ocupacion)
    }

    suspend fun getOcupaciones(ocupacionId: Int) = db.daoOcupaciones.getOcupacionesById(ocupacionId)

    fun getAll() = db.daoOcupaciones.getOcupaciones()
}