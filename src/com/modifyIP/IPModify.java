package com.modifyIP;

public class IPModify {
	public static void main(String[] args) throws Exception {
		setIP("192.168.0.104");
	}
	
	public static void setIP(String newip) throws Exception {
//		Runtime.getRuntime().exec("netsh    interface    ip    set    addr    \"本地连接\"    static    "
//							+ newip + "    255.255.255.0     10.0.0.1     1");
		String comm = "\"cmd\" \"/c\" \"mypro\" \"D:\\mysql\\mysql-5.6.25-winx64\\bin\"";
		Runtime.getRuntime().exec(comm);
		System.out.println("sdfdsf");
	}
}
