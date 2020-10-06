package com.stefandrei.forumproject.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Topic {

    private String topicTitle;
    private String topicContent;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer topicId;

    @OneToMany(mappedBy="topic" , cascade = CascadeType.ALL)
    private List<Reply> replies;

}
