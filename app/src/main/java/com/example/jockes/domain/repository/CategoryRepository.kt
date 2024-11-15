package com.example.jockes.domain.repository

interface CategoryRepository {

   suspend fun getCategories(): List<String>
}