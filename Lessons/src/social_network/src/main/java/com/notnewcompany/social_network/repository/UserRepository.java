package com.notnewcompany.social_network.repository;

import com.notnewcompany.social_network.model.WebUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository <WebUser, Long> {
}
