package aidian3k.springframework.spring5webapp.bootstrap;

import aidian3k.springframework.spring5webapp.domain.Author;
import aidian3k.springframework.spring5webapp.domain.Book;
import aidian3k.springframework.spring5webapp.domain.Publisher;
import aidian3k.springframework.spring5webapp.repositories.AuthorRepository;
import aidian3k.springframework.spring5webapp.repositories.BookRepository;
import aidian3k.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author adam = new Author("Adam", "Mickiewicz");
        Book panTadeusz = new Book("Pan Tadeusz","123456");

        adam.getBooks().add(panTadeusz);
        panTadeusz.getAuthors().add(adam);

        authorRepository.save(adam);
        bookRepository.save(panTadeusz);

        Author fiodor = new Author("Fiodor", "Dostojewski");
        Book kara = new Book("Zbrodnia i Kara","12345678");

        fiodor.getBooks().add(kara);
        kara.getAuthors().add(fiodor);

        authorRepository.save(fiodor);
        bookRepository.save(kara);

        Publisher nowaEra = new Publisher("Nowa Era", "Aleje Jerozolimskie 5", "Warszawa", "mazowieckie");
        Publisher empik = new Publisher("Empik", "Saperow 15", "Poznan", "wielkopolskie");

        nowaEra.getBooks().add(panTadeusz);
        panTadeusz.setPublisher(nowaEra);

        empik.getBooks().add(kara);
        kara.setPublisher(empik);

        publisherRepository.save(nowaEra);
        publisherRepository.save(empik);

        System.out.println("Started BootStrap");
        System.out.println("Number of books : "+ bookRepository.count());
        System.out.println("Number of authors : "+ authorRepository.count());
        System.out.println("Number of publishers : "+ publisherRepository.count());
        System.out.println("Empik's number of books : "+ empik.getBooks().size());
    }
}
