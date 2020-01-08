package com.example.sweater.repos;

import org.springframework.data.repository.CrudRepository;
import com.example.sweater.domain.Message;
import java.util.List;

public interface MessageRepo extends CrudRepository<Message, Integer> {
    List<Message> findByTag(String tag);
}
