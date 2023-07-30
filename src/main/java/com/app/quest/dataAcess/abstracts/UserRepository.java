package com.app.quest.dataAcess.abstracts;

import com.app.quest.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
