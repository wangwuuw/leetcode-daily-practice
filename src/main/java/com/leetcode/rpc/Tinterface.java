package com.leetcode.rpc;

public interface Tinterface {
    String send(String msg);
}

class TinterfaceImpl implements Tinterface {
    @Override
    public String send(String msg) {
        return "send message " + msg;
    }
}

