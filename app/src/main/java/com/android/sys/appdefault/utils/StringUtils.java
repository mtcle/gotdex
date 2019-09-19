package com.android.sys.appdefault.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.text.Editable;


public class StringUtils {
    public static final String EMPTY = "";
   
    public static final int INDEX_NOT_FOUND = -1;
   
    public StringUtils() {
        super();
    }
    // Empty checks
    //-----------------------------------------------------------------------
   
    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }
   
    public static boolean isNotEmpty(String str) {
        return !StringUtils.isEmpty(str);
    }
   
    public static boolean isBlank(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if ((Character.isWhitespace(str.charAt(i)) == false)) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean isBlank(Editable edit) {
        int strLen;
        String str = edit.toString();
        if (str == null || (strLen = str.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if ((Character.isWhitespace(str.charAt(i)) == false)) {
                return false;
            }
        }
        return true;
    }
   
    public static boolean isNotBlank(String str) {
        return !StringUtils.isBlank(str);
    }
    // Trim
    //-----------------------------------------------------------------------
   
    public static String clean(String str) {
        return str == null ? EMPTY : str.trim();
    }
   
    public static String trim(String str) {
        return str == null ? null : str.trim();
    }
   
    public static String trimToNull(String str) {
        String ts = trim(str);
        return isEmpty(ts) ? null : ts;
    }
   
    public static String trimToEmpty(String str) {
        return str == null ? EMPTY : str.trim();
    }
    // Stripping
    //-----------------------------------------------------------------------
   
    public static String strip(String str) {
        return strip(str, null);
    }
   
    public static String stripToNull(String str) {
        if (str == null) {
            return null;
        }
        str = strip(str, null);
        return str.length() == 0 ? null : str;
    }
   
    public static String stripToEmpty(String str) {
        return str == null ? EMPTY : strip(str, null);
    }
   
    public static String strip(String str, String stripChars) {
        if (isEmpty(str)) {
            return str;
        }
        str = stripStart(str, stripChars);
        return stripEnd(str, stripChars);
    }
   
    public static String stripStart(String str, String stripChars) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return str;
        }
        int start = 0;
        if (stripChars == null) {
            while ((start != strLen) && Character.isWhitespace(str.charAt(start))) {
                start++;
            }
        } else if (stripChars.length() == 0) {
            return str;
        } else {
            while ((start != strLen) && (stripChars.indexOf(str.charAt(start)) != -1)) {
                start++;
            }
        }
        return str.substring(start);
    }
   
    public static String stripEnd(String str, String stripChars) {
        int end;
        if (str == null || (end = str.length()) == 0) {
            return str;
        }
        if (stripChars == null) {
            while ((end != 0) && Character.isWhitespace(str.charAt(end - 1))) {
                end--;
            }
        } else if (stripChars.length() == 0) {
            return str;
        } else {
            while ((end != 0) && (stripChars.indexOf(str.charAt(end - 1)) != -1)) {
                end--;
            }
        }
        return str.substring(0, end);
    }
    // StripAll
    //-----------------------------------------------------------------------
   
    public static String[] stripAll(String[] strs) {
        return stripAll(strs, null);
    }
   
    public static String[] stripAll(String[] strs, String stripChars) {
        int strsLen;
        if (strs == null || (strsLen = strs.length) == 0) {
            return strs;
        }
        String[] newArr = new String[strsLen];
        for (int i = 0; i < strsLen; i++) {
            newArr[i] = strip(strs[i], stripChars);
        }
        return newArr;
    }
    // Equals
    //-----------------------------------------------------------------------
   
    public static boolean equals(String str1, String str2) {
        return str1 == null ? str2 == null : str1.equals(str2);
    }
   
    public static boolean equalsIgnoreCase(String str1, String str2) {
        return str1 == null ? str2 == null : str1.equalsIgnoreCase(str2);
    }
    // IndexOf
    //-----------------------------------------------------------------------
   
    public static int indexOf(String str, char searchChar) {
        if (isEmpty(str)) {
            return -1;
        }
        return str.indexOf(searchChar);
    }
   
    public static int indexOf(String str, char searchChar, int startPos) {
        if (isEmpty(str)) {
            return -1;
        }
        return str.indexOf(searchChar, startPos);
    }
   
    public static int indexOf(String str, String searchStr) {
        if (str == null || searchStr == null) {
            return -1;
        }
        return str.indexOf(searchStr);
    }
   
    public static int ordinalIndexOf(String str, String searchStr, int ordinal) {
        if (str == null || searchStr == null || ordinal <= 0) {
            return INDEX_NOT_FOUND;
        }
        if (searchStr.length() == 0) {
            return 0;
        }
        int found = 0;
        int index = INDEX_NOT_FOUND;
        do {
            index = str.indexOf(searchStr, index + 1);
            if (index < 0) {
                return index;
            }
            found++;
        } while (found < ordinal);
        return index;
    }
   
    public static int indexOf(String str, String searchStr, int startPos) {
        if (str == null || searchStr == null) {
            return -1;
        }
        // JDK1.2/JDK1.3 have a bug, when startPos > str.length for "", hence
        if (searchStr.length() == 0 && startPos >= str.length()) {
            return str.length();
        }
        return str.indexOf(searchStr, startPos);
    }
    // LastIndexOf
    //-----------------------------------------------------------------------
   
    public static int lastIndexOf(String str, char searchChar) {
        if (isEmpty(str)) {
            return -1;
        }
        return str.lastIndexOf(searchChar);
    }
   
    public static int lastIndexOf(String str, char searchChar, int startPos) {
        if (isEmpty(str)) {
            return -1;
        }
        return str.lastIndexOf(searchChar, startPos);
    }
   
    public static int lastIndexOf(String str, String searchStr) {
        if (str == null || searchStr == null) {
            return -1;
        }
        return str.lastIndexOf(searchStr);
    }
   
    public static int lastIndexOf(String str, String searchStr, int startPos) {
        if (str == null || searchStr == null) {
            return -1;
        }
        return str.lastIndexOf(searchStr, startPos);
    }
    // Contains
    //-----------------------------------------------------------------------
   
    public static boolean contains(String str, char searchChar) {
        if (isEmpty(str)) {
            return false;
        }
        return str.indexOf(searchChar) >= 0;
    }
   
    public static boolean contains(String str, String searchStr) {
        if (str == null || searchStr == null) {
            return false;
        }
        return str.indexOf(searchStr) >= 0;
    }
   
    public static boolean containsIgnoreCase(String str, String searchStr) {
        if (str == null || searchStr == null) {
            return false;
        }
        return contains(str.toUpperCase(), searchStr.toUpperCase());
    }
    
    // ContainsAny
    //-----------------------------------------------------------------------
   
    public static boolean containsAny(String str, char[] searchChars) {
        if (str == null || str.length() == 0 || searchChars == null || searchChars.length == 0) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            for (int j = 0; j < searchChars.length; j++) {
                if (searchChars[j] == ch) {
                    return true;
                }
            }
        }
        return false;
    }
   
    public static boolean containsAny(String str, String searchChars) {
        if (searchChars == null) {
            return false;
        }
        return containsAny(str, searchChars.toCharArray());
    }
   
   
    // Substring
    //-----------------------------------------------------------------------
   
    public static String substring(String str, int start) {
        if (str == null) {
            return null;
        }
        // handle negatives, which means last n characters
        if (start < 0) {
            start = str.length() + start; // remember start is negative
        }
        if (start < 0) {
            start = 0;
        }
        if (start > str.length()) {
            return EMPTY;
        }
        return str.substring(start);
    }
   
    public static String substring(String str, int start, int end) {
        if (str == null) {
            return null;
        }
        // handle negatives
        if (end < 0) {
            end = str.length() + end; // remember end is negative
        }
        if (start < 0) {
            start = str.length() + start; // remember start is negative
        }
        // check length next
        if (end > str.length()) {
            end = str.length();
        }
        // if start is greater than end, return ""
        if (start > end) {
            return EMPTY;
        }
        if (start < 0) {
            start = 0;
        }
        if (end < 0) {
            end = 0;
        }
        return str.substring(start, end);
    }
    // Left/Right/Mid
    //-----------------------------------------------------------------------
   
    public static String left(String str, int len) {
        if (str == null) {
            return null;
        }
        if (len < 0) {
            return EMPTY;
        }
        if (str.length() <= len) {
            return str;
        }
        return str.substring(0, len);
    }
   
    public static String right(String str, int len) {
        if (str == null) {
            return null;
        }
        if (len < 0) {
            return EMPTY;
        }
        if (str.length() <= len) {
            return str;
        }
        return str.substring(str.length() - len);
    }
   
    public static String mid(String str, int pos, int len) {
        if (str == null) {
            return null;
        }
        if (len < 0 || pos > str.length()) {
            return EMPTY;
        }
        if (pos < 0) {
            pos = 0;
        }
        if (str.length() <= (pos + len)) {
            return str.substring(pos);
        }
        return str.substring(pos, pos + len);
    }
    // SubStringAfter/SubStringBefore
    //-----------------------------------------------------------------------
   
    public static String substringBefore(String str, String separator) {
        if (isEmpty(str) || separator == null) {
            return str;
        }
        if (separator.length() == 0) {
            return EMPTY;
        }
        int pos = str.indexOf(separator);
        if (pos == -1) {
            return str;
        }
        return str.substring(0, pos);
    }
   
    public static String substringAfter(String str, String separator) {
        if (isEmpty(str)) {
            return str;
        }
        if (separator == null) {
            return EMPTY;
        }
        int pos = str.indexOf(separator);
        if (pos == -1) {
            return EMPTY;
        }
        return str.substring(pos + separator.length());
    }
   
    public static String substringBeforeLast(String str, String separator) {
        if (isEmpty(str) || isEmpty(separator)) {
            return str;
        }
        int pos = str.lastIndexOf(separator);
        if (pos == -1) {
            return str;
        }
        return str.substring(0, pos);
    }
   
    public static String substringAfterLast(String str, String separator) {
        if (isEmpty(str)) {
            return str;
        }
        if (isEmpty(separator)) {
            return EMPTY;
        }
        int pos = str.lastIndexOf(separator);
        if (pos == -1 || pos == (str.length() - separator.length())) {
            return EMPTY;
        }
        return str.substring(pos + separator.length());
    }
    // Substring between
    //-----------------------------------------------------------------------
   
    public static String substringBetween(String str, String tag) {
        return substringBetween(str, tag, tag);
    }
   
    public static String substringBetween(String str, String open, String close) {
        if (str == null || open == null || close == null) {
            return null;
        }
        int start = str.indexOf(open);
        if (start != -1) {
            int end = str.indexOf(close, start + open.length());
            if (end != -1) {
                return str.substring(start + open.length(), end);
            }
        }
        return null;
    }
   
   
    // Nested extraction
    //-----------------------------------------------------------------------
   
    public static String getNestedString(String str, String tag) {
        return substringBetween(str, tag, tag);
    }
   
    public static String getNestedString(String str, String open, String close) {
        return substringBetween(str, open, close);
    }
    /**
     * 描述：同学圈，发送回复，过滤被截断的表情
     * @param str
     * @return
     */
    public static String stringFilter(String str){
		String newStr = new String();

		char[] cstr = str.toCharArray();
		int flag = 0;
		for (int i = cstr.length - 1; i > 136; i--) {
			if (cstr[i] == '[') {
				newStr = str.substring(0, i);
				flag = 1;
				break;
			} else {
				flag = 0;
			}
		}

		if (flag == 0) {
			return str;
		} else {
			return newStr;
		}

    }
    /**
     * 判断一个字符串是否为邮箱
     */
    public static boolean isEmail(String content){
    	String check = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";    
    	Pattern regex = Pattern.compile(check);    
    	Matcher matcher = regex.matcher(content);    
    	return matcher.matches();
    	/*Pattern p = Pattern.compile("^(\w+((-\w+)|(\.\w+))*)\+\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$");  
        Matcher m = p.matcher(args[0]);
        Matcher m = p.matcher(args[0]);
        return m.matches(); */
    }
    /**
     * 过滤字符串中的字母
     */
    //截取数字  
    public static String getNumbers(String content) {  
        Pattern pattern = Pattern.compile("\\d+");  
        Matcher matcher = pattern.matcher(content);  
        while (matcher.find()) {  
            return matcher.group(0);  
        }  
        return "";  
    }
 // 截取非数字  
    public static String splitNotNumber(String content) {  
        Pattern pattern = Pattern.compile("\\D+");  
        Matcher matcher = pattern.matcher(content);  
        while (matcher.find()) {  
            return matcher.group(0);  
        }  
        return "";  
    }  
    
    /**判断是否全部是数字*/
    public static boolean isNumeric(String str){  
    	   for(int i=str.length();--i>=0;){  
    	      int chr=str.charAt(i);  
    	      if(chr<48 || chr>57)  
    	         return false;  
    	   }  
    	   return true;  
    	}   
    
}