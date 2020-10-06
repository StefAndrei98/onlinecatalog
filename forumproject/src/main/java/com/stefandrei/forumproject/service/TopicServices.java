package com.stefandrei.forumproject.service;

import com.stefandrei.forumproject.model.Topic;
import com.stefandrei.forumproject.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

    @Service("ITopicService")
    public class TopicServices {

        @Autowired
        private TopicRepository topicRepository;

        public List<Topic> findAll() {
            return topicRepository.findAll ();
        }

        public void save(Topic topic) {
            topicRepository.save(topic);
        }

        public Topic findById(Integer id) {
            Optional<Topic> topic = topicRepository.findById (id);
            if (topic.isPresent())
            {
                return topic.get ();
            }
            return null;
        }

        public void deleteById(Integer id) {
            topicRepository.deleteById (id);
        }
    }
