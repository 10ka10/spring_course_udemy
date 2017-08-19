package com.tenkaten.spring5webapp.bootstrap;

import com.tenkaten.spring5webapp.model.Author;
import com.tenkaten.spring5webapp.model.Book;
import com.tenkaten.spring5webapp.model.Publisher;
import com.tenkaten.spring5webapp.respositories.AuthorRepository;
import com.tenkaten.spring5webapp.respositories.BookRepository;
import com.tenkaten.spring5webapp.respositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    private void initData() {
        Author eric = new Author("Eric", "Evans");
        Publisher publisher1 = new Publisher("Harper Collins", "New York");
        Book ddd = new Book("Domain Driven Design", "1234", publisher1);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        publisherRepository.save(publisher1);
        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Publisher publisher2 = new Publisher("Worx", "Amsterdam");
        Book noEjb = new Book("J2EE Development without EJB", "2344", publisher2);
        rod.getBooks().add(noEjb);
        noEjb.getAuthors().add(rod);
        publisherRepository.save(publisher2);
        authorRepository.save(rod);
        bookRepository.save(noEjb);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }
}
