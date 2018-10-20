package com.rion18.stackbuilders.codtoberfest.persistence.repository.extension;

import com.rion18.stackbuilders.codtoberfest.persistence.entity.Size;
import com.rion18.stackbuilders.codtoberfest.persistence.repository.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class SizeRepositoryExtensionImpl implements SizeRepositoryExtension {

  @Autowired
  SizeRepository sizeRepository;

  @Override
  public Size findByName(String name) {
    // TODO add custom methods.
    return null;
  }
}
