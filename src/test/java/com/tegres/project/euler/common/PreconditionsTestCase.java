package com.tegres.project.euler.common;

import com.tegres.project.euler.base.AbstractTestCase;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class PreconditionsTestCase extends AbstractTestCase {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Ignore
    public void noOp(){
        assertTrue(true);
    }

    @Test
    public void testNotNullObject() {
        String message = "Object should not be null";
        Preconditions.notNull(new Object(),message);
    }

    @Test
    public void testNotNullObjectWithSupplier() {
        Preconditions.notNull(new Object(), () -> String.format("Object should not be null %s",1));
    }
}