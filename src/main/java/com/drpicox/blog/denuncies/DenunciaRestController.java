package com.drpicox.blog.denuncies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/denuncies")
public class DenunciaRestController {
    @Autowired
    private DenunciaRepository denunciaRepository;

    @Autowired
    public DenunciaRestController(){
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Denuncia createDenuncia(@RequestBody Denuncia denuncia){
        denunciaRepository.save(denuncia);
        return denuncia;
    }

    @GetMapping()
    public Collection<Denuncia> getDenuncies(){
        return denunciaRepository.findAllByOrderByIdDesc();
    }

    @GetMapping("/{denunciaId}")
    public Denuncia getDenuncia(@PathVariable Long denunciaId){
        Denuncia denuncia= denunciaRepository.findOne(denunciaId);
        return denuncia;

    }

}
