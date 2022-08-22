package com.umutozd.springexample.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * StudentRepository is a marker interface whose implementation will be defined in runtime.
 * <p>
 * We can however add custom methods to it with a pre-defined syntax from which the Spring's runtime mechanism
 * will figure out an implementation.
 */
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
