package com.shareniu.bbs.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.Assert;

public final class MyWebUtils
{
  private static final String cookieDomain = "";
  private static final String cookiePath = "/";

  public static void addCookie(HttpServletRequest request, HttpServletResponse response, String name, String value, Integer maxAge, String path, String domain, Boolean secure)
  {
    Assert.notNull(request);
    Assert.notNull(response);
    Assert.hasText(name);
    try {
      name = URLEncoder.encode(name, "UTF-8");
      value = URLEncoder.encode(value, "UTF-8");
      Cookie cookie = new Cookie(name, value);
      if (maxAge != null) {
        cookie.setMaxAge(maxAge.intValue());
      }
      if (StringUtils.isNotEmpty(path)) {
        cookie.setPath(path);
      }
      if (StringUtils.isNotEmpty(domain)) {
        cookie.setDomain(domain);
      }
      if (secure != null) {
        cookie.setSecure(secure.booleanValue());
      }
      response.addCookie(cookie);
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
  }

  public static void addCookie(HttpServletRequest request, HttpServletResponse response, String name, String value, Integer maxAge)
  {
    addCookie(request, response, name, value, maxAge, "/", "", null);
  }

  public static void addCookie(HttpServletRequest request, HttpServletResponse response, String name, String value)
  {
    addCookie(request, response, name, value, null, "/", "", null);
  }

  public static String getCookie(HttpServletRequest request, String name)
  {
    Assert.notNull(request);
    Assert.hasText(name);
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
      try {
        name = URLEncoder.encode(name, "UTF-8");
        for (Cookie cookie : cookies)
          if (name.equals(cookie.getName()))
            return URLDecoder.decode(cookie.getValue(), "UTF-8");
      }
      catch (UnsupportedEncodingException e)
      {
        e.printStackTrace();
      }
    }
    return null;
  }

  public static void removeCookie(HttpServletRequest request, HttpServletResponse response, String name, String path, String domain)
  {
    Assert.notNull(request);
    Assert.notNull(response);
    Assert.hasText(name);
    try {
      name = URLEncoder.encode(name, "UTF-8");
      Cookie cookie = new Cookie(name, null);
      cookie.setMaxAge(0);
      if (StringUtils.isNotEmpty(path)) {
        cookie.setPath(path);
      }
      if (StringUtils.isNotEmpty(domain)) {
        cookie.setDomain(domain);
      }
      response.addCookie(cookie);
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
  }

  public static void removeCookie(HttpServletRequest request, HttpServletResponse response, String name)
  {
    removeCookie(request, response, name, "/", "");
  }

  public static String getParameter(String queryString, String encoding, String name)
  {
    String[] parameterValues = (String[])getParameterMap(queryString, encoding).get(name);
    return (parameterValues != null) && (parameterValues.length > 0) ? parameterValues[0] : null;
  }

  public static String[] getParameterValues(String queryString, String encoding, String name)
  {
    return (String[])getParameterMap(queryString, encoding).get(name);
  }

  public static Map<String, String[]> getParameterMap(String queryString, String encoding)
  {
    Map parameterMap = new HashMap();
    Charset charset = Charset.forName(encoding);
    if (StringUtils.isNotEmpty(queryString)) {
      byte[] bytes = queryString.getBytes(charset);
      if ((bytes != null) && (bytes.length > 0)) {
        int ix = 0;
        int ox = 0;
        String key = null;
        String value = null;
        while (ix < bytes.length) {
          byte c = bytes[(ix++)];
          switch ((char)c) {
          case '&':
            value = new String(bytes, 0, ox, charset);
            if (key != null) {
              putMapEntry(parameterMap, key, value);
              key = null;
            }
            ox = 0;
            break;
          case '=':
            if (key == null) {
              key = new String(bytes, 0, ox, charset);
              ox = 0;
            } else {
              bytes[(ox++)] = c;
            }
            break;
          case '+':
            bytes[(ox++)] = 32;
            break;
          case '%':
            bytes[(ox++)] = ((byte)((convertHexDigit(bytes[(ix++)]) << 4) + convertHexDigit(bytes[(ix++)])));
            break;
          default:
            bytes[(ox++)] = c;
          }
        }
        if (key != null) {
          value = new String(bytes, 0, ox, charset);
          putMapEntry(parameterMap, key, value);
        }
      }
    }
    return parameterMap;
  }

  private static void putMapEntry(Map<String, String[]> map, String name, String value) {
    String[] newValues = null;
    String[] oldValues = (String[])map.get(name);
    if (oldValues == null) {
      newValues = new String[] { value };
    } else {
      newValues = new String[oldValues.length + 1];
      System.arraycopy(oldValues, 0, newValues, 0, oldValues.length);
      newValues[oldValues.length] = value;
    }
    map.put(name, newValues);
  }

  private static byte convertHexDigit(byte b) {
    if ((b >= 48) && (b <= 57)) {
      return (byte)(b - 48);
    }
    if ((b >= 97) && (b <= 102)) {
      return (byte)(b - 97 + 10);
    }
    if ((b >= 65) && (b <= 70)) {
      return (byte)(b - 65 + 10);
    }
    throw new IllegalArgumentException();
  }
}