package com.test;

import org.testng.annotations.Test;

public class Test1 {

    @Test
    public void test1() {

    }

    @Test(dependsOnMethods = "test1")
    public void test2() {

    }


}
