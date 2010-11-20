/*
 * @(#)LabeledStatementTree.java	1.4 10/03/23
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 * Use and Distribution is subject to the Java Research License available
 * at <http://wwws.sun.com/software/communitysource/jrl.html>.
 */

package com.sun.source.tree;

import javax.lang.model.element.Name;

/**
 * A tree node for a labeled statement.
 *
 * For example:
 * <pre>
 *   <em>label</em> : <em>statement</em>
 * </pre>
 *
 * @see "The Java Language Specification, 3rd ed, section 14.7"
 *
 * @author Peter von der Ah&eacute;
 * @author Jonathan Gibbons
 * @since 1.6
 */
public interface LabeledStatementTree extends StatementTree {
    Name getLabel();
    StatementTree getStatement();
}
