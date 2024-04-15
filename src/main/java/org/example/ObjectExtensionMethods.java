package org.example;

import io.quarkus.qute.TemplateExtension;

@TemplateExtension(namespace = "obj")
public class ObjectExtensionMethods {
    public static Object[] varargs(int propertyWhichIsAlwaysHere, Object... args) {
        return args;
    }
}