package com.leetcode.rmi.client;

import com.leetcode.rmi.shared.WorldClock;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalDateTime;


/**
 * Learn Java from https://www.liaoxuefeng.com/
 * 
 * @author liaoxuefeng
 */
public class Client {

	public static void main(String[] args) throws RemoteException, NotBoundException {
		Registry registry = LocateRegistry.getRegistry("localhost", 1099);
		WorldClock worldClock = (WorldClock) registry.lookup(WorldClock.class.getSimpleName());
		LocalDateTime now = worldClock.getLocalDateTime("Asia/Shanghai");
		System.out.println(now);
	}
}
