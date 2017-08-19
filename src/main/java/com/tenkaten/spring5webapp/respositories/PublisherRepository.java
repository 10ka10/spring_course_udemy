package com.tenkaten.spring5webapp.respositories;

import com.tenkaten.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
