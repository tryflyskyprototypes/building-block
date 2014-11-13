package com.tryflysky.buildingblock;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ BlockTest.class, FaceCheckerTest.class, PileTest.class,
		StackerTest.class, UtilsTest.class })
public class AllTests {

}
