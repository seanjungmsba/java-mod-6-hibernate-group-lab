package org.example.shared.io.console;

import org.example.shared.io.UserOutputService;

public class ConsoleUserOutputServiceImpl implements UserOutputService {

    @Override
    public void print(String output) {
        System.out.println(output);
    }
}
