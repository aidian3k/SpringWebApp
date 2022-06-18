package aidian3k.springframework.spring5webapp.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Book {

    private String title;
    private String isBn;

    @ManyToMany
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name="book_id"), inverseJoinColumns = @JoinColumn(name="author_id"))
    private Set<Author> authors = new HashSet<>();
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Book(String title, String isBn) {
        this.title = title;
        this.isBn = isBn;

    }

    public Book(){}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsBn() {
        return isBn;
    }

    public void setIsBn(String isBn) {
        this.isBn = isBn;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Long getId() {
        return this.id;
    }

    @Override
    public boolean equals(Object o){
        return o instanceof Book &&
                ((Book)o).id==this.id;
    }

    @Override
    public int hashCode() {
        return id!=null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", isBn='" + isBn + '\'' +
                ", authors=" + authors +
                ", id=" + id +
                '}';
    }
}
