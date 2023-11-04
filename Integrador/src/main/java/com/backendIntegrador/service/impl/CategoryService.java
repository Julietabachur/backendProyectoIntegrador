package com.backendIntegrador.service.impl;

import com.backendIntegrador.model.Category;
import com.backendIntegrador.repository.CategoryRepository;
import com.backendIntegrador.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    @Transactional
    public Category save(Category category) throws Exception {
        try {
            Category existingCategory = categoryRepository.findByCategoryName(category.getCategoryName());
            if (existingCategory != null) {
                // La categoría ya existe, puedes manejarlo según tus necesidades, como lanzar una excepción o actualizar la categoría existente.
                // Por ejemplo, para lanzar una excepción, puedes hacer lo siguiente:
                throw new Exception("La categoría ya existe en la base de datos.");
            } else {
                // La categoría no existe, puedes guardarla y retornarla.
                categoryRepository.save(category);
                return category;
            }
        } catch (Exception e) {
            // Maneja la excepción de manera apropiada, por ejemplo, registrándola o lanzando una excepción personalizada.
            throw new Exception("Error al guardar la categoría: " + e.getMessage());
        }
    }


    @Override
    public boolean delete( String id ) throws Exception {
        try {
            if (categoryRepository.existsById(id)) {
                categoryRepository.deleteById(id);
                return true;
            }

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return false;
    }

    @Override
    public Page<Category> findAll( Pageable pageable ) throws Exception {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public Category getCategoryById( String id ) throws Exception {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public Category getCategoryByCategoryName( String categoryName ) {
        return categoryRepository.findByCategoryName(categoryName);
    }

    @Override
    public boolean checkCategoryName( String categoryName ) {
        Category existingCategory = categoryRepository.findByCategoryName(categoryName);
        return existingCategory == null;
    }

    @Override
    public Category update( Category category ) throws Exception {
        try {
            Category existingCategory = categoryRepository.findById(category.getId()).orElse(null);

            if (existingCategory != null) {
                existingCategory.setCategoryName(category.getCategoryName());
                existingCategory.setDescription(category.getDescription());
                existingCategory.setImageUrl(category.getImageUrl());

                return categoryRepository.save(existingCategory);
            } else {
                throw new RuntimeException("La categoria no se encontró para la actualización");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
