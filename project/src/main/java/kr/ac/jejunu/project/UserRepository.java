package kr.ac.jejunu.project;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {

    Page<User> findAllByNameAndPassword(@Param("name") String name, @Param("password")String password,
                                        Pageable pageable);
}
