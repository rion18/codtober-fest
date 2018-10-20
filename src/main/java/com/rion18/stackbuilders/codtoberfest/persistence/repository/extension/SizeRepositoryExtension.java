package com.rion18.stackbuilders.codtoberfest.persistence.repository.extension;

import com.rion18.stackbuilders.codtoberfest.persistence.entity.Size;

public interface SizeRepositoryExtension {

  Size findByName(String name);

}
