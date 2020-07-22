package com.nabenik.kukulkan.repository;

import com.nabenik.kukulkan.model.Phrase;
import org.apache.deltaspike.data.api.AbstractEntityRepository;
import org.apache.deltaspike.data.api.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository(forEntity = Phrase.class)
public abstract class PhraseRepository extends AbstractEntityRepository<Phrase, Long> {

    public abstract List<Phrase> findByAuthorLike(String author);
}
