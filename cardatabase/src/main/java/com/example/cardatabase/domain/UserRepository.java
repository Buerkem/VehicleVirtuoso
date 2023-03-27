
package com.example.cardatabase.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.example.cardatabase.domain.User;

@RepositoryRestResource
public interface UserRepository extends CrudRepository<User, Long>
{
	User findByUsername(String username);
}