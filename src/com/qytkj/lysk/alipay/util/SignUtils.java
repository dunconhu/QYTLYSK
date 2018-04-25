/**   
 * 功能描述：
 * @Package: com.test.alipay.util 
 * @author: hudaojin   
 * @date: 2018年4月12日 下午3:39:21 
 */
package com.qytkj.lysk.alipay.util;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;

import com.alipay.sign.Base64;

/** 
* @Description: 支付宝支付签名实现
*
* @version: v1.0.0
* @author: hudaojin
* @date: 2018年4月12日 下午3:39:21 
*
*/
public class SignUtils {

	private static final String ALGORITHM = "RSA";

    private static final String SIGN_ALGORITHMS = "SHA256WithRSA";

    private static final String DEFAULT_CHARSET = "UTF-8";

    public static String sign(String content, String privateKey) {
        try {
            PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(
                    Base64.decode(privateKey));
            KeyFactory keyf = KeyFactory.getInstance(ALGORITHM);
            PrivateKey priKey = keyf.generatePrivate(priPKCS8);

            java.security.Signature signature = java.security.Signature
                    .getInstance(SIGN_ALGORITHMS);

            signature.initSign(priKey);
            signature.update(content.getBytes(DEFAULT_CHARSET));

            byte[] signed = signature.sign();

            return new String(Base64.encode(signed));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
