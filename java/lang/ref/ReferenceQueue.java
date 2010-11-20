/*
 * @(#)ReferenceQueue.java	1.27 10/03/23
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package java.lang.ref;

/**
 * Reference queues, to which registered reference objects are appended by the
 * garbage collector after the appropriate reachability changes are detected.
 *
 * @version  1.27, 03/23/10
 * @author   Mark Reinhold
 * @since    1.2
 */

public class ReferenceQueue<T> {

    /**
     * Constructs a new reference-object queue.
     */
    public ReferenceQueue() { }

    private static class Null extends ReferenceQueue {
	boolean enqueue(Reference r) {
	    return false;
	}
    }

    static ReferenceQueue NULL = new Null();
    static ReferenceQueue ENQUEUED = new Null();

    static private class Lock { };
    private Lock lock = new Lock();
    private volatile Reference<? extends T> head = null;
    private long queueLength = 0;

    boolean enqueue(Reference<? extends T> r) {	/* Called only by Reference class */
	synchronized (r) {
	    if (r.queue == ENQUEUED) return false;
	    synchronized (lock) {
		r.queue = ENQUEUED;
		r.next = (head == null) ? r : head;
		head = r;
		queueLength++;
                if (r instanceof FinalReference) {
                    sun.misc.VM.addFinalRefCount(1);
                }
		lock.notifyAll();
		return true;
	    }
	}
    }

    private Reference<? extends T> reallyPoll() {	/* Must hold lock */
	if (head != null) {
	    Reference<? extends T> r = head;
	    head = (r.next == r) ? null : r.next;
	    r.queue = NULL;
	    r.next = r;
	    queueLength--;
            if (r instanceof FinalReference) {
                sun.misc.VM.addFinalRefCount(-1);
            }
	    return r;
	}
	return null;
    }

    /**
     * Polls this queue to see if a reference object is available.  If one is
     * available without further delay then it is removed from the queue and
     * returned.  Otherwise this method immediately returns <tt>null</tt>.
     *
     * @return  A reference object, if one was immediately available,
     *          otherwise <code>null</code>
     */
    public Reference<? extends T> poll() {
        if (head == null)
            return null;
	synchronized (lock) {
	    return reallyPoll();
	}
    }

    /**
     * Removes the next reference object in this queue, blocking until either
     * one becomes available or the given timeout period expires.
     *
     * <p> This method does not offer real-time guarantees: It schedules the
     * timeout as if by invoking the {@link Object#wait(long)} method.
     *
     * @param  timeout  If positive, block for up to <code>timeout</code>
     *                  milliseconds while waiting for a reference to be
     *                  added to this queue.  If zero, block indefinitely.
     *
     * @return  A reference object, if one was available within the specified
     *          timeout period, otherwise <code>null</code>
     *
     * @throws  IllegalArgumentException
     *          If the value of the timeout argument is negative
     *
     * @throws  InterruptedException
     *          If the timeout wait is interrupted
     */
    public Reference<? extends T> remove(long timeout)
	throws IllegalArgumentException, InterruptedException
    {
	if (timeout < 0) {
	    throw new IllegalArgumentException("Negative timeout value");
	}
	synchronized (lock) {
	    Reference<? extends T> r = reallyPoll();
	    if (r != null) return r;
	    for (;;) {
		lock.wait(timeout);
		r = reallyPoll();
		if (r != null) return r;
		if (timeout != 0) return null;
	    }
	}
    }

    /**
     * Removes the next reference object in this queue, blocking until one
     * becomes available.
     *
     * @return A reference object, blocking until one becomes available
     * @throws  InterruptedException  If the wait is interrupted
     */
    public Reference<? extends T> remove() throws InterruptedException {
	return remove(0);
    }

}
