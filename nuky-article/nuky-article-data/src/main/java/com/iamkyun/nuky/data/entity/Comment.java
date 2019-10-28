package com.iamkyun.nuky.data.entity;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

import org.springframework.data.annotation.CreatedDate;

/**
 * @author kyun
 *
 */
@Data
@Entity
public class Comment {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    @Column(name = "content")
    private String content;

    @ManyToOne
    private Article article;

    @ManyToOne
    private Comment replyComment;

    @OneToMany(mappedBy = "replyComment", fetch = FetchType.LAZY)
    private Collection<Comment> comments;

    @ManyToOne
    private User user;

    @Column(name = "create_date")
    @Basic
    @CreatedDate
    private Timestamp createDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Comment)) {
            return false;
        }
        Comment comment = (Comment) o;
        return Objects.equals(getId(), comment.getId()) &&
                Objects.equals(getContent(), comment.getContent()) &&
                Objects.equals(getArticle(), comment.getArticle()) &&
                Objects.equals(getReplyComment(), comment.getReplyComment()) &&
                Objects.equals(getComments(), comment.getComments()) &&
                Objects.equals(getUser(), comment.getUser()) &&
                Objects.equals(getCreateDate(), comment.getCreateDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getContent(), getArticle(), getReplyComment(), getComments(), getUser(), getCreateDate());
    }
}
