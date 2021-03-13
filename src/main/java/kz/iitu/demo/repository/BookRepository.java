package kz.iitu.demo.repository;

import kz.iitu.demo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book b WHERE b.name LIKE %?1%" + " OR b.description LIKE %?1%")
    public List<Book> search(String keyword);

}
