package com.app.quest.dataAcess.abstracts;

import com.app.quest.entities.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like,Long> {
}
