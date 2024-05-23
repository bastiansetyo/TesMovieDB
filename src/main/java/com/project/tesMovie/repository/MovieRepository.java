package com.project.tesMovie.repository;

import com.project.tesMovie.dao.MovieDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<MovieDao, Integer> {

}
