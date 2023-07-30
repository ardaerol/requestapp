package com.app.quest.dataAcess.abstracts;

import com.app.quest.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
