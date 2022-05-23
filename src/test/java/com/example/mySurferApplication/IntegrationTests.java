package com.example.mySurferApplication;

import com.example.mySurferApplication.DemoApplication.Services.ContestService;
import com.example.mySurferApplication.DemoApplication.Services.Entities.Contest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class IntegrationTests {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private ContestService contestService;

    @Test
    public void whenCreateContest_thenReturnContest(){

        Contest contest = contestService.createContest("luzern", 6);
        Long id = contest.getId();

        Contest contest1 = testEntityManager.find(Contest.class, id);
        assertThat("luzern", is(contest1.getPlace()));


    }

}
