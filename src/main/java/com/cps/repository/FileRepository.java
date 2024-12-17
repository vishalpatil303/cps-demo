package com.cps.repository;

import com.cps.model.File;
import org.springframework.data.repository.CrudRepository;

public interface FileRepository extends CrudRepository<File,Long> {
}
