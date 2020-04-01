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

	public static final String ALIPAY_APPID = ""; // appid
	
	public static final String SELLER_ID = "";

    public static String APP_PRIVATE_KEY = ""; // app支付私钥

    public static String ALIPAY_PUBLIC_KEY = ""; // 支付宝公钥

    

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
