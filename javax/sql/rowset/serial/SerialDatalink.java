/*
 * @(#)SerialDatalink.java	1.7 10/03/23
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package javax.sql.rowset.serial;

import java.sql.*;
import java.io.*;
import java.net.URL;


/**
 * A serialized mapping in the Java programming language of an SQL 
 * <code>DATALINK</code> value. A <code>DATALINK</code> value 
 * references a file outside of the underlying data source that the
 * data source manages.
 * <P>
 * <code>RowSet</code> implementations can use the method <code>RowSet.getURL</code>
 * to retrieve a <code>java.net.URL</code> object, which can be used
 * to manipulate the external data.
 * <pre>
 *      java.net.URL url = rowset.getURL(1);
 * </pre>
 */
public class SerialDatalink implements Serializable, Cloneable {

    /**
     * The extracted URL field retrieved from the DATALINK field.
     * @serial
     */
    private URL url;

    /**
     * The SQL type of the elements in this <code>SerialDatalink</code> 
     * object.  The type is expressed as one of the contants from the
     * class <code>java.sql.Types</code>.
     * @serial
     */
    private int baseType;

    /**
     * The type name used by the DBMS for the elements in the SQL 
     * <code>DATALINK</code> value that this SerialDatalink object
     * represents.
     * @serial
     */
    private String baseTypeName;

    /**
      * Constructs a new <code>SerialDatalink</code> object from the given
      * <code>java.net.URL</code> object.
      * <P>
      * @throws SerialException if url parameter is a null
      */
    public SerialDatalink(URL url) throws SerialException {
	if (url == null) {
	    throw new SerialException("Cannot serialize empty URL instance");
	}
	this.url = url;
    }

    /**
     * Returns a new URL that is a copy of this <code>SerialDatalink</code> 
     * object. 
     *
     * @return a copy of this <code>SerialDatalink</code> object as a
     * <code>URL</code> object in the Java programming language.
     * @throws SerialException if the <code>URL</code> object cannot be de-serialized
     */
    public URL getDatalink() throws SerialException {

	URL aURL = null;

	try {
	    aURL = new URL((this.url).toString());
	} catch (java.net.MalformedURLException e) {
	    throw new SerialException("MalformedURLException: " + e.getMessage());
	}
	return aURL;
    }
    

    /**
	 * The identifier that assists in the serialization of this <code>SerialDatalink</code>
     * object.
     */
    static final long serialVersionUID = 2826907821828733626L;
}
