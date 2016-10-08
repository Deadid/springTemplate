package com.smakhov.springtemplate.model.dao;

import com.smakhov.springtemplate.model.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

/**
 * Created by SMakhov on 08.10.2016.
 */
@RepositoryRestResource
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUsername(@Param("username") String username);
}
