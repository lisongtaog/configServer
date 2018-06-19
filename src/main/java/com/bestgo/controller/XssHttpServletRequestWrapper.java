package com.bestgo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.web.util.HtmlUtils;

public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper{
	
	HttpServletRequest orgRequest = null;

	public XssHttpServletRequestWrapper(HttpServletRequest request) {
		super(request);
		orgRequest = request;
	}
	/**
    * 覆盖getParameter方法，将参数名和参数值都做xss过滤。<br/>
    * 如果需要获得原始的值，则通过super.getParameterValues(name)来获取<br/>
    * getParameterNames,getParameterValues和getParameterMap也可能需要覆盖
    */ 
	@Override 
	public String getParameter(String name) { 
        String value = super.getParameter(name);
        if (value != null) { 
            value = xssEncode(value); 
        } 
        return value; 
    } 
	/**
    * 覆盖getHeader方法，将参数名和参数值都做xss过滤。<br/>
    * 如果需要获得原始的值，则通过super.getHeaders(name)来获取<br/>
    * getHeaderNames 也可能需要覆盖
    */ 
    @Override 
    public String getHeader(String name) { 
        String value = super.getHeader(xssEncode(name)); 
        if (value != null) { 
            value = xssEncode(value); 
        } 
        return value; 
    } 
    
    
    @Override
	public Map<String, String[]> getParameterMap() {
		Map<String, String[]> encodeMap = new HashMap<String, String[]>();
		Map<String, String[]> sourceMap = super.getParameterMap();
		if(sourceMap != null && !sourceMap.isEmpty()) {
			for(String key : sourceMap.keySet()) {
				Object[] values = sourceMap.get(key);
				String[] encodeValues = new String[values.length];
				if(values != null) {
					for(int i=0; i<values.length; i++) {
						encodeValues[i] = xssEncode(String.valueOf(values[i]));
					}
				}
				encodeMap.put(key, encodeValues);
			}
		}
		return encodeMap;
	}
	/**
     * 将容易引起xss漏洞的半角字符直接替换成全角字符
     * @param s
     * @return
     */ 
     private static String xssEncode(String s) {
         if (s == null || "".equals(s)) { 
             return s; 
         }
         String resultValue = StringEscapeUtils.escapeSql(s);
         resultValue = HtmlUtils.htmlEscape(resultValue);
         return resultValue;
     } 
     /**
      * 获取最原始的request
      * @return
     */ 
     public HttpServletRequest getOrgRequest() { 
         return orgRequest; 
     } 
     /**
      * 获取最原始的request的静态方法
      * @return
     */ 
     public static HttpServletRequest getOrgRequest(HttpServletRequest req) { 
         if (req instanceof XssHttpServletRequestWrapper) { 
             return ((XssHttpServletRequestWrapper) req).getOrgRequest(); 
         } 
         return req; 
      } 
}
