package com.vj.adstreampro.user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vj.adstreampro.user.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
