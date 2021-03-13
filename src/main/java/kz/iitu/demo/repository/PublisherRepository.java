package kz.iitu.demo.repository;

import kz.iitu.demo.entity.Author;
import kz.iitu.demo.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {

    @Query("SELECT p FROM Publisher p WHERE p.name LIKE %?1%" + " OR p.description LIKE %?1%")
    public List<Publisher> search(String keyword);

}
