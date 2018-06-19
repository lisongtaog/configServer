package com.bestgo.common.util;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;

public class IpUtil {
	static 	InetAddress addr = null;
	static{
		try {
			addr = InetAddress.getLocalHost();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static String getIp(){
		return addr.getHostAddress();
	}
	public static String getHostName(){
		return addr.getHostName();
	}

	/**
	 * 获取客户端IP
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request) {
		if(null==request){
			return "";
		}
		String ip = request.getHeader("x-forwarded-for");

		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}

		return ip;
	}
}
