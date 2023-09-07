package com.felipevieira.todosimple.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

import com.felipevieira.todosimple.models.User;

// @Repository
public interface UserRepository extends JpaRepository<User, Long> {

}

/*
 * @Repository
 * It is indeed not necessary to put the @Repository annotation on interfaces
 * that extend JpaRepository; Spring recognises the repositories by the fact
 * that they extend one of the predefined Repository interfaces.
 * 
 * The purpose of the @NoRepositoryBean annotation is to prevent Spring from
 * treating that specific interface as a repository by itself. The JpaRepository
 * interface has this annotation because it isn't a repository itself, it's
 * meant to be extended by your own repository interfaces, and those are the
 * ones that should be picked up.
 */