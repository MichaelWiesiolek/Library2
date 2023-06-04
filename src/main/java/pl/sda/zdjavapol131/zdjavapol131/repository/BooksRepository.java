package pl.sda.zdjavapol131.zdjavapol131.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.zdjavapol131.zdjavapol131.repository.dao.BooksEntity;

public interface BooksRepository extends JpaRepository<BooksEntity, Integer> {



}
