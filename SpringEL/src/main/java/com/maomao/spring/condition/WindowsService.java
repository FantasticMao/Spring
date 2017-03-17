package com.maomao.spring.condition;

public class WindowsService implements OsService {

    @Override
    public void service() {
        System.out.println("windows os");
    }
}
