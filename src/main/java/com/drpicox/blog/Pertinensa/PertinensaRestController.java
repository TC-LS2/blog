package com.drpicox.blog.Pertinensa;


import com.drpicox.blog.comments.Comment;
import com.drpicox.blog.posts.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by Àlex on 12/12/2017.
 */
@RestController
@RequestMapping("/pertinences")
public class PertinensaRestController {
    @Autowired
    private PertinensaRepository pertinensaRepository;

    @Autowired
    public PertinensaRestController() {
    }
    @GetMapping()
    public Collection<Pertinensa> getPertinences() {
        return pertinensaRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pertinensa createPertinensa(@RequestBody Pertinensa pertinensa) {
        pertinensaRepository.save(pertinensa);
        return pertinensa;
    }
    @GetMapping("/{userId}")
    public Collection<Pertinensa> getPertinencesUser(@PathVariable Long userId) {

        return pertinensaRepository.findByAssociateId(userId);
    }


}
