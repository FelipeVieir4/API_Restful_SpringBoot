package com.felipevieira.todosimple.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;
// import org.springframework.stereotype.Repository;

import com.felipevieira.todosimple.models.Task;

//@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    // 100% Spring
    List<Task> findByUser_Id(Long id);

    // JPQL
    // @Query(value = "SELECT t FROM Task t Where t.user.id = : id")
    // List<Task> findByUser_Id(@Param("id") Long id);

    // SQL puro
    // @Query(value = "SELECT * FROM task t WHERE t.user_id = :id", nativeQuery =
    // true)
    // List<Task> findByUser_Id(@Param("id") Long id);

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