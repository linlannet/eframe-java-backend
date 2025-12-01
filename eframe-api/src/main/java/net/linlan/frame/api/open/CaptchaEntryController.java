/*
 * eframe-api - api接口网关模块
 * Copyright © 2020-2025 Linlan (open@linlan.net)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.linlan.frame.api.open;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.annotation.Resource;
import javax.imageio.ImageIO;

import org.springframework.util.FastByteArrayOutputStream;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.code.kaptcha.Producer;

import net.linlan.annotation.Encrypt;
import net.linlan.commons.core.RandomUtils;
import net.linlan.commons.core.annotation.PlatLog;
import net.linlan.commons.core.http.ResponseEntity;
import net.linlan.frame.admin.service.InitialConfigService;
import net.linlan.frame.view.admin.vo.CaptchaReturnVo;
import net.linlan.sys.web.RedisService;
import net.linlan.utils.config.PlatformConfig;
import net.linlan.utils.constant.CacheConstants;
import net.linlan.utils.constant.Constants;
import net.linlan.utils.sign.Base64;

/**
 * 验证码读取操作处理
 * 
 * @author Linlan
 */
@RestController
@RequestMapping("api/open")
public class CaptchaEntryController {
    @Resource(name = "captchaProducer")
    private Producer             captchaProducer;

    @Resource(name = "captchaProducerMath")
    private Producer             captchaProducerMath;

    @Resource
    private RedisService         redisService;

    @Resource
    private InitialConfigService initialConfigService;

    /**
     * 获取验证码
     * @return  返回对象
     * @throws IOException 异常
     */
    @PlatLog(value = "获取验证码")
    @GetMapping("captcha/get")
    @Encrypt
    public ResponseEntity<CaptchaReturnVo> getCode() throws IOException {
        CaptchaReturnVo captchaReturnVo = new CaptchaReturnVo();
        boolean captchaEnabled = initialConfigService.selectCaptchaEnabled();
        captchaReturnVo.setCaptchaEnabled(captchaEnabled);
        if (!captchaEnabled) {
            return ResponseEntity.ok(captchaReturnVo);
        }

        // 保存验证码信息
        String uuid = RandomUtils.UUID32();
        String verifyKey = CacheConstants.CAPTCHA_CODE_KEY + uuid;

        String capStr = null, code = null;
        BufferedImage image = null;

        // 生成验证码
        String captchaType = PlatformConfig.getCaptchaType();
        if ("math".equals(captchaType)) {
            String capText = captchaProducerMath.createText();
            capStr = capText.substring(0, capText.lastIndexOf("@"));
            code = capText.substring(capText.lastIndexOf("@") + 1);
            image = captchaProducerMath.createImage(capStr);
        } else if ("char".equals(captchaType)) {
            capStr = code = captchaProducer.createText();
            image = captchaProducer.createImage(capStr);
        }

        redisService.set(verifyKey, code, Constants.CAPTCHA_EXPIRATION * 60);
        // 转换流信息写出
        FastByteArrayOutputStream os = new FastByteArrayOutputStream();
        try {
            ImageIO.write(image, "jpg", os);
        } catch (IOException e) {
            return ResponseEntity.error(e.getMessage());
        }
        captchaReturnVo.setUuid(uuid);
        captchaReturnVo.setImg(Base64.encode(os.toByteArray()));
        return ResponseEntity.ok(captchaReturnVo);
    }

    /**
     * 获取消息验证码
     * @return  返回对象
     */
    @PlatLog(value = "获取消息验证码")
    @GetMapping("message/captcha/get")
    @Encrypt
    public ResponseEntity<CaptchaReturnVo> getMessageCode() {
        CaptchaReturnVo captchaReturnVo = new CaptchaReturnVo();
        boolean captchaEnabled = initialConfigService.selectCaptchaEnabled();
        captchaReturnVo.setCaptchaEnabled(captchaEnabled);
        if (!captchaEnabled) {
            return ResponseEntity.ok(captchaReturnVo);
        }

        // 保存验证码信息
        String uuid = RandomUtils.UUID32();
        String verifyKey = CacheConstants.CAPTCHA_CODE_KEY + uuid;

        String capStr = null, code = null;
        BufferedImage image = null;

        // 生成验证码
        String captchaType = PlatformConfig.getCaptchaType();
        if ("math".equals(captchaType)) {
            String capText = captchaProducerMath.createText();
            capStr = capText.substring(0, capText.lastIndexOf("@"));
            code = capText.substring(capText.lastIndexOf("@") + 1);
            image = captchaProducerMath.createImage(capStr);
        } else if ("char".equals(captchaType)) {
            capStr = code = captchaProducer.createText();
            image = captchaProducer.createImage(capStr);
        }

        redisService.set(verifyKey, code, Constants.CAPTCHA_EXPIRATION * 60);
        // 转换流信息写出
        FastByteArrayOutputStream os = new FastByteArrayOutputStream();

        captchaReturnVo.setUuid(uuid);
        captchaReturnVo.setCode(code);
        return ResponseEntity.ok(captchaReturnVo);
    }

}
