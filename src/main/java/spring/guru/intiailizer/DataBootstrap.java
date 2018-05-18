/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.guru.intiailizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import spring.guru.model.Author;
import spring.guru.model.Book;
import spring.guru.model.Publisher;
import spring.guru.repository.AuthorRepo;
import spring.guru.repository.BookRepo;
import spring.guru.repository.PublisherRepo;

/**
 *
 * @author Ali Mujthaba
 */
@Component
public class DataBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    
    @Autowired
    private AuthorRepo authorRepo;
    
    @Autowired
    private BookRepo bookRepo;
    
    @Autowired
    private PublisherRepo publisherRepo;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent e) {
        initData();
    }

    private void initData() {
        
        Publisher pub1 = new Publisher("CGN", "11B, Baker Street");
        Publisher pub2 = new Publisher("Oxford", "11A, Baker Street");
        
        publisherRepo.save(pub1);
        publisherRepo.save(pub2);

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "999-009-111", pub1);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        
        authorRepo.save(eric);
        bookRepo.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book ejb = new Book("J2EE Development", "888-001-111", pub2);
        rod.getBooks().add(ejb);
        ejb.getAuthors().add(rod);
        
        authorRepo.save(rod);
        bookRepo.save(ejb);
    }

}
