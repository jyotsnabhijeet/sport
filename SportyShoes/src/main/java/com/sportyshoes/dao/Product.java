package com.sportyshoes.dao;

import org.springframework.data.repository.CrudRepository;

import com.sportyshoes.entities.Item;

public interface Product extends CrudRepository<Item, Integer>{

}
