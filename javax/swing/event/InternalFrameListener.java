/*
 * @(#)InternalFrameListener.java	1.14 10/03/23
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package javax.swing.event;

import java.util.EventListener;

/**
 * The listener interface for receiving internal frame events.
 * This class is functionally equivalent to the WindowListener class
 * in the AWT.
 * <p>
 * See <a href="http://java.sun.com/docs/books/tutorial/uiswing/events/internalframelistener.html">How to Write an Internal Frame Listener</a>
 * in <em>The Java Tutorial</em> and
 * <a href="http://www.awl.com/cp/javaseries/jcl1_2.html">The Java Class Libraries (update)</a>
 * for further documentation.
 *
 * @see java.awt.event.WindowListener
 *
 * @version 1.14 03/23/10
 * @author Thomas Ball
 */
public interface InternalFrameListener extends EventListener {
    /**
     * Invoked when a internal frame has been opened.
     * @see javax.swing.JInternalFrame#show
     */
    public void internalFrameOpened(InternalFrameEvent e);

    /**
     * Invoked when an internal frame is in the process of being closed.
     * The close operation can be overridden at this point.
     * @see javax.swing.JInternalFrame#setDefaultCloseOperation
     */
    public void internalFrameClosing(InternalFrameEvent e);

    /**
     * Invoked when an internal frame has been closed.
     * @see javax.swing.JInternalFrame#setClosed
     */
    public void internalFrameClosed(InternalFrameEvent e);

    /**
     * Invoked when an internal frame is iconified.
     * @see javax.swing.JInternalFrame#setIcon
     */
    public void internalFrameIconified(InternalFrameEvent e);

    /**
     * Invoked when an internal frame is de-iconified.
     * @see javax.swing.JInternalFrame#setIcon
     */
    public void internalFrameDeiconified(InternalFrameEvent e);

    /**
     * Invoked when an internal frame is activated.
     * @see javax.swing.JInternalFrame#setSelected
     */
    public void internalFrameActivated(InternalFrameEvent e);

    /**
     * Invoked when an internal frame is de-activated.
     * @see javax.swing.JInternalFrame#setSelected
     */
    public void internalFrameDeactivated(InternalFrameEvent e);
}