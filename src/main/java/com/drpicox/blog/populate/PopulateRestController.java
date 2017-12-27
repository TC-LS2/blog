package com.drpicox.blog.populate;

import com.drpicox.blog.comments.Comment;
import com.drpicox.blog.comments.CommentRestController;
import com.drpicox.blog.likes.Likes;
import com.drpicox.blog.likes.LikesRepository;
import com.drpicox.blog.likes.LikesRestController;
import com.drpicox.blog.posts.Post;
import com.drpicox.blog.posts.PostRestController;
import com.drpicox.blog.users.User;
import com.drpicox.blog.users.UserRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/populate")
public class PopulateRestController {

    @Autowired private UserRestController users;
    @Autowired private PostRestController posts;
    @Autowired private CommentRestController comments;
    @Autowired private LikesRestController likes;

    private static String LOREM_IPSUM = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.";


    @GetMapping
    public PopulateResult populate() {
        if (posts.getPosts().size() == 0) {
            User alice = users.createUser(new User(null, "alice", "alice@borg.un"));
            User bea = users.createUser(new User(null, "bea", "bea@example.com"));
            User cally = users.createUser(new User(null, "cally", "cally@caprica.ss"));

            Post post1 = posts.createPost(new Post(null, alice, "Alice is Here!", LOREM_IPSUM));
            Post post2 = posts.createPost(new Post(null, bea, "Bea is Here!", "This my body"));
            Post post3 = posts.createPost(new Post(null, alice, "Alice Assimilates", "Resistance is futile. " + LOREM_IPSUM));
            Post post4 = posts.createPost(new Post(null, alice, "Alice Assimilates ][", "Assimilating. " + LOREM_IPSUM));

            Comment comment1 = comments.createComment(new Comment(null, cally, post1, "youre welcome alice!"));
            Comment comment2 = comments.createComment(new Comment(null, cally, post2, "youre welcome bea!"));
            Comment comment3 = comments.createComment(new Comment(null, cally, post3, "be careful, we are friends"));
            Comment comment4 = comments.createComment(new Comment(null, cally, post4, "not in your dreams!"));
            Comment comment5 = comments.createComment(new Comment(null, bea, post3, "rtfm!"));
            Comment comment6 = comments.createComment(new Comment(null, bea, post4, "agggggggg!"));
            Comment comment7 = comments.createComment(new Comment(null, bea, post4, "we are borg"));
            Comment comment8 = comments.createComment(new Comment(null, alice, post2, "prepare to be assimilated"));

            Likes likes1 = likes.createLike(new Likes(null, true, comment1, alice));
            comment1.newLike();
            comments.newLike(comment1);
            Likes likes2 = likes.createLike(new Likes(null, false, comment2, cally));
            comment2.newDislike();
            comments.newLike(comment2);
            Likes likes3 = likes.createLike(new Likes(null, true, comment3, alice));
            comment3.newLike();
            comments.newLike(comment3);
            Likes likes4 = likes.createLike(new Likes(null, true, comment4, alice));
            comment4.newLike();
            comments.newLike(comment4);
            Likes likes5 = likes.createLike(new Likes(null, true, comment5, bea));
            comment5.newLike();
            comments.newLike(comment5);
            Likes likes6 = likes.createLike(new Likes(null, true, comment1, bea));
            comment1.newLike();
            comments.newLike(comment1);
            Likes likes7 = likes.createLike(new Likes(null, true, comment2, bea));
            comment2.newLike();
            comments.newLike(comment2);
            Likes likes8 = likes.createLike(new Likes(null, true, comment3, cally));
            comment3.newLike();
            comments.newLike(comment3);
            Likes likes9 = likes.createLike(new Likes(null, true, comment4, cally));
            comment4.newLike();
            comments.newLike(comment4);
            Likes likes10 = likes.createLike(new Likes(null, true, comment5, alice));
            comment5.newLike();
            comments.newLike(comment5);

        }

        return new PopulateResult(
                comments.getComments(),
                posts.getPosts(),
                users.getUsers(),
                likes.getLikes()
        );
    }
}
