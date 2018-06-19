package com.bestgo.common.db.datasource;

public class DynamicDataSourceHolder {
	
	public static final ThreadLocal<String> holder = new ThreadLocal<String>();

    public static void putDataSource(String name) {
        holder.set(name);
    }

    public static String getDataSouce() {
    	String str = holder.get();
        return str;
    }
    
}
