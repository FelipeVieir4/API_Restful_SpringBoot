package com.felipevieira.todosimple.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import com.felipevieira.todosimple.models.Task;
import com.felipevieira.todosimple.models.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.felipevieira.todosimple.repositories.TaskRepository;
import com.felipevieira.todosimple.services.exceptions.DataBindingViolationException;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserService userService;

    public Task findById(Long id) {
        Optional<Task> task = this.taskRepository.findById(id);

        return task.orElseThrow(
                () -> new DataBindingViolationException("Task não encontrada! id:" + id + ", tipo: " + Task.class.getName()));
    }

    public List<Task> findAllByUserId(Long userId){
        List<Task> tasks = this.taskRepository.findByUser_Id(userId);
        return tasks;
    }


    @Transactional
    public Task create(Task obj) {
        User user = this.userService.findById(obj.getUser().getId());
        obj.setId(null);
        obj.setUser(user);
        obj = this.taskRepository.save(obj);
        return obj;
    }

    @Transactional
    public Task update(Task obj) {
        Task newObj = findById(obj.getId());
        newObj.setDescription(obj.getDescription());
        return this.taskRepository.save(newObj);
    }

    public void delete(Long id) {
        findById(id);
        try {
            this.taskRepository.deleteById(id);
        } catch (Exception e) {
            throw new DataBindingViolationException("Não é possível deletar. Há entidades relacionadas");
        }
    }


}
