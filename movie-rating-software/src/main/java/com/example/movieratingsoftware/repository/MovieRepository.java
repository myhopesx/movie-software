package com.example.movieratingsoftware.repository;

import com.example.movieratingsoftware.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository <Movie,String>{
}
