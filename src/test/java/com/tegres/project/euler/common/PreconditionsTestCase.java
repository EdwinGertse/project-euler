package com.tegres.project.euler.common;

import com.tegres.project.euler.base.AbstractTestCase;
import org.junit.jupiter.api.Test;

public class PreconditionsTestCase extends AbstractTestCase {

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
