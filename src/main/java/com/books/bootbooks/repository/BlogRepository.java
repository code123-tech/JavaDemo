package com.books.bootbooks.repository;

import java.util.List;

import com.books.bootbooks.entities.Blog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Integer> {

    @Query(value = "select * from blog order by creation_date DESC",nativeQuery=true)
    List<Blog> finAllOrderByCreationDateDesc();
}

