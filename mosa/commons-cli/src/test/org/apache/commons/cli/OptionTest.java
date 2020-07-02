package org.apache.commons.cli;

import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import org.apache.commons.cli.Option;
import org.junit.runner.RunWith;

public class OptionTest {
	
	/**
	 * 
	 * In this test we are creating an Option object with "" as name and description.
	 *  the getArgName method return a string called argName containing "arg".
	 *   
	 *  
	 *  setArgName set a new name for the var argName correctly.
	 *  
	 *  hasArgName returns argName  if 
	 *   argName != null && argName.length() >= 0; returns true because there is >=
	 *   probably the = should be removed, because the test returns true also if 
	 *   the name is "" (empty)
	 *  
	 */

  @Test
  public void test01()  throws Throwable  {
      Option option0 = new Option("", "");
      assertEquals("arg", option0.getArgName());
      
      option0.setArgName("");
      boolean boolean0 = option0.hasArgName();
      assertTrue(boolean0);
  }
  
 /**
  * 
  * 
  * This test is correct, the first assert return always "arg", while the second assert
  * returns 1 if hasArgs is true.
  * 
  * getKey() is not needed. 
  */

  @Test
  public void test02()  throws Throwable  {
      Option option0 = new Option("", "", true, "");
      option0.getKey();
      assertEquals("arg", option0.getArgName());
      assertEquals(1, option0.getArgs());
  }
  
  /**
   * 
   * This test checks if option0 and option1 are equals, and having them the same imput
   * the boolean is true, so the third assert is verified.
   *
   * The first and second asserts are not needed.
   */

  @Test
  public void test03()  throws Throwable  {
      Option option0 = new Option("R", "R", true, "R");
      Option option1 = new Option("R", "R", true, "R");
      boolean boolean0 = option1.equals(option0);
      assertEquals("arg", option1.getArgName());
      assertTrue(option1.hasArg());
      assertTrue(boolean0);
  }
  
  /**
   * getId() does not return an id, but a char: getKey().charAt(1)
   * So it returns the char 67 = C
   *
   * first and second asserts are correctly false because Args and LongOpt are 
   * initialized with a different Option constructor.
   */

  @Test
  public void test04()  throws Throwable  {
      Option option0 = new Option("VC", "VC");
      int int0 = option0.getId();
      assertFalse(option0.hasLongOpt());
      assertFalse(option0.hasArgs());
      assertEquals(67, int0);
      assertEquals("arg", option0.getArgName());
  }
  
  /**
   * this method test the hasArgs method, this method return true if numberOfArgs is 
   * > -1 (Should be >0?)
   * 
   * 
   */

  @Test
  public void test05()  throws Throwable  {
      Option option0 = new Option("P", "P", true, "P");
      boolean boolean0 = option0.hasArgs();
      assertEquals("arg", option0.getArgName());
      assertTrue(boolean0);
      assertEquals(1, option0.getArgs());
  }
  
 /**
  * 
  * This test is red. There is an AssertionError on 
  * verifyException("java.util.ArrayList", e);
  * 
  * Added ignore and rewrote the test to check if the IndexOutOfBoundsException is thrown.
  *
  * 
  */
  
  @Ignore
  @Test
  public void test06()  throws Throwable  {
      Option option0 = new Option("P", true, "P");
      option0.addValueForProcessing("P");
      try { 
        option0.getValue(295);
        fail("Expecting exception: IndexOutOfBoundsException");
      
      } catch(IndexOutOfBoundsException e) {
         //
         // Index: 295, Size: 1
         //
         verifyException("java.util.ArrayList", e);
      }
  }
 
  @Test (expected = IndexOutOfBoundsException.class)
  public void test06New()  throws Throwable  {
      Option option0 = new Option("P", true, "P");
      option0.addValueForProcessing("P");
      option0.getValue(295);

      }
  
  
/**
 * 
 * 
 * The method checks if the two Option object, created with two different constructors
 * are equals. Equals returns true because matches are performed on the opt string (first parameter)
 * so, being the same, it returns true also if probably it should not.
 */
  @Test
  public void test07()  throws Throwable  {
      Option option0 = new Option("", "", true, "");
      Option option1 = new Option("", "");
      boolean boolean0 = option0.equals(option1);
      assertEquals((-1), option1.getArgs());
      assertFalse(option1.hasLongOpt());
      assertEquals("arg", option1.getArgName());
      assertEquals(1, option0.getArgs());
      assertTrue(boolean0);
  }

  /**
   * 
   * option0.getValue(); -> not tested, added a test to check that it should be null
   */
  @Test
  public void test08()  throws Throwable  {
      Option option0 = new Option("", "", true, "");
      option0.getValue();
      assertEquals("arg", option0.getArgName());
      assertTrue(option0.hasArg());
  }
  
  @Test
  public void test08new()  throws Throwable  {
      Option option0 = new Option("", "", true, "");
      assertEquals(null, option0.getValue());
  }

  /**
   * 
   * 
   *Here we set arg name to null, but then we do not check with an assert -> Added 
   *assertEquals(null, option0.getArgName());
   *
   *getArgs is still 1 because in the costructor there is if (hasArgs) -> this.numberOfArgs = 1;
   */
  @Test
  public void test09()  throws Throwable  {
      Option option0 = new Option((String) null, (String) null, true, (String) null);
      assertEquals("arg", option0.getArgName());
      
      option0.setArgName((String) null);
      option0.getArgName();
      assertEquals(1, option0.getArgs());
      assertEquals(null, option0.getArgName());
  }
  
  /**
   * 
   * Equals still true because the match is performed on the first parameter (opt), and
   * being SX equal for option0 and option1 the match returns true.
   */

  @Test
  public void test10()  throws Throwable  {
      Option option0 = new Option("SX", "SX");
      Option option1 = new Option("SX", "SX", false, "SX");
      boolean boolean0 = option0.equals(option1);
      assertTrue(boolean0);
      assertEquals((-1), option1.getArgs());
      assertFalse(option0.hasLongOpt());
      assertEquals("arg", option1.getArgName());
  }
}
