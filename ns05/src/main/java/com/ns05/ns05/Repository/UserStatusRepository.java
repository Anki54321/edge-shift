package com.ns05.ns05.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ns05.ns05.model.UserReport;



@Repository
public interface UserStatusRepository extends JpaRepository<UserReport,Integer> {
    
}
