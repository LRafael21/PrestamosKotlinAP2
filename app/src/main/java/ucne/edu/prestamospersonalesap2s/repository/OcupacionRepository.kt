package ucne.edu.prestamospersonalesap2s.repository

import ucne.edu.prestamospersonalesap2s.data.PrestamosDb
import ucne.edu.prestamospersonalesap2s.data.entity.Ocupacion
import javax.inject.Inject

class OcupacionRepository @Inject constructor(
    val db: PrestamosDb
) {
    suspend fun insertOcupacion(ocupacion: Ocupacion) {
        db.daoOcupaciones.insert(ocupacion)
    }


    suspend fun deleteOcupacion(ocupacion: Ocupacion) {
        db.daoOcupaciones.delete(ocupacion)
    }


    fun getAll() = db.daoOcupaciones.getOcupaciones()

    suspend fun getOcupacionesById(ocupacionId: Int) = db.daoOcupaciones.getOcupacionesById(ocupacionId)
}