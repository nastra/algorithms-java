package com.nastra.algorithms;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author nastra - Eduard Tudenhoefner
 */
public class IsomorphicTest {

    @Test
    public void testOne() {
        Assert.assertFalse(Isomorphic.isIsomorphic(null, "a"));
        Assert.assertFalse(Isomorphic.isIsomorphic("a", null));
        Assert.assertFalse(Isomorphic.isIsomorphic(null, null));
        Assert.assertFalse(Isomorphic.isIsomorphic("ab", "a"));

        Assert.assertTrue(Isomorphic.isIsomorphic("ab", "ca"));
        Assert.assertTrue(Isomorphic.isIsomorphic("ab", "ac"));
        Assert.assertFalse(Isomorphic.isIsomorphic("ab", "aa"));

        Assert.assertTrue(Isomorphic.isIsomorphic("foo", "app"));
        Assert.assertTrue(Isomorphic.isIsomorphic("ofo", "app"));
        Assert.assertTrue(Isomorphic.isIsomorphic("foo", "pap"));
        Assert.assertTrue(Isomorphic.isIsomorphic("ofo", "pap"));

        Assert.assertTrue(Isomorphic.isIsomorphic("turtle", "tletur"));
        Assert.assertFalse(Isomorphic.isIsomorphic("trrtle", "tletur"));
        Assert.assertFalse(Isomorphic.isIsomorphic("turtle", "tleter"));
        Assert.assertTrue(Isomorphic.isIsomorphic("turtle", "ltetur"));

        Assert.assertTrue(Isomorphic.isIsomorphic("kjellerstrand", "astonishingly"));
        Assert.assertTrue(Isomorphic.isIsomorphic("kjellerstrand", "appreciations"));
        Assert.assertTrue(Isomorphic.isIsomorphic("kjellerstrand", "wonderfulness"));
        Assert.assertTrue(Isomorphic.isIsomorphic("astonishingly", "kjellerstrand"));

        Assert.assertFalse(Isomorphic.isIsomorphic("foo", "bar"));
        Assert.assertTrue(Isomorphic.isIsomorphic("foc", "bar"));
    }
}
