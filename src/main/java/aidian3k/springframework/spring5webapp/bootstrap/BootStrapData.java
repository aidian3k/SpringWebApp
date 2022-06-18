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

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author jacek = new Author("Jacek","Starzynski");
        Book kajak = new Book("Kajakiem przez swiat","313931");

        jacek.getBooks().add(kajak);
        kajak.getAuthors().add(jacek);

        authorRepository.save(jacek);
        bookRepository.save(kajak);

        Author adam = new Author("Adam","Mickiewicz");
        Book tadeusz = new Book("Pan Tadeusz","123123");

        adam.getBooks().add(kajak);
        tadeusz.getAuthors().add(jacek);

        authorRepository.save(adam);
        bookRepository.save(tadeusz);

        Publisher pb1 = new Publisher("Adrian","Nowosielski");
        Publisher pb2 = new Publisher("Jacek","Korytkowski");

        publisherRepository.save(pb1);
        publisherRepository.save(pb2);


        System.out.println("BootStrap started");
        System.out.println("Number of books: "+bookRepository.count());
        System.out.println("Number of publishers: "+publisherRepository.count());

    }
}
