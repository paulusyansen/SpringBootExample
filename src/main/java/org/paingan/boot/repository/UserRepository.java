package org.paingan.boot.repository;

import org.paingan.boot.model.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepository extends JpaRepository<ApplicationUser, Long> , JpaSpecificationExecutor<ApplicationUser>{
	ApplicationUser findByUsername(String username);
}
