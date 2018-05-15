package com.test.jythonTest;

import org.python.core.Py;
import org.python.core.PyFunction;
import org.python.core.PyObject;
import org.python.core.PySystemState;
import org.python.util.PythonInterpreter;

import java.io.IOException;
import java.util.Properties;

public class PythonTest {
    public static void  main(String[]args) {
        try {
            Process process  = Runtime.getRuntime().exec("python "+"D:\\jkls\\pybugz -u zhouzhou_sx -p Guliangjing52 -a -P TestProduct -C test -t 'easyTest' -c 'test'");
            process.waitFor();
            System.out.println("success");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
