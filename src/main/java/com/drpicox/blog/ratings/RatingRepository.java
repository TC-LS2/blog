package com.drpicox.blog.ratings;

import com.drpicox.blog.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface RatingRepository extends JpaRepository<Rating, Long> {
    public Collection<Rating> findAllByOrderByIdDesc();
    public Collection<Rating> findAllByUser(User user);

}
