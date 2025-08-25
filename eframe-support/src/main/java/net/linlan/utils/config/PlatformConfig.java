/*
 * eframe-support - frame支撑模块
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
package net.linlan.utils.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 读取项目相关配置
 * 
 * @author Linlan
 */
@Component
@ConfigurationProperties(prefix = "platform")
public class PlatformConfig {
    /** 项目名称 */
    private String         name;

    /** 版本 */
    private String         version;

    /** 版权年份 */
    private String         copyrightYear;

    /** 上传路径 */
    private static String  profile;

    /** 获取地址开关 */
    private static boolean addressEnabled;

    /** 验证码类型 */
    private static String  captchaType;

    /** 验证码类型 */
    private static boolean openAppChange;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCopyrightYear() {
        return copyrightYear;
    }

    public void setCopyrightYear(String copyrightYear) {
        this.copyrightYear = copyrightYear;
    }

    public static String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        PlatformConfig.profile = profile;
    }

    public static boolean isAddressEnabled() {
        return addressEnabled;
    }

    public void setAddressEnabled(boolean addressEnabled) {
        PlatformConfig.addressEnabled = addressEnabled;
    }

    public static String getCaptchaType() {
        return captchaType;
    }

    public void setCaptchaType(String captchaType) {
        PlatformConfig.captchaType = captchaType;
    }

    public static boolean isOpenAppChange() {
        return openAppChange;
    }

    public static void setOpenAppChange(boolean openAppChange) {
        PlatformConfig.openAppChange = openAppChange;
    }

    /**
     * 获取导入上传路径
     * @return 返回的路径
     */
    public static String getImportPath() {
        return getProfile() + "/import";
    }

    /**
     * 获取下载路径
     * @return 返回的路径
     */
    public static String getDownloadPath() {
        return getProfile() + "/download/";
    }

    /**
     * 获取上传路径
     * @return 返回的路径
     */
    public static String getUploadPath() {
        return getProfile() + "/upload";
    }

    /**
     * 获取预览路径
     * @return 返回的路径
     */
    public static String getPreviewPath() {
        return getProfile() + "/preview";
    }
}
