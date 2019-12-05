package com.revature.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.revature.cactus.CactusTest;
import com.revature.cactus.CactusTest2;

@RunWith(Suite.class)
@SuiteClasses({CactusTest.class, CactusTest2.class})
public class AllTests {

}
