/*
 * @(#)file      JDMIpMask.java
 * @(#)author    Sun Microsystems, Inc.
 * @(#)version   4.10
 * @(#)date      10/06/22
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */


/* Generated By:JJTree: Do not edit this line. JDMIpMask.java */

package com.sun.jmx.snmp.IPAcl;

import java.lang.StringBuffer;
import java.net.UnknownHostException;

/** 
 * @version     4.10     03/23/10 
 * @author      Sun Microsystems, Inc. 
 */ 
class JDMIpMask extends Host {

  protected StringBuffer address= new StringBuffer();

  JDMIpMask(int id) {
    super(id);
  }

  JDMIpMask(Parser p, int id) {
    super(p, id);
  }

  public static Node jjtCreate(int id) {
      return new JDMIpMask(id);
  }

  public static Node jjtCreate(Parser p, int id) {
      return new JDMIpMask(p, id);
  }
  
  protected String getHname() {
	return address.toString();
  }
  
  protected PrincipalImpl createAssociatedPrincipal() 
    throws UnknownHostException { 
      return new GroupImpl(address.toString());
  }
}
