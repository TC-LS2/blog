package com.drpicox.blog.likes;

import com.drpicox.blog.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface LikeRepository extends JpaRepository<Like, Long> {

}
