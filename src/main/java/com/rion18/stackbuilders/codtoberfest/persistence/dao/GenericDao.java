package com.rion18.stackbuilders.codtoberfest.persistence.dao;

import com.rion18.stackbuilders.codtoberfest.persistence.entity.EntityBase;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

abstract class GenericDao<T extends EntityBase, PK> {

  protected final JpaRepository<T, PK> repository;

  GenericDao(JpaRepository<T, PK> repository) {
    this.repository = repository;
  }

  public List<T> findAll() {
    return repository.findAll();
  }

  public T findById(PK id) {
    Optional<T> optional = repository.findById(id);
    return optional.orElse(null);
  }

  public T save(T entity) {
    return repository.save(entity);
  }
}
