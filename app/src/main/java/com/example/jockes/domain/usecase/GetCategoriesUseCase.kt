package com.example.jockes.domain.usecase

import com.example.jockes.domain.repository.CategoryRepository
import javax.inject.Inject

class GetCategoriesUseCase @Inject() constructor(private val repository: CategoryRepository)  {

    suspend operator fun invoke(): List<String> {
        return repository.getCategories()

    }
}