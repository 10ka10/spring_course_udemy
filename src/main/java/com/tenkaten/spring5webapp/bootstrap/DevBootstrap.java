package com.tenkaten.spring5webapp.bootstrap;

import com.tenkaten.spring5webapp.model.Author;
import com.tenkaten.spring5webapp.model.Book;
import com.tenkaten.spring5webapp.respositories.AuthorRepository;
import com.tenkaten.spring5webapp.respositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    private void initData() {
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", "Harper Collins");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEjb = new Book("J2EE Development without EJB", "2344", "Worx");
        rod.getBooks().add(noEjb);
        noEjb.getAuthors().add(rod);
        authorRepository.save(rod);
        bookRepository.save(noEjb);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }
}
