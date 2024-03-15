package com.MYAPPLICATION.repository;

import com.MYAPPLICATION.model.application;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<application,Long> {
}
