package org.paingan.boot.repository;

import org.paingan.boot.domain.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepository extends JpaRepository<UserAccount, Long> , JpaSpecificationExecutor<UserAccount>{
	UserAccount findByUsername(String username);
}
