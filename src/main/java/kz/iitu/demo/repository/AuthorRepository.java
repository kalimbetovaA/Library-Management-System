package kz.iitu.demo.repository;

import kz.iitu.demo.entity.Author;
import kz.iitu.demo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT a FROM Author a WHERE a.name LIKE %?1%" + " OR a.about LIKE %?1%")
    public List<Author> search(String keyword);

}
