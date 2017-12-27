
package com.drpicox.blog.com.drpicox.blog.interactions;

import com.drpicox.blog.interactions.Interaction;
import com.drpicox.blog.interactions.InteractionRepository;
import com.drpicox.blog.posts.Post;
import com.drpicox.blog.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InteractionHelper {

    @Autowired
    private InteractionRepository interactionRepository;

    public void cleanup() throws Exception {
        interactionRepository.deleteAllInBatch();
    }

    public Interaction stub(boolean like) {
        return stub(null, null, like);
    }

    public Interaction stub(Post post, boolean like) {
        return stub(null, post, like);
    }

    public Interaction stub(User user, boolean like) {
        return stub(user, null, like);
    }

    public Interaction stub(User user, Post post, boolean likes) {
        Interaction interaction = new Interaction(null, user, post, likes);
        interactionRepository.save(interaction);
        return interaction;
    }
}
