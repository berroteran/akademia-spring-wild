package com.machupichu.zonas.data.repository;

import com.machupichu.zonas.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {


    Optional<User> findByLogin(String login);

    @Query("select e from User e " +
            "where lower(e.login) like lower(concat('%', :searchTerm, '%')) " +
            "or lower(e.firstName) like lower(concat('%', :searchTerm, '%'))" +
            "or lower(e.lastName) like lower(concat('%', :searchTerm, '%'))")
    List<User> search(@Param("searchTerm") String searchTerm);

    public Optional<User> findById(Long id);
}
