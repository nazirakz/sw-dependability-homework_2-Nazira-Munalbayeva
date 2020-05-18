package org.magee.math;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import org.junit.runner.RunWith;
import org.magee.math.Rational;

public class RationalTest {

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

  @Test
  public void test02()  throws Throwable  {
      Rational rational0 = new Rational((-1L), (-661L));
      long long0 = rational0.longValue();
      assertEquals(0L, long0);
      assertEquals(0.0015128593040847202, rational0.doubleValue(), 0.01);
  }

  @Test
  public void test03()  throws Throwable  {
      Rational rational0 = new Rational((-1431L), (-1431L));
      Rational rational1 = rational0.multiply(rational0);
      assertEquals(1L, rational0.longValue());
      assertEquals(4.8833823E-7F, rational1.floatValue(), 0.01F);
  }

  @Test
  public void test04()  throws Throwable  {
      Rational rational0 = new Rational(1L, 1L);
      Rational rational1 = rational0.multiply(rational0);
      assertEquals(1, rational0.intValue());
      assertEquals((byte)1, rational1.byteValue());
  }

  @Test
  public void test05()  throws Throwable  {
      Rational rational0 = new Rational(6L, (-2L));
      Rational rational1 = rational0.pow(5);
      assertEquals(7776L, rational1.numerator);
      assertEquals((byte)13, rational1.byteValue());
  }

  @Test
  public void test06()  throws Throwable  {
      Rational rational0 = new Rational((-1L), (-1L));
      Rational rational1 = rational0.subtract((-1L));
      assertEquals(0.0, rational1.doubleValue(), 0.01);
      assertEquals(1L, rational1.denominator);
      assertEquals((-1L), rational0.denominator);
  }

  @Test
  public void test07()  throws Throwable  {
      Rational rational0 = new Rational(0L, (-1802L));
      Rational rational1 = rational0.abs();
      assertEquals(-0.0, rational1.doubleValue(), 0.01);
      assertEquals((-1802L), rational1.denominator);
  }

  @Test
  public void test08()  throws Throwable  {
      Rational rational0 = new Rational(887L, 887L);
      Rational rational1 = rational0.negate();
      assertEquals((byte) (-1), rational1.byteValue());
      assertEquals(1, rational0.intValue());
  }

  @Test
  public void test09()  throws Throwable  {
      Rational rational0 = new Rational(0L, 1090L);
      double double0 = rational0.doubleValue();
      assertEquals(1090L, rational0.denominator);
      assertEquals(0.0, double0, 0.01);
  }

  @Test
  public void test10()  throws Throwable  {
      Rational rational0 = new Rational(1184L, 73L);
      Rational rational1 = rational0.abs();
      assertEquals(1184L, rational0.numerator);
      assertEquals(16.21917808219178, rational1.doubleValue(), 0.01);
  }
}
