/*
 * @(#)DescriptorRead.java	1.4 10/03/23
 * 
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package javax.management;

/**
 * Interface to read the Descriptor of a management interface element
 * such as an MBeanInfo.
 * @since 1.6
 */
public interface DescriptorRead {
   /** 
    * Returns a copy of Descriptor.
    *
    * @return Descriptor associated with the component implementing this interface.
    * The return value is never null, but the returned descriptor may be empty.
    */
    public Descriptor getDescriptor();
}
