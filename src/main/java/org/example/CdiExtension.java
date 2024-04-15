package org.example;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

@Dependent
@Named("varargsTemplateExtension")
public class CdiExtension {
    public Object[] varargs(long propertyWhichIsAlwaysHere, Object... args) {
        return args;
    }

    public int identity(int value) {
        return value;
    }
}
