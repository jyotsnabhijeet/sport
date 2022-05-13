package com.sportyshoes.dao;

import org.springframework.data.repository.CrudRepository;

import com.sportyshoes.entities.Admin;

public interface AdminLogin extends CrudRepository<Admin, Integer> {

}
