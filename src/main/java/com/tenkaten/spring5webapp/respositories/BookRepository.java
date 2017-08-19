package com.tenkaten.spring5webapp.respositories;

import com.tenkaten.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
