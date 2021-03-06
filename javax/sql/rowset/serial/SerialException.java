/*
 * @(#)SerialException.java	1.6 10/03/23
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package javax.sql.rowset.serial;

import java.sql.SQLException;

/**
 * Indicates and an error with the serialization or de-serialization of
 * SQL types such as <code>BLOB, CLOB, STRUCT or ARRAY</code> in 
 * addition to SQL types such as <code>DATALINK and JAVAOBJECT</code>
 *
 * @version 0.1
 */
public class SerialException extends java.sql.SQLException {

    /**
     * Creates a new <code>SerialException</code> without a
     * message.
     */
     public SerialException() {
     }

    /**
     * Creates a new <code>SerialException</code> with the
     * specified message.
     * 
     * @param msg the detail message
     */
    public SerialException(String msg) {
	super(msg);
    }
    
    static final long serialVersionUID = -489794565168592690L;
}
