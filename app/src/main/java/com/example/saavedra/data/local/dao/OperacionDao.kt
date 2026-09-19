package com.example.saavedra.data.local.dao

import androidx.room.*
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.saavedra.data.local.entity.OperacionEntity

@Dao
interface OperacionDao{
    @Insert
    suspend fun insertar(
        operacion: OperacionEntity
    ) : Long
    @Query(
        """
        SELECT * FROM operaciones
        ORDER BY fecha DESC
        """
    )
    suspend fun obtenerTodas():
            List<OperacionEntity>

    @Query("DELETE FROM operaciones")
    suspend fun eliminarTodas()

    @Delete
    suspend fun eliminar(operacion: OperacionEntity)
}