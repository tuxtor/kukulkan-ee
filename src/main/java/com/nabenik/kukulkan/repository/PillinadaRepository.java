package com.nabenik.kukulkan.repository;

import com.nabenik.kukulkan.model.Pillinada;
import java.util.List;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

@Repository(forEntity = Pillinada.class)
public interface PillinadaRepository extends EntityRepository<Pillinada, Long>  {
    
    public List<Pillinada> findByAuthorLike(String author);
    
    public List<Pillinada> findByDescriptionLike(String description);
    
}
