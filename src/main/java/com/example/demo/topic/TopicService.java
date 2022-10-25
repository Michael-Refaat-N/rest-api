package com.example.demo.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;


    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }


    public Topic getTopic(Long id) {
        return topicRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Topic with id: " + id + " not found"
                ));
    }


    public void addTopic(List<Topic> topics) {

        for (Topic topic: topics) {

            String name = topic.getName();

            if (name == null || name.length() <= 0) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "One or more topics has invalid name");
            }
        }

        topicRepository.saveAll(topics);

    }


    public void updateTopic(Long id, Topic topic) {

        Topic t = topicRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Topic with id: " + id + " not found"
                ));

        if (topic.getName() != null && topic.getName().length() > 0) {
            t.setName(topic.getName());
            topicRepository.save(t);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid or no name provided");
        }

    }


    public void deleteTopic(Long id) {

        boolean topicExists = topicRepository.existsById(id);

        if (topicExists) {
            topicRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Topic with id: " + id + " not found");
        }
    }

}
