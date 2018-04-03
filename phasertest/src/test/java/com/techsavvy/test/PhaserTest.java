package com.techsavvy.test;

import com.techsavvy.phaser.PhaserDemo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by savneet on 04-04-2018.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PhaserDemo.class})
public class PhaserTest {

    @Autowired
    private PhaserDemo phaserDemo;

    @Test
    public void testPhaser(){
        phaserDemo.testPhaser();
    }
}
