package com.alipay.config;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *版本：3.3
 *日期：2012-08-10
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
	
 *提示：如何获取安全校验码和合作身份者ID
 *1.用您的签约支付宝账号登录支付宝网站(www.alipay.com)
 *2.点击“商家服务”(https://b.alipay.com/order/myOrder.htm)
 *3.点击“查询合作者身份(PID)”、“查询安全校验码(Key)”

 *安全校验码查看时，输入支付密码后，页面呈灰色的现象，怎么办？
 *解决方法：
 *1、检查浏览器配置，不让浏览器做弹框屏蔽设置
 *2、更换浏览器或电脑，重新登录查询。
 */

public class AlipayConfig {
	
	//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
	// 合作身份者ID，以2088开头由16位纯数字组成的字符串
	public static String partner = "2088001072032184";
	//appid
	public static String app_id = "2018032602449328";
	// 商户的私钥
	public static String private_key = "MIIEwAIBADANBgkqhkiG9w0BAQEFAASCBKowggSmAgEAAoIBAQC5TXhk7nK3EEqdw6xCH53VEqw8QCAzG6M+FDYeb9sy6Hc9djLFM3R3DbvVqxUGjhFq1AC8KuQxMeKSQZqETjHlvs2zuQFRGYkOblaIvqEGjR9ioqwIudMVst3yel7xMSu7gIDYyHxBkgVyRw+O7hqPfb0/nfbRCt01kFGQm0g8sChKvASb6WuQUCiLI1nkQdmjzYLqNAgBM+aooaUP3KeDMCmQNRcdDLzOlSGLH/yCAoxchbcRp+i2PD+cihM/qsVipby8+MTzqujNCRfP4aG5XJuZh8WudYZB5M4In5hwMPEtG5ALaIPtWJXWbytGEoFU3cZF2LBccEQTYrVl+renAgMBAAECggEBAKlwE0SHXNHTzcbQo3SbIGEy/9bf9BGHlg8vwAS410CHnHDQ4b+8OySZpEXOeB1UTszWKg3lUl9BdCG0ZyvPrISdoc5Svsd/h/lwHyRO20L4S9iPUqtv73oJ4jTUfHgjNA/xgt+3AxeaA+zo2WsigZrvqNrBAG1Jd9iArHSD6NvD0dIfuoZFkH78cfIaBSEfCJbzG1PAG4DIF5TNX3D1RN48d2S/k/rpNokwfBUbvC1vWcTNiGO+iKOea+cIKPDgYANVg3cXcTWgOfJCtTXZeWx2UUE11e6mGD8u3KVdtexwSrGH1hLwoabwbZEyYiiUVWrwtVr9EZi/dIOYhJLY4fECgYEA3dpWZIGxmm1YG5grZjXr8ETasLmS6i1WFlRmbkWFSKKW/Sq5Ipf/RK9osmiZmFZO/Z+c84n8W39qmXZe8nXCYngk64WnmeNRSZuLuul92bINzeHg21wap9mn8xM+IsumtqsxcL+kcW5X5BfPPrlXh4zEXoePjRhH+VC+vGT8nzsCgYEA1dLxo7vKcY3Qh/yu3vLdgzqfDBaOTlyNk6WKDBqS4SF5i6wnqrCnyn3Tpjo8KBowQA6IJQTD+haJIXTiBK74y50mJXKQn0x1aIk9sjvXt1wW+qkAzx2uj4qy7q1Cp0PQWg+NdQWXkr/+30+JmgU2xJLRsf2nXZiVW5H2MIqwGoUCgYEAjtw8abhCf+kNpadVuxnZ9vy/vrGhc38CQprS4wuNinp4tEpAsZAjZz11M/27eqeJcjTIQuOGR/1CzdO1zHgcVoB7dda5WJVTEQ1C63fT/M11qjBcNaWX3KKCTjsD9jAiCNswmSQvZoPhwRW79O4w+S6ifSTaQcdzAY8HZBW7v2UCgYEAim/zsN2BublmfNTVZ1V4o2EN3mawJf34T9KKqUF/PTFOH2cLm5CaYhjLMkFb917VRHPkI4uNUtrKWBXzy7J5NGL/cplVFz4Kee75Oe9Sv81ot0s6Ud5WyWq0ZKFamS7ns5eEL3K6avHRk0VMwqKDjgu8pm+ir499i/bZnR393H0CgYEApRCv+zD3hOzx1dKL0/iQSKiRxsHmwP8uq5yxK++iwhATSsFA+hITmvS7i4AeiHo18vokeUx3n7tpIfAcibR35PF0/X5wPOugvVwmiEgVaDCjc17wU6/ErKsbVoIyuUAa5wqqpWysxjQ4eaymB4kWhu2B4us4Vc/z1hU3GbbxX/A=";
	
	// 支付宝的公钥，无需修改该值
	//public static String ali_public_key  = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCnxj/9qwVfgoUh/y2W89L6BkRAFljhNhgPdyPuBV64bfQNN1PjbCzkIM6qRdKBoLPXmKKMiFYnkd6rAoprih3/PrQEB/VsW8OoM8fxn67UDYuyBTqA23MML9q1+ilIZwBC2AQ2UBVOrFXfFl75p6/B5KsiNG9zpgmLCUYuLkxpLQIDAQAB";
	public static String ali_public_key  = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsIqejP0DXawZrQOQfzuz4KZ3DyoMMlW9/7++YFYBILpROlzpxJfbhRW3cuHF5QMy1NKBHFYg7h6JMmmo3HTHEDa9pg3jWx4kn0zQLX7PK5SvTiFRYK7YGJiZVhW+t9LmyjDa3pCUg0VjnixBM5oC1LoIQDiF7nqIBJMIWUSStN1lvvIdYmtrjdPBa+pBRB++ePU97P91pa8hRiLfM1bP0E8OiZ5K2x0+j+IOuPN/3UFpVst1djHsXykEPfVyhtGef/bPe8Ap7qxlBDPbtr+UMUmYy28cpW1iQFM1emiF82GWPjrR/s5CgwS8Ytten63MLWPSpmuqkByjgDrAH+sFDwIDAQAB";
	
	//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
	

	// 调试用，创建TXT日志文件夹路径
	public static String log_path = "D:\\";

	// 字符编码格式 目前支持 gbk 或 utf-8
	public static String input_charset = "utf-8";
	
	// 签名方式 不需修改
	public static String sign_type = "RSA2";

}
