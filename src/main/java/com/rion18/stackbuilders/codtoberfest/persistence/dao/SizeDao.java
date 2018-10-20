package com.rion18.stackbuilders.codtoberfest.persistence.dao;

import com.rion18.stackbuilders.codtoberfest.persistence.entity.Size;
import com.rion18.stackbuilders.codtoberfest.persistence.repository.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SizeDao extends GenericDao<Size, Long> {

  @Autowired
  public SizeDao(SizeRepository sizeRepository) {
    super(sizeRepository);
  }

  public Size findByName(String name) {
    return ((SizeRepository) repository).findByName(name);
  }

}
