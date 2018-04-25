/**   
 * 功能描述：
 * @Package: com.test.alipay.util 
 * @author: hudaojin   
 * @date: 2018年4月12日 下午3:42:42 
 */
package com.qytkj.lysk.alipay.util;

import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayConstants;
import com.alipay.api.DefaultAlipayClient;

/** 
* @Description: 初始化AlipayClient、开发者私有、支付宝公钥等
*
* @version: v1.0.0
* @author: hudaojin
* @date: 2018年4月12日 下午3:42:42 
*/
public class AlipayUtil {

	public static final String ALIPAY_APPID = "2018032602449328"; // appid
	
	public static final String SELLER_ID = "2088001072032184";

    public static String APP_PRIVATE_KEY = "MIIEwAIBADANBgkqhkiG9w0BAQEFAASCBKowggSmAgEAAoIBAQC5TXhk7nK3EEqdw6xCH53VEqw8QCAzG6M+FDYeb9sy6Hc9djLFM3R3DbvVqxUGjhFq1AC8KuQxMeKSQZqETjHlvs2zuQFRGYkOblaIvqEGjR9ioqwIudMVst3yel7xMSu7gIDYyHxBkgVyRw+O7hqPfb0/nfbRCt01kFGQm0g8sChKvASb6WuQUCiLI1nkQdmjzYLqNAgBM+aooaUP3KeDMCmQNRcdDLzOlSGLH/yCAoxchbcRp+i2PD+cihM/qsVipby8+MTzqujNCRfP4aG5XJuZh8WudYZB5M4In5hwMPEtG5ALaIPtWJXWbytGEoFU3cZF2LBccEQTYrVl+renAgMBAAECggEBAKlwE0SHXNHTzcbQo3SbIGEy/9bf9BGHlg8vwAS410CHnHDQ4b+8OySZpEXOeB1UTszWKg3lUl9BdCG0ZyvPrISdoc5Svsd/h/lwHyRO20L4S9iPUqtv73oJ4jTUfHgjNA/xgt+3AxeaA+zo2WsigZrvqNrBAG1Jd9iArHSD6NvD0dIfuoZFkH78cfIaBSEfCJbzG1PAG4DIF5TNX3D1RN48d2S/k/rpNokwfBUbvC1vWcTNiGO+iKOea+cIKPDgYANVg3cXcTWgOfJCtTXZeWx2UUE11e6mGD8u3KVdtexwSrGH1hLwoabwbZEyYiiUVWrwtVr9EZi/dIOYhJLY4fECgYEA3dpWZIGxmm1YG5grZjXr8ETasLmS6i1WFlRmbkWFSKKW/Sq5Ipf/RK9osmiZmFZO/Z+c84n8W39qmXZe8nXCYngk64WnmeNRSZuLuul92bINzeHg21wap9mn8xM+IsumtqsxcL+kcW5X5BfPPrlXh4zEXoePjRhH+VC+vGT8nzsCgYEA1dLxo7vKcY3Qh/yu3vLdgzqfDBaOTlyNk6WKDBqS4SF5i6wnqrCnyn3Tpjo8KBowQA6IJQTD+haJIXTiBK74y50mJXKQn0x1aIk9sjvXt1wW+qkAzx2uj4qy7q1Cp0PQWg+NdQWXkr/+30+JmgU2xJLRsf2nXZiVW5H2MIqwGoUCgYEAjtw8abhCf+kNpadVuxnZ9vy/vrGhc38CQprS4wuNinp4tEpAsZAjZz11M/27eqeJcjTIQuOGR/1CzdO1zHgcVoB7dda5WJVTEQ1C63fT/M11qjBcNaWX3KKCTjsD9jAiCNswmSQvZoPhwRW79O4w+S6ifSTaQcdzAY8HZBW7v2UCgYEAim/zsN2BublmfNTVZ1V4o2EN3mawJf34T9KKqUF/PTFOH2cLm5CaYhjLMkFb917VRHPkI4uNUtrKWBXzy7J5NGL/cplVFz4Kee75Oe9Sv81ot0s6Ud5WyWq0ZKFamS7ns5eEL3K6avHRk0VMwqKDjgu8pm+ir499i/bZnR393H0CgYEApRCv+zD3hOzx1dKL0/iQSKiRxsHmwP8uq5yxK++iwhATSsFA+hITmvS7i4AeiHo18vokeUx3n7tpIfAcibR35PF0/X5wPOugvVwmiEgVaDCjc17wU6/ErKsbVoIyuUAa5wqqpWysxjQ4eaymB4kWhu2B4us4Vc/z1hU3GbbxX/A="; // app支付私钥

    public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsIqejP0DXawZrQOQfzuz4KZ3DyoMMlW9/7++YFYBILpROlzpxJfbhRW3cuHF5QMy1NKBHFYg7h6JMmmo3HTHEDa9pg3jWx4kn0zQLX7PK5SvTiFRYK7YGJiZVhW+t9LmyjDa3pCUg0VjnixBM5oC1LoIQDiF7nqIBJMIWUSStN1lvvIdYmtrjdPBa+pBRB++ePU97P91pa8hRiLfM1bP0E8OiZ5K2x0+j+IOuPN/3UFpVst1djHsXykEPfVyhtGef/bPe8Ap7qxlBDPbtr+UMUmYy28cpW1iQFM1emiF82GWPjrR/s5CgwS8Ytten63MLWPSpmuqkByjgDrAH+sFDwIDAQAB"; // 支付宝公钥

    

    // 统一收单交易创建接口
    private static AlipayClient alipayClient = null;

    public static AlipayClient getAlipayClient() {
        if (alipayClient == null) {
            synchronized (AlipayUtil.class) {
                if (null == alipayClient) {
                    alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do", ALIPAY_APPID,
                            APP_PRIVATE_KEY, AlipayConstants.FORMAT_JSON, AlipayConstants.CHARSET_UTF8,
                            ALIPAY_PUBLIC_KEY);
                }
            }
        }
        return alipayClient;
    }
}
