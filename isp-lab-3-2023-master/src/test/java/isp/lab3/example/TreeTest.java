package isp.lab3.example;

import isp.lab3.exercise1.Tree;
import org.junit.Assert;
import org.junit.Test;
public class TreeTest {
    @Test
    public void testGrow(){
        Tree t = new Tree();
        t.height = 10;

        t.grow(2);
        Assert.assertEquals(12, t.height);
    }

    @Test
    public void testToString(){
        Tree t = new Tree();
        t.height = 10;

        Assert.assertEquals("10", t.toString());
    }
}

