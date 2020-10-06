package com.stefandrei.forumproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Reply {

    private String replyContent;
    private Date replyDate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer replyId;

    @ManyToOne(fetch = FetchType.LAZY)
    private Topic topic;

}
