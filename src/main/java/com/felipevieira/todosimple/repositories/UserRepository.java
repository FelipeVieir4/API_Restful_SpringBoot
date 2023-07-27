package com.felipevieira.todosimple.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.felipevieira.todosimple.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
