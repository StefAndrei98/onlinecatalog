package com.stefandrei.forumproject.repository;

import com.stefandrei.forumproject.model.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply, Integer> {
}
