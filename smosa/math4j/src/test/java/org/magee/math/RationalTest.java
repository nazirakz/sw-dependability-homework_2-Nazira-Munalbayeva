package org.magee.math;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import org.junit.runner.RunWith;
import org.magee.math.Rational;

public class RationalTest {
	
	//The target is the Rational.java Class, 
	//it creates a Rational object that takes as input 2 numbers, 
	//a numerator and a denominator. Then uses the “add” method, 
	//this add method takes in input a LongInteger and creates a 
	//new Rational Object with 0 as  denominator, so there should
	//be an exception: NumberFormatException.
	//wrote a new test for test the exception

  @Test
  public void test01()  throws Throwable  {
      Rational rational0 = new Rational(762L, 762L);
      // Undeclared exception!
      try { 
        rational0.add(762L);
        fail("Expecting exception: NumberFormatException");
      
      } catch(NumberFormatException e) {
         //
         // Cannot create a Rational object with zero as the denominator
         //
         verifyException("org.magee.math.Rational", e);
      }
  }
  
  @Test(expected = NumberFormatException.class)
  public void test01new() throws Throwable {
	  Rational rational0 = new Rational (762L,762L);
	  rational0.add(762L);
  }
  
  
  
  //This test create a Rational Object with negative values 
  //then, use the method LongValue() that is a division 
  //operation between nominator and denominator (nominator / denominator)
  //being the input numbers -1 and -661 the result is 0.
  //While the second assert do the same operation but with
  //2 a Double value, so the result is 0.0015..
  //The whole test is correct but there are 2 asserts, 
  //so there should be 2 different tests.

  @Test
  public void test02()  throws Throwable  {
      Rational rational0 = new Rational((-1L), (-661L));
      long long0 = rational0.longValue();
      assertEquals(0L, long0);
      assertEquals(0.0015128593040847202, rational0.doubleValue(), 0.01);
  }
  

 /**
  *  This test creates a Rational Object with negative values 
  *  Then create another rational object using the method multiply, 
  *  The method multiply call the method reduce(). 
  *  Here there are 2 asserts: the first one returns 1 because it 
  *  checks that nominator and denominator divided returns 1, 
  *  and its true because we gave as input the same value -1343L / -1343L = 1L. 
  *  The second assert cast the value of relational 1 to float.
  *  The test is good but should be divided in two 
  *  tests because there are 2 asserts. 
  *  The metod reduce() doesn’t do nothing. 
  *  (do something only if values are equals and negative, 
  *  like -1 and -1).
  * 
  */
  
  @Test
  public void test03()  throws Throwable  {
      Rational rational0 = new Rational((-1431L), (-1431L));
      Rational rational1 = rational0.multiply(rational0);
      assertEquals(1L, rational0.longValue());
      assertEquals(4.8833823E-7F, rational1.floatValue(), 0.01F);
  }
  
  
  /**
   * 
   * Its exactly like the previous one, 
   * but takes 1L as input, then the first assert checks the 
   * method intValue that does numberator / denominator casted to int,
   *  so the result is true. 
   *  The second checks the value in byte of 1 that Is equal to 
   *  byteValue but the method byteValue()
   *   has not been defined in the class so it just transform 
   *   the number in bytes (because it’s the default method of java)
   */

  @Test
  public void test04()  throws Throwable  {
      Rational rational0 = new Rational(1L, 1L);
      Rational rational1 = rational0.multiply(rational0);
      assertEquals(1, rational0.intValue());
      assertEquals((byte)1, rational1.byteValue());
  }
  
  /**
   * 
   * This test creates a Rational object and then use the method pow,
   * The first assert check the value of the numerator after the pow operation
   * it should be (long)6^5= 7776L -> Correct
   * The second assert check the value in byte of rational1
   * 
   */

  @Test
  public void test05()  throws Throwable  {
      Rational rational0 = new Rational(6L, (-2L));
      Rational rational1 = rational0.pow(5);
      assertEquals(7776L, rational1.numerator);
      assertEquals((byte)13, rational1.byteValue());
  }
  
  /**
   * 
   * This test use the method subtract(long): this method creates
   * a new Rational object using the input parameter as numerator and then
   * call another subtrasct method that perform an add operation.
   * 
   * assertEquals(0.0, rational1.doubleValue(), 0.01); Correct -> the doubleValue also 
   * perform numerator \ denominator so the result is 0.0.
   * assertEquals(1L, rational1.denominator); -> Correct, because
   * the first subtract method creates a Rational with -1 as denominator,
   * then the second rational method negates this, so it becames 1, and the
   * add for the add function: 1 * 1 = 1
   * assertEquals((-1L), rational0.denominator); -> Correct, it just check the input
   * 
   */

  @Test
  public void test06()  throws Throwable  {
      Rational rational0 = new Rational((-1L), (-1L));
      Rational rational1 = rational0.subtract((-1L));
      assertEquals(0.0, rational1.doubleValue(), 0.1);
      assertEquals(1L, rational1.denominator);
      assertEquals((-1L), rational0.denominator);
  }

  
  /**
   * 
   * This method test the abs function, if we assume that "abs" should perform
   * the absolute value of the input, there is a problem in the implementation
   * the result of the second assert should be positive.
   */
  @Test
  public void test07()  throws Throwable  {
      Rational rational0 = new Rational(0L, (-1802L));
      Rational rational1 = rational0.abs();
      assertEquals(-0.0, rational1.doubleValue(), 0.01);
      assertEquals((-1802L), rational1.denominator);
  }

  /**
   * 
   * 
   * Here we are testing the negate function, so again assuming that
   * "negate" should effectively negate the value we should have 
   *  887 -> -887 
   *  I wrote a new test to check.
   *  The 2 assert are correct, the first computes -887/887 = -1
   *  while the second: 887/887 = 1
   *  
   */
  @Test
  public void test08()  throws Throwable  {
      Rational rational0 = new Rational(887L, 887L);
      Rational rational1 = rational0.negate();
      assertEquals((byte) (-1), rational1.byteValue());
      assertEquals(1, rational0.intValue());
  }
  
  @Test
  public void test08new()  throws Throwable  {
      Rational rational0 = new Rational(887L, 887L);
      Rational rational1 = rational0.negate();
      assertEquals(-887, rational1.numerator);
      assertEquals((byte) (-1), rational1.byteValue());
      assertEquals(1, rational0.intValue());
  }
  
  
  /**
   * 
   * This test creates a double var and then use the doubleValue() method
   * that perform a 0 / 1090 = 0 operation. The test is correct, but 
   * probably the method doubleValue() should just cast to double
   * not apply more operations.
   * 
   * 
   */

  @Test
  public void test09()  throws Throwable  {
      Rational rational0 = new Rational(0L, 1090L);
      double double0 = rational0.doubleValue();
      assertEquals(1090L, rational0.denominator);
      assertEquals(0.0, double0, 0.01);
  }
  
  /**
   * 
   * Here we have again the abs that was incorrect, but being the values
   * positive the test is correct. And also the doubleValue method (incorrect too)
   * 
   * 
   * For the second assert we compute 1184 / 74 = 16.21....
   */

  @Test
  public void test10()  throws Throwable  {
      Rational rational0 = new Rational(1184L, 73L);
      Rational rational1 = rational0.abs();
      assertEquals(1184L, rational0.numerator);
      assertEquals(16.21917808219178, rational1.doubleValue(), 0.01);
  }
  
//adding tests for cover some statements in reduce method
  @Test
  public void testReduce()  throws Throwable  {
      Rational rational0 = new Rational(5L, (-5L));
      Rational rational1 = rational0.reduce();
      assertEquals(rational0.toString(), rational1.toString());
      
  }
//the method reduce() change value of numerator and denominator only if 
  // if(numFactors[i] == denomFactors[j] && numFactors[i] < 1L && denomFactors[j] != 1L)
  @Test
  public void testReduce2()  throws Throwable  {
      Rational rational0 = new Rational(-5L, (-5L));
      Rational rational1 = rational0.reduce();
      assertEquals("5 / 5", rational1.toString());
  }
}
