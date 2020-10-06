package com.stefandrei.forumproject.repository;

import com.stefandrei.forumproject.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Integer> {
}
