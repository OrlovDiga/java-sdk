/*
 * @(#)file      JDMTrapNum.java
 * @(#)author    Sun Microsystems, Inc.
 * @(#)version   4.9
 * @(#)date      10/06/22
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */


/* Generated By:JJTree: Do not edit this line. JDMTrapNum.java */

package com.sun.jmx.snmp.IPAcl;

/** 
 * @version     4.9     03/23/10 
 * @author      Sun Microsystems, Inc. 
 */ 
class JDMTrapNum extends SimpleNode {
  protected int low=0;
  protected int high=0;

  JDMTrapNum(int id) {
    super(id);
  }

  JDMTrapNum(Parser p, int id) {
    super(p, id);
  }

  public static Node jjtCreate(int id) {
      return new JDMTrapNum(id);
  }

  public static Node jjtCreate(Parser p, int id) {
      return new JDMTrapNum(p, id);
  }
}
