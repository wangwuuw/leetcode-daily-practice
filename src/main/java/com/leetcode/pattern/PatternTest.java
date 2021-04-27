//package com.leetcode.pattern;
//
//import sun.jvmstat.monitor.HostIdentifier;
//import sun.jvmstat.monitor.MonitorException;
//import sun.jvmstat.monitor.MonitoredHost;
//import sun.jvmstat.monitor.MonitoredVm;
//import sun.jvmstat.monitor.MonitoredVmUtil;
//import sun.jvmstat.monitor.VmIdentifier;
//
//import java.io.IOException;
//import java.io.OutputStream;
//import java.util.Arrays;
//import java.util.Set;
//
///**
// * @Author: wangwu
// * @Date: Created in 17:16 2021/04/19
// * @Description:
// */
//public class PatternTest {
//	public static void main(String[] args) {
//		String[] arr = asArray("one", "two", "three");
//		System.out.println(Arrays.toString(arr));
//		// ClassCastException:
////		String[] firstTwo = pickTwo("one", "two", "three");
////		System.out.println(Arrays.toString(firstTwo));
//		System.out.println("pid："+getPid(PatternTest.class));
//		try(OutputStream output = new OutputStream() {
//			@Override
//			public void write(int b) throws IOException {
//
//			}
//		}){
//
//		}catch (Exception e){
//
//		}
//
//	}
//
//	static <K> K[] pickTwo(K k1, K k2, K k3) {
//		return asArray(k1, k2);
//	}
//
//	static <T> T[] asArray(T... objs) {
//		return objs;
//	}
//	public static Integer getPid(Class<?> mainClass) {
//		MonitoredHost monitoredHost;
//		Set<Integer> activeVmPids;
//		try {
//			monitoredHost = MonitoredHost.getMonitoredHost(new HostIdentifier((String) null));
//			activeVmPids = monitoredHost.activeVms();
//			MonitoredVm mvm = null;
//			for (Integer vmPid : activeVmPids) {
//				try {
//					mvm = monitoredHost.getMonitoredVm(new VmIdentifier(vmPid.toString()));
//					String mvmMainClass = MonitoredVmUtil.mainClass(mvm, true);
//					if (mainClass.getName().equals(mvmMainClass)) {
//						return vmPid;
//					}
//				} finally {
//					if (mvm != null) {
//						mvm.detach();
//					}
//				}
//			}
//		} catch (java.net.URISyntaxException e) {
//			throw new InternalError(e.getMessage());
//		} catch (MonitorException e) {
//			throw new InternalError(e.getMessage());
//		}
//		return null;
//	}
//}
