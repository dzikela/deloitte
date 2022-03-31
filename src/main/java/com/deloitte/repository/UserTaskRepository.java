package com.deloitte.repository;

import com.deloitte.model.Task;
import com.deloitte.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserTaskRepository extends JpaRepository<Task, Long> {
    List<Task> findTasksByUser(User user);

    Task findTaskById(long id);
}
