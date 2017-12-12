package com.drpicox.blog.com.drpicox.blog.likes;

import com.drpicox.blog.likes.LikesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LikesHelper {

    @Autowired
    private LikesRepository likesRepository;

    public void cleanup() throws Exception {
        likesRepository.deleteAllInBatch();
    }



}
