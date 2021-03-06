/*
 * @(#)CorbaAcceptor.java	1.14 10/03/23
 * 
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.sun.corba.se.spi.transport;

import com.sun.corba.se.pept.transport.Acceptor;

import com.sun.corba.se.spi.ior.IORTemplate;

// REVISIT - impl/poa specific:
import com.sun.corba.se.impl.oa.poa.Policies;

/**
 * @author Harold Carr
 */
public interface CorbaAcceptor
    extends
	Acceptor
{
    public String getObjectAdapterId();
    public String getObjectAdapterManagerId();
    public void addToIORTemplate(IORTemplate iorTemplate, Policies policies,
				 String codebase);
    public String getMonitoringName();
}

// End of file.
