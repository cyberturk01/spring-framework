package org.yigit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.yigit.entity.Course;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public interface CourseRepository extends JpaRepository<Course, Long> {

    //find all courses by category
    List<Course> findByCategory(String category);

//    @Query("SELECT p FROM Course p WHERE p.category = ?1 ")
//    Optional<Course> getCategory(String category);

    //Find all courses by category and order the entities by name
    List<Course> findByCategoryOrderByName(String category);

    //Checks if a course with provided name exists.return true if course exist, false otherwise
    boolean existsByName(String name);

    //returns the count of courses for the provided category
    int countByCategory(String category);

    //Find all courses that start with the provided course name
    List<Course> findByNameStartingWith(String name);

    //Find all courses by category and  returns a stream
    Stream<Course> streamByCategory(String category);


}
