package com.example.taskmanagementapp.repository;

import com.example.taskmanagementapp.model.Task;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TaskRepository {

    @Select("SELECT * FROM task")
    List<Task> findAll();

    @Select("SELECT * FROM task WHERE id = #{id}")
    Task findById(Long id);

    @Insert("INSERT INTO task (name, begin_time, end_time, completed) " +
            "VALUES (#{name}, #{beginTime}, #{endTime}, #{completed})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Task task);

    @Update("UPDATE task SET name = #{name}, begin_time = #{beginTime}, " +
            "end_time = #{endTime}, completed = #{completed} WHERE id = #{id}")
    void update(Task task);

    @Delete("DELETE FROM task WHERE id = #{id}")
    void deleteById(Long id);
}
