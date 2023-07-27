package com.felipevieira.todosimple.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.felipevieira.todosimple.models.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    // 100% Spring
    List<Task> findByUser_Id(Long id);

    // JPQL
    // @Query(value = "SELECT t FROM Task t Where t.user.id = : id")
    // List<Task> findByUser_Id(@Param("id") Long id);

    // // SQL puro
    // @Query(value = "SELECT * FROM task t WHERE t.user_id = :id", nativeQuery = true)
    // List<Task> findByUser_Id(@Param("id") Long id);

}
