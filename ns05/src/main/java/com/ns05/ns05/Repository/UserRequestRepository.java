package com.ns05.ns05.Repository;

import java.lang.annotation.Native;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ns05.ns05.model.UserRequestModel;


@Repository
public interface UserRequestRepository extends JpaRepository<UserRequestModel,Integer> {

    UserRequestModel findBySenderId(int userId);

    UserRequestModel findByReceiveId(int userid);

    UserRequestModel findByFileId(int fileId);
    

    
}
