package com.drpicox.blog.interactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/interactions")
public class InteractionController {

    @Autowired
    private InteractionRepository interactionRepository;

    @Autowired
    public InteractionController() {
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Interaction createLike(@RequestBody Interaction interaction) {
        interactionRepository.save(interaction);
        return interaction;
    }

    @GetMapping()
    public Collection<Interaction> getInteractions() {
        return interactionRepository.findAllByOrderByIdDesc();
    }

    @GetMapping("/{likeId}")
    public Interaction getInteraction(@PathVariable Long likeId) {
        Interaction interaction = interactionRepository.findOne(likeId);
        return interaction;
    }

    @DeleteMapping("/{likeId}")
    public Interaction undoInteraction(@PathVariable Long likeId) {
        Interaction interaction = getInteraction(likeId);
        interactionRepository.delete(likeId);
        return interaction;
    }
}
