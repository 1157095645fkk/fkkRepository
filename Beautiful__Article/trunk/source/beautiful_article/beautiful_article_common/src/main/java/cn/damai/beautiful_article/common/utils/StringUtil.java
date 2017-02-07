package cn.damai.beautiful_article.common.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringUtil {

	public static final String SEARCH_SEPERATOR = "[ ,;|　]";

	public static String[] convertStringToArray(String str) {
		return convertStringToArray(str, null, 0);
	}

	public static String[] convertStringToArray(String str, int limit) {
		return convertStringToArray(str, null, limit);
	}

	public static String[] convertStringToArray(String str, String split) {
		return convertStringToArray(str, split, 0);
	}

	public static String[] convertStringToArray(String str, String split,
			int limit) {
		List<String> list = convertStringToList(str, split, limit);
		if (list == null) {
			return null;
		}
		return list.toArray(new String[0]);
	}

	public static List<String> convertStringToList(String str) {
		return convertStringToList(str, null, 0);
	}

	public static List<String> convertStringToList(String str, int limit) {
		return convertStringToList(str, null, limit);
	}

	/**
	 * 转换字符串成list
	 * 
	 * @param str
	 *            字符串
	 * @param split
	 *            分隔符
	 * @return
	 */
	public static List<String> convertStringToList(String str, String split) {
		return convertStringToList(str, split, 0);
	}

	/**
	 * 转换字符串成list
	 * 
	 * @param str
	 *            字符串
	 * @param split
	 *            分隔符
	 * @param limit
	 *            长度
	 * @return
	 */
	public static List<String> convertStringToList(String str, String split,
			int limit) {
		if (str == null) {
			return null;
		}
		String[] ret = null;
		if (split == null) {
			split = SEARCH_SEPERATOR;
		}
		ret = str.split(split, limit);

		List<String> list = new ArrayList<String>();
		for (int i = 0; i < ret.length; i++) {
			String s = ret[i];
			if (s == null) {
				continue;
			}
			s = s.trim();
			if (!"".equals(s)) {
				list.add(s);
			}
		}
		return list;
	}

	/**
	 * 转换字符串为int 失败时返回默认值 -1
	 * 
	 * @param str
	 * @return
	 */
	public static int parseInt(String str) {
		return parseInt(str, -1);
	}

	/**
	 * 转换字符串为int 失败时返回默认值 defaultValue
	 * 
	 * @param str
	 * @param defaultValue
	 * @return
	 */
	public static int parseInt(String str, int defaultValue) {
		if (null == str || "".equals(str.trim())) {
			return defaultValue;
		}
		int num = 0;
		try {
			num = Integer.parseInt(str);
		} catch (Exception e) {
			num = defaultValue;
		}
		return num;
	}

	/**
	 * 转换字符串为long类型，如果转换失败，则返回默认值 -1
	 * 
	 * @param str
	 *            字符串
	 * @return
	 */
	public static long parseLong(String str) {
		return parseLong(str, -1);
	}

	/**
	 * 转换字符串为long类型，如果转换失败，则返回默认值 defaultValue
	 * 
	 * @param str
	 *            字符串
	 * @param defaultValue
	 *            默认值
	 * @return
	 */
	public static long parseLong(String str, long defaultValue) {
		if (null == str || "".equals(str.trim())) {
			return defaultValue;
		}
		long num = 0;
		try {
			num = Long.parseLong(str);
		} catch (Exception e) {
			num = defaultValue;
		}
		return num;
	}

	/**
	 * 判断字符串是否为null或者为""
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNullString(String str) {
		if (null == str ||str.length()<=0) {
			return true;
		}
		return false;
	}

	public static String checkString(String str, String defaultValue) {
		if (null == str || "".equals(str.trim())) {
			return defaultValue;
		}
		return str;
	}

	public static String objectToString(Object o) {
		boolean isCheck = false;
		if (null == o) {
			return "";
		}
		if ("".equals(o)) {
			return "";
		}
		return o.toString();
	}

	/**
	 * 过滤字符串内的所有script标签
	 * 
	 * @param htmlStr
	 * @return writer: 2012.2.1
	 */
	public static String strRepScript(String htmlStr) {
		if (null == htmlStr || "".equals(htmlStr)) {
			return "";
		}
		String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>"; // 定义script的正则表达式
		Pattern p_script = Pattern.compile(regEx_script,
				Pattern.CASE_INSENSITIVE);
		Matcher m_script = p_script.matcher(htmlStr);
		htmlStr = m_script.replaceAll(""); // 过滤script标签
		return htmlStr.trim(); // 返回文本字符串
	}

	/**
	 * 过滤字符串内的所有html标签
	 * 
	 * @param htmlStr
	 * @return writer: 2012.2.1
	 */
	public static String strRep(String htmlStr) {
		if (null == htmlStr || "".equals(htmlStr)) {
			return "";
		}
		String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>"; // 定义script的正则表达式
		String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>"; // 定义style的正则表达式
		String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式

		Pattern p_script = Pattern.compile(regEx_script,
				Pattern.CASE_INSENSITIVE);
		Matcher m_script = p_script.matcher(htmlStr);
		htmlStr = m_script.replaceAll(""); // 过滤script标签

		Pattern p_style = Pattern
				.compile(regEx_style, Pattern.CASE_INSENSITIVE);
		Matcher m_style = p_style.matcher(htmlStr);
		htmlStr = m_style.replaceAll(""); // 过滤style标签

		Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
		Matcher m_html = p_html.matcher(htmlStr);
		htmlStr = m_html.replaceAll(""); // 过滤html标签

		return htmlStr.trim(); // 返回文本字符串
	}

	public static String htmlToTextGb2312(String inputString) {
		if (null == inputString || "".equals(inputString)) {
			return "";
		}
		String htmlStr = inputString; // 含html标签的字符串
		String textStr = "";
		Pattern p_script;
		Matcher m_script;
		Pattern p_style;
		Matcher m_style;
		Pattern p_html;
		Matcher m_html;
		Pattern p_houhtml;
		Matcher m_houhtml;
		Pattern p_spe;
		Matcher m_spe;
		Pattern p_blank;
		Matcher m_blank;
		Pattern p_table;
		Matcher m_table;
		Pattern p_enter;
		Matcher m_enter;

		try {
			String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>";
			// 定义script的正则表达式.
			String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>";
			// 定义style的正则表达式.
			String regEx_html = "<[^>]+>";
			// 定义HTML标签的正则表达式
			String regEx_houhtml = "/[^>]+>";
			// 定义HTML标签的正则表达式
			String regEx_spe = "\\&[^;]+;";
			// 定义特殊符号的正则表达式
			String regEx_blank = " +";
			// 定义多个空格的正则表达式
			String regEx_table = "\t+";
			// 定义多个制表符的正则表达式
			String regEx_enter = "\n+";
			// 定义多个回车的正则表达式

			p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
			m_script = p_script.matcher(htmlStr);
			htmlStr = m_script.replaceAll(""); // 过滤script标签

			p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
			m_style = p_style.matcher(htmlStr);
			htmlStr = m_style.replaceAll(""); // 过滤style标签

			p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
			m_html = p_html.matcher(htmlStr);
			htmlStr = m_html.replaceAll(""); // 过滤html标签

			p_houhtml = Pattern
					.compile(regEx_houhtml, Pattern.CASE_INSENSITIVE);
			m_houhtml = p_houhtml.matcher(htmlStr);
			htmlStr = m_houhtml.replaceAll(""); // 过滤html标签

			p_spe = Pattern.compile(regEx_spe, Pattern.CASE_INSENSITIVE);
			m_spe = p_spe.matcher(htmlStr);
			htmlStr = m_spe.replaceAll(""); // 过滤特殊符号

			p_blank = Pattern.compile(regEx_blank, Pattern.CASE_INSENSITIVE);
			m_blank = p_blank.matcher(htmlStr);
			htmlStr = m_blank.replaceAll(" "); // 过滤过多的空格

			p_table = Pattern.compile(regEx_table, Pattern.CASE_INSENSITIVE);
			m_table = p_table.matcher(htmlStr);
			htmlStr = m_table.replaceAll(" "); // 过滤过多的制表符

			p_enter = Pattern.compile(regEx_enter, Pattern.CASE_INSENSITIVE);
			m_enter = p_enter.matcher(htmlStr);
			htmlStr = m_enter.replaceAll(" "); // 过滤过多的制表符

			textStr = htmlStr;

		} catch (Exception e) {
			System.err.println("Html2Text: " + e.getMessage());
		}

		return textStr;// 返回文本字符串
	}

	/**
	 * 取字符串的前toCount个字符
	 * 
	 * @param str
	 *            被处理字符串
	 * @param toCount
	 *            截取长度
	 * @param more
	 *            后缀字符串
	 * @version 2004.11.24
	 * @author zhulx
	 * @return String
	 */
	public static String substring(String str, int toCount, String more) {
		int reInt = 0;
		if (null == str)
			return "";
		StringBuffer stringBuffer = new StringBuffer();
		char[] tempChar = str.toCharArray();
		for (int kk = 0; (kk < tempChar.length && toCount > reInt); kk++) {
			String s1 = str.valueOf(tempChar[kk]);
			byte[] b = s1.getBytes();
			reInt += b.length;
			stringBuffer.append(tempChar[kk]);
		}
		if (toCount == reInt || (toCount == reInt - 1)) {
			stringBuffer.append(more);
		}
		return stringBuffer.toString();
	}

	/**
	 * 按字节截取字符串，并保证不会截取半个汉字
	 * 
	 * @param str
	 * @param byteLength
	 * @return
	 */
	public static String truncate(String str, int byteLength) {
		if (null == str) {
			return null;
		}
		if (0 == str.length()) {
			return str;
		}
		if (byteLength < 0) {
			throw new IllegalArgumentException(
					"Parameter byteLength must be great than 0");
		}
		char[] chs = str.toCharArray();
		int i = 0;
		int len = 0;
		while ((len < byteLength) && (i < chs.length)) {
			len = (chs[i++] > 0xff) ? (len + 2) : (len + 1);
		}
		if (len > byteLength) {
			i--;
		}
		return new String(chs, 0, i);
	}

	/**
	 * 取得字符串s的char长度
	 * 
	 * @param s
	 * @return
	 */
	public static int getWordCount(String s) {
		int length = 0;
		for (int i = 0; i < s.length(); i++) {
			int ascii = Character.codePointAt(s, i);
			if (ascii >= 0 && ascii <= 255)
				length++;
			else
				length += 2;
		}
		return length;
	}
	
	/**
	 * 判断一个字符串是否符合手机号格式
	 * @param phoneNumber
	 * @return
	 */
	public static boolean isMobilePhoneNumber(String phoneNumber){
		Pattern regex = Pattern.compile("^\\d{11}$");
		Matcher m = regex.matcher(phoneNumber);
		return m.matches();
	}
	
	/**
	 * 判断一个字符串是否符合电子邮件地址格式
	 * @param emailAddress
	 * @return
	 */
	public static boolean isEmailAddress(String emailAddress){
		Pattern regex = Pattern.compile(".*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$");
		Matcher m = regex.matcher(emailAddress);
		return m.matches();
	}

	/**
	 * 判断一个字符串是否符合电子邮件地址格式
	 * @param emailAddress
	 * @return
	 */
	public static boolean isTrueString(String emailAddress){
		Pattern regex = Pattern.compile("[`~!@#$%^&*()+=<>?{}':/;',\\[\\]]");
		Matcher m = regex.matcher(emailAddress);
		return !m.matches();
	}
	
	/**
	 * 判断一个字符串是否为非负整数
	 * @param
	 * @return
	 */
	public static boolean isNonNegativeExp(String nonNegativeExp) {
		Pattern regex = Pattern.compile("^\\d+$");
		Matcher m = regex.matcher(nonNegativeExp);
		return m.matches();
	}
	
	/**
	 * 判断一个字符串的长度是否在范围内
	 * @param str 字符串
	 * @param minLength 最小长度
	 * @param maxLength 最大长度
	 * @param isTrim 是否去除两端空格
	 * @return
	 */
	public static boolean lengthBetween(String str, int minLength, int maxLength, boolean isTrim){
		if(str != null && isTrim) str = str.trim();
		int len = StringUtils.length(str);
		return len >= minLength && len <= maxLength;
	}
	
	/**
	 * 判断一个字符串的长度是否在范围内
	 * 注意，此方法不计算字符串两端的空格
	 * @param str 字符串
	 * @param minLength 最小长度
	 * @param maxLength 最大长度
	 * @return
	 */
	public static boolean lengthBetween(String str, int minLength, int maxLength){
		return lengthBetween(str, minLength, maxLength, true);
	}

}
