/*
 * @(#)ARG_INOUT.java	1.19 10/03/23
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package org.omg.CORBA;

/**
 * Signifies an argument used for both input and output in an invocation,
 * meaning that the argument is being passed from the client to
 * the server and then back from the server to the client.
 * <code>ARG_INOUT.value</code> is one of the possible values used to
 * indicate the direction in
 * which a parameter is being passed during a dynamic invocation
 * using the Dynamic Invocation Interface (DII).
 * <P>
 * The code fragment below shows a typical usage:
 * <PRE>
 *  ORB orb = ORB.init(args, null);
 *  org.omg.CORBA.NamedValue nv = orb.create_named_value(
 *        "argumentIdentifier", myAny, org.omg.CORBA.ARG_INOUT.value);
 * </PRE>
 *
 * @version 1.5, 09/09/97
 * @see     org.omg.CORBA.NamedValue
 * @since   JDK1.2
 */
public interface ARG_INOUT {

/**
 * The constant value indicating an argument used for both
 * input and output.
 */
  int value = 3;
}




