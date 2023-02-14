package com.example.taskmanagementapp.service;

import com.example.taskmanagementapp.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.taskmanagementapp.model.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public Task createTask(Task task) {
        return taskRepository.update(task);
    }

    @Override
    public Task updateTask(Long id, Task task) {
        Task existingTask = taskRepository.findById(id);
        if (existingTask == null) {
            return null;
        }
        existingTask.setName(task.getName());
        existingTask.setBeginTime(task.getBeginTime());
        existingTask.setEndTime(task.getEndTime());
        existingTask.setCompleted(task.isCompleted());
        return taskRepository.update(existingTask);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
