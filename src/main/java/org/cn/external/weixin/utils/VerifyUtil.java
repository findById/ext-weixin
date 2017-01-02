package org.cn.external.weixin.utils;

import org.cn.core.crypto.SignUtil;
import org.cn.external.weixin.WeixinConfig;

import java.util.Arrays;

public class VerifyUtil {

	public static String accessVerify(String signature, String timestamp, String nonce, String echostr) throws Exception {
		return "";
	}

	public static boolean signatureVerify(String signature, String timestamp, String nonce) {
		try {
			String[] array = new String[] { WeixinConfig.LOCAL_TOKEN, timestamp, nonce };
			StringBuffer sb = new StringBuffer();
			Arrays.sort(array);
			for (int i = 0; i < array.length; i++) {
				sb.append(array[i]);
			}
			String tmp = SignUtil.encode(sb.toString(), "SHA-1");
			return signature.equalsIgnoreCase(tmp);
		} catch (Exception e) {
		}
		return false;
	}

	public static String signature(String signature, String timestamp, String content) throws Exception {
		String[] array = new String[] { WeixinConfig.LOCAL_TOKEN, timestamp, content };
		StringBuffer sb = new StringBuffer();
		Arrays.sort(array);
		for (int i = 0; i < array.length; i++) {
			sb.append(array[i]);
		}
		String tmp = SignUtil.encode(sb.toString(), "SHA-1");
		if (!signature.equalsIgnoreCase(tmp)) {
			throw new Exception("verify error");
		}
		return tmp;
	}

}
