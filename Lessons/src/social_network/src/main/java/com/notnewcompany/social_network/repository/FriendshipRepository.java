package com.notnewcompany.social_network.repository;

import com.notnewcompany.social_network.model.Friendship;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendshipRepository extends CrudRepository<Friendship, Long> {
}
