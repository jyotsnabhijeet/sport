package com.sportyshoes.dao;

import org.springframework.data.repository.CrudRepository;

import com.sportyshoes.entities.User;

public interface UserLogin extends CrudRepository<User, Integer> {

}
