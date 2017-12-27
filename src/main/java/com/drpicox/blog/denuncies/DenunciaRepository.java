package com.drpicox.blog.denuncies;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface DenunciaRepository extends JpaRepository<Denuncia,Long> {
    public Collection<Denuncia> findAllByOrderByIdDesc();
    Collection<Denuncia> findByReporterId(Long id);
    Collection<Denuncia> findByReportedId(Long id);
}
