package org.cn.external.weixin.model;

/**
 * 微信通用接口凭证
 */
public class AccessToken {

	private String access_token; // 获取到的凭证

	private int expires_in; // 凭证的有效时间（秒）

	private int errcode = 0; // 错误返回

	private String errmsg; // 错误信息

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public int getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}

	public int getErrcode() {
		return errcode;
	}

	public void setErrcode(int errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	@Override
	public String toString() {
		return "AccessToken [access_token=" + access_token + ", expires_in="
				+ expires_in + ", errcode=" + errcode + ", errmsg=" + errmsg
				+ "]";
	}

}
