package com.example.jockes.data.respository

import com.example.jockes.data.datasource.remote.JokeApi
import com.example.jockes.domain.repository.CategoryRepository
import java.io.IOException
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(private val categoryApi: JokeApi) :
    CategoryRepository {
    override suspend fun getCategories(): List<String> {
        try {
            val response = categoryApi.getCategories()
            if (response.isSuccessful) {
                val categories = response.body() ?: emptyList()

                return categories

            } else {
                throw Exception("Error al obtener categorías: ${response.code()}")
            }
        } catch (e: IOException) {
            // Manejo de errores de conexión de red (por ejemplo, tiempo de espera agotado)
            throw Exception("Error de conexión: ${e.message}")
        } catch (e: Exception) {
            // Manejo de errores generales, como un JSON mal formado
            throw Exception("Error inesperado: ${e.message}")
        }
    }

}


