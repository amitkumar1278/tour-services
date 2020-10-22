/**
 * 
 */
package com.example.ec.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.ec.domain.User;

/**
 * @author amit
 *
 */
@RepositoryRestResource(exported = true)
public interface UserRepository extends JpaRepository<User, Integer>{

	Optional<User> findByUsername(String username);

}
