/*
 * @(#)UnsupportedFlavorException.java	1.17 10/03/23
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package java.awt.datatransfer;

/**
 * Signals that the requested data is not supported in this flavor.
 * @see Transferable#getTransferData
 *
 * @version 	1.17, 03/23/10
 * @author	Amy Fowler
 */
public class UnsupportedFlavorException extends Exception {

    /*
     * JDK 1.1 serialVersionUID 
     */
    private static final long serialVersionUID = 5383814944251665601L;

    /**
     * Constructs an UnsupportedFlavorException.
     *
     * @param flavor the flavor object which caused the exception. May
     *        be <code>null</code>.
     */  
    public UnsupportedFlavorException(DataFlavor flavor) {
        super((flavor != null) ? flavor.getHumanPresentableName() : null);
    }
}
