package com.vetyo.dto;

import com.vetyo.model.User;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by Admin on 1/3/2017.
 */
@Transactional
public interface UserRepository extends CrudRepository<User,Long> {
    User findByUsername(String username);
}
