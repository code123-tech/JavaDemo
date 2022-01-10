package com.books.bootbooks.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "authorId")
    private int id;

    private String name;

    @Column(unique = true)
    private String email_id;

    @OneToMany(mappedBy = "authorId", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Blog> blogs;

    public Author() {
    }
    public Author(String name, String email_id) {
        System.out.println(email_id);
        this.name = name;
        this.email_id = email_id;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }
    

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email_id='" + email_id + '\'' +
                '}';
    }
}
