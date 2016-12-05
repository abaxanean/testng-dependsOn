package com.test.listener;

import java.util.List;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import static org.testng.Assert.*;

public class MyMethodInterceptor implements IMethodInterceptor {
    @Override
    public List<IMethodInstance> intercept(final List<IMethodInstance> methods, final ITestContext context) {
        assertTrue(methods.stream().noneMatch(m -> m.getMethod().getMethodsDependedUpon().length > 0));
        return methods;
    }
}
