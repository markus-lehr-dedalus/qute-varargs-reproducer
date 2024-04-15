package org.example;

import io.quarkus.qute.Qute;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

@QuarkusTest
class QuteVarargsTest {

    @Test
    void basicVarargsTest() {
        Object argument = "String";
        Object[] varargs = ObjectExtensionMethods.varargs(5, argument);
        Assertions.assertNotNull(varargs);
        Assertions.assertEquals("String", varargs[0]);
    }

    @Test
    void quteEmptyVarargsTest() {
        Map<String, Object> payload = new HashMap<>();
        payload.put("foo", "bar"); // actually unused
        String result = Qute.fmt("{obj:varargs(5)}", payload);
        Assertions.assertNotNull(result);
        Assertions.assertFalse(result.isEmpty());
    }

    @Test
    void quteOneVarargsTest() {
        Map<String, Object> payload = new HashMap<>();
        payload.put("foo", "bar");
        String result = Qute.fmt("{obj:varargs(5, foo)}", payload);
        Assertions.assertNotNull(result);
        Assertions.assertFalse(result.isEmpty());
    }

    @Test
    void quteTwoVarargsTest() {
        Map<String, Object> payload = new HashMap<>();
        payload.put("foo", "bar");
        payload.put("baz", "bar");
        String result = Qute.fmt("{obj:varargs(5, foo, baz)}", payload);
        Assertions.assertNotNull(result);
        Assertions.assertFalse(result.isEmpty());
    }

    @Test
    void quteBasicCdiTest() {
        Map<String, Object> payload = new HashMap<>();
        String result = Qute.fmt("{cdi:varargsTemplateExtension.identity(5)}", payload);
        Assertions.assertNotNull(result);
        Assertions.assertFalse(result.isEmpty());
    }

    @Test
    void quteCdiEmptyVarargsTest() {
        Map<String, Object> payload = new HashMap<>();
        payload.put("foo", "bar");
        payload.put("baz", "bar");
        String result = Qute.fmt("{cdi:varargsTemplateExtension.varargs(5)}", payload);
        Assertions.assertNotNull(result);
        Assertions.assertFalse(result.isEmpty());
    }

    @Test
    void quteCdiOneVarargsTest() {
        Map<String, Object> payload = new HashMap<>();
        payload.put("foo", "bar");
        payload.put("baz", "bar");
        String result = Qute.fmt("{cdi:varargsTemplateExtension.varargs(5, foo)}", payload);
        Assertions.assertNotNull(result);
        Assertions.assertFalse(result.isEmpty());
    }

    @Test
    void quteCdiTwoVarargsTest() {
        Map<String, Object> payload = new HashMap<>();
        payload.put("foo", "bar");
        payload.put("baz", "bar");
        String result = Qute.fmt("{cdi:varargsTemplateExtension.varargs(5, foo, baz)}", payload);
        Assertions.assertNotNull(result);
        Assertions.assertFalse(result.isEmpty());
    }
}