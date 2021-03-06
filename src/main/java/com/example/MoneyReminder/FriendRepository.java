package com.example.MoneyReminder;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FriendRepository extends CrudRepository<Friend,Long> {
    List<Friend> findByName(String name);
    Friend findById(long id);

}
