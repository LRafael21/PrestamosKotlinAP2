package ucne.edu.prestamospersonalesap2s.data

import android.content.Context

class Repository(var context: Context) {
    fun getOcupacionesDao() = PrestamosDb.getInstance(context).DaoOcupaciones
    fun getPersonasDao() = PrestamosDb.getInstance(context).DaoOcupaciones
}