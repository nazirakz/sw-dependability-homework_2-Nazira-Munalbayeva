/**
 * CompoundFunction.java A rudimentary class that describes a compound function.
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
 * The <code>CompoundFunction</code> class defines a function that combines
 * two or more of the functions in the com.magee.math package.
 * <p>
 * 
 * It contains methods for exploring the properties of such a function. There
 * are methods for finding values, area under the curve, derivative, etc.
 * <p>
 * 
 * Stored in this class are each of the functions added to it.
 * 
 * @author Anthony W. Magee
 * @version 1.0, August 22, 2004
 */

/*
 * version changes
 */

public class CompoundFunction extends Function {
    static final long serialVersionUID = 1L;

    public CompoundFunction() {
        //      TODO 
    }

    public String toString() {
        //      TODO 
        return null;
    }

    public double valueAt(double x) {
        //      TODO 
        return 0;
    }

    public double area(double x1, double x2) {
        // TODO Auto-generated method stub
        return 0;
    }

    public Function getDerivFunc() {
        // TODO Auto-generated method stub
        return null;
    }

    public Function getAntiderivFunc() {
        // TODO Auto-generated method stub
        return null;
    }
}