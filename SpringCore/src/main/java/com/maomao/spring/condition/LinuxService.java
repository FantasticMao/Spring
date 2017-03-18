package com.maomao.spring.condition;

public class LinuxService implements OsService {

    @Override
    public void service() {
        System.out.println("Linux os");
    }
}
