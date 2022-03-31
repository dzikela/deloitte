package com.deloitte.repository;
import static org.assertj.core.api.Assertions.assertThat;
import com.deloitte.model.Task;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class UserTaskRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    UserTaskRepository repository;

    @Test
    public void should_find_no_tasks_if_repository_is_empty() {
        Iterable tasks = repository.findAll();
        Assertions.assertThat(tasks).isEmpty();
    }
    @Test
    public void should_store_a_task() {
        Task task = repository.save(new Task("New task", "Assignment",null, null ));
        assertThat(task).hasFieldOrPropertyWithValue("name", "New task");
        assertThat(task).hasFieldOrPropertyWithValue("description", "Assignment");
    }

    @Test
    public void should_delete_task_by_id() {
        Task task1 = new Task("New task1", "Assignment1",null, null);
        entityManager.persist(task1);
        Task task2 = new Task("New task2", "Assignment2",null, null);
        entityManager.persist(task2);
        Task task3 = new Task("New task3", "Assignment3",null, null);
        entityManager.persist(task3);
        repository.deleteById(task2.getId());
        Iterable tutorials = repository.findAll();
        assertThat(tutorials).hasSize(2).contains(task1, task3);
    }

}
