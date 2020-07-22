package com.nabenik.kukulkan.repository;

import com.nabenik.kukulkan.model.Phrase;
import com.nabenik.kukulkan.util.TestUtil;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

@RunWith(Arquillian.class)
public class PhraseRepositoryIT {

    @Inject
    PhraseRepository phraseRepository;

    @Deployment
    public static WebArchive createDeployment() {

        // Create deploy file
        WebArchive war = TestUtil.createBasePersistenceWar();

        // Show the deployment structure
        System.out.println(war.toString(true));;
        return war;
    }

    @Test
    public void createTest() {
        Phrase phrase = new Phrase();
        phrase.setPhrase("These aren't the droids you're looking for");
        phrase.setAuthor("Obi Wan");

        phraseRepository.save(phrase);

        Assert.assertNotNull(phrase.getPhraseId());
    }

}
