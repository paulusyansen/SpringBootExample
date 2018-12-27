package org.paingan.boot.repository;

import org.paingan.boot.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepository extends JpaRepository<Users, Long> , JpaSpecificationExecutor<Users>{
	Users findByUsername(String username);
}
