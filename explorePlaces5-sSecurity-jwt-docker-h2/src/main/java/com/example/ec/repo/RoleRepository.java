/**
 * 
 */
package com.example.ec.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ec.domain.Role;

/**
 * @author amit
 *
 */
public interface RoleRepository extends JpaRepository<Role, Long> {

	Optional<Role> findByRoleName(String name);
	
}
