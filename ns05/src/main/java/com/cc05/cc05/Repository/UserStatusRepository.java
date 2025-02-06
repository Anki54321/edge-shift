package com.cc05.cc05.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cc05.cc05.model.UserReport;



@Repository
public interface UserStatusRepository extends JpaRepository<UserReport,Integer> {
    
}
