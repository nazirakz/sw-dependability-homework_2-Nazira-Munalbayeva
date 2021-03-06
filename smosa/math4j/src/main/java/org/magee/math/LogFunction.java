/**
 * LogFunction.java A rudimentary class that describes an logarithmic function.
 */

/* This file is part of Math4J.
 * Math4J is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * Math4J is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Math4J; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA
 * 
 * Copyright 2005 Anthony Magee
 */

package org.magee.math;

// import other packages

/**
 * The <code>LogFunction</code> class defines an logarithmic function.
 * <p>
 * 
 * It contains methods for exploring the properties of such a function. There
 * are methods for finding values, area under the curve, derivative, etc.
 * <p>
 * 
 * Stored in this class is the base to represent an equation of the form<br>
 * Log(x)  where the base of Log is determined by the user<br>
 * 
 * @author Anthony W. Magee
 * @version 1.1, November 5, 2005
 */

/*
 * version changes
 */
public class LogFunction extends Function {
    static final long serialVersionUID = 1L;
    
    // private members
    private double base; // the base of the logarithm

    /**
     * Simple constructor that defines the base to be 0. 
     * The function is log<sub>0</sub> x.
     */
    public LogFunction() {
        this(0.0);
    }

    /**
     * Default constructor that defines the base of the function.
     * 
     * @param base The double that is the base of the function.
     */
    public LogFunction(double base) {
        this.base = base;
    }

    /**
     * Returns the double that is the base of the exponential.
     * 
     * @return The base.
     */
    public double getBase() {
        return base;
    }

    /**
     * Sets the double that is the base of the exponential.
     * 
     * @param base
     */
    public void setBase(double base) {
        this.base = base;
    }

    /**
     * Evaluates the value of the function at x.
     * 
     * @param x The value to evaluate the function at.
     * @return The y value.
     */
    public double valueAt(double x) {
        return Math.log(x) / Math.log(base);
    }
    
    /**
     * Evaluates the value of the derivative of the function at x.
     */
    public double derivValueAt(double x) {
        return 1 / Math.log(base) / x;
    }

    /**
     * Evaluates the value of the antiderivative of the function at x.
     */
    public double antiderivValueAt(double x) {
        return (-x + x * Math.log(x)) / Math.log(base);
    }
    
    /** 
     * Finds the derivative of this function.
     * 
     * @return A function that is the derivative of <code>this</code>.
     */
    public Function getDerivFunc() {
        return null;
    }

    /** 
     * Finds the antiderivative of this function.
     * 
     * @return A function that is the antiderivative of <code>this</code>.
     */
    public Function getAntiderivFunc() {
        return null;
    }

    /**
     * Evaluates the area under the curve from <code>x1</code> to
     * <code>x2</code>.
     * 
     * @param x1 Lower bound.
     * @param x2 Upper bound.
     * @return The total area under the curve.
     */
    public double area(double x1, double x2) {
        return antiderivValueAt(x2) - antiderivValueAt(x1);
    }

    /**
     * Returns a string representation of this exponential function.
     */
    public String toString() {
        return "log<" + base + "> x";
    }
}