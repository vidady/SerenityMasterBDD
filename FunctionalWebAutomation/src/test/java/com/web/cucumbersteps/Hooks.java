package com.web.cucumbersteps;

import io.cucumber.java.*;

public class Hooks {

    @Before
    public static void before(){
        System.out.println("Before hook");
    }

    @Before(value = "@pending")
    public static void before_skip_pending(){
        throw new PendingException();
    }

    @Before(value = "@ignored")
    public static void before_skip_ignore(){
        throw new PendingException();
    }

    @Before(value = "@manual")
    public static void before_skip_skipped(){
        throw new PendingException();
    }

    @After
    public static void after(){
        System.out.println("After hook");
    }

    @BeforeAll
    public static void before_all(){
        System.out.println("Before all hook");
    }

    @AfterAll
    public static void after_all(){
        System.out.println("After all hook");
    }
}
