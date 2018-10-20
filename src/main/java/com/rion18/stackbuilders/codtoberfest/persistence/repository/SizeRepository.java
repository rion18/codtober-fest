package com.rion18.stackbuilders.codtoberfest.persistence.repository;

import com.rion18.stackbuilders.codtoberfest.persistence.entity.Size;
import com.rion18.stackbuilders.codtoberfest.persistence.repository.extension.SizeRepositoryExtension;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SizeRepository extends CrudRepository<Size, Long>, SizeRepositoryExtension {


}
