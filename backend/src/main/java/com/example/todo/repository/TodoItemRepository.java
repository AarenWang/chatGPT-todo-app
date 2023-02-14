package com.example.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

// import java.util.List;

// import org.apache.ibatis.annotations.Delete;
// import org.apache.ibatis.annotations.Insert;
// import org.apache.ibatis.annotations.Mapper;
// import org.apache.ibatis.annotations.Select;
// import org.apache.ibatis.annotations.Update;

// @Mapper
// public interface TodoRepository {
//     @Select("SELECT * FROM todo")
//     List<Todo> findAll();

//     @Select("SELECT * FROM todo WHERE id = #{id}")
//     Todo findById(Long id);

//     @Insert("INSERT INTO todo (title, description, completed) VALUES (#{title}, #{description}, #{completed})")
//     void save(Todo todo);

//     @Update("UPDATE todo SET title = #{title}, description = #{description}, completed = #{completed} WHERE id = #{id}")
//     void update(Todo todo);

//     @Delete("DELETE FROM todo WHERE id = #{id}")
//     void delete(Long id);
// }

import org.springframework.stereotype.Repository;

import com.example.todo.model.TodoItem;

@Repository
public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {
}
