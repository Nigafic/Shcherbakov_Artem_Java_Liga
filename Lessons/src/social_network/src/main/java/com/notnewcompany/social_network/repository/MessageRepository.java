package com.notnewcompany.social_network.repository;

import com.notnewcompany.social_network.model.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends CrudRepository <Message , Long>  {



}
