package com.test.listener;

import java.util.HashSet;
import java.util.Set;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class InterleavingDetector implements IInvokedMethodListener {

    String clazz;
    Set<String> clazzes = new HashSet<>();

    public void beforeInvocation(final IInvokedMethod method, final ITestResult testResult) {
        String claz = testResult.getMethod().getTestClass().getRealClass().getSimpleName();
        System.out.print(claz + '#' + testResult.getMethod().getMethodName());
        if (!claz.equals(clazz)) {
            clazz = claz;
            if (!clazzes.add(claz)) {
                System.out.print(" Interleaving detected");
            }
        }
        System.out.println();
    }

    public void afterInvocation(final IInvokedMethod method, final ITestResult testResult) {
    }
}
