package com.example.ec.repo;

import com.example.ec.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author amit
 *
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByRoleName(String name);
}
