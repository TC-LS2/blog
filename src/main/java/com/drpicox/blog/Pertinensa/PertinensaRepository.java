package com.drpicox.blog.Pertinensa;

import com.drpicox.blog.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

/**
 * Created by Àlex on 12/12/2017.
 */
public interface PertinensaRepository extends JpaRepository<Pertinensa, Long>{

    Collection<Pertinensa> findByAssociateId(Long associateId);

}



