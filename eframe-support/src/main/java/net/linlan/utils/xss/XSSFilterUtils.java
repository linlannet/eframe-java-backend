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
package net.linlan.utils.xss;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.linlan.commons.core.StringUtils;

/**
 * 根据项目实际使用情况，调整以下XSS的正则表达式考虑
 * @author Linlan
 */
public class XSSFilterUtils {
    private static final Logger  log         = LoggerFactory.getLogger(XSSFilterUtils.class);
    private static List<Pattern> xssPatterns = null;

    static {
        List<Object[]> ret = new ArrayList<Object[]>();
        ret.add(new Object[] { "<(no)?script[^>]*>.*?</(no)?script>", Pattern.CASE_INSENSITIVE });
        ret.add(new Object[] { "</script>", Pattern.CASE_INSENSITIVE });
        ret.add(new Object[] { "<script(.*?)>",
                               Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL });
        ret.add(new Object[] { "eval\\((.*?)\\)",
                               Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL });
        ret.add(new Object[] { "(expression|expres\\\\sion)\\((.*?)\\)",
                               Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL });
        ret.add(new Object[] { "(javascript:|vbscript:|view-source:)*", Pattern.CASE_INSENSITIVE });
        //        ret.add(new Object[]{"<(\"[^\"]*\"|\'[^\']*\'|[^\'\">])*>", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL});
        ret.add(
            new Object[] { "(window)*(\\.|\\[\\'|\\[\\\"){1}(location|open(\\()+)+|(document)+(\\.){1}(cookie)*|alert\\((.*?)\\)",
                           Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL });
        ret.add(
            new Object[] { "\\s*\\w*\\s*(oncontrolselect|oncopy|oncut|ondataavailable|ondatasetchanged|ondatasetcomplete|ondblclick|ondeactivate|ondrag|ondragend|ondragenter|ondragleave|ondragover|ondragstart|ondrop|onerror=|onerroupdate|onfilterchange|onfinish|onfocus|onfocusin|onfocusout|onhelp|onkeydown|onkeypress|onkeyup|onlayoutcomplete|onload|onlosecapture|onmousedown|onmouseenter|onmouseleave|onmousemove|onmousout|onmouseover|onmouseup|onmousewheel|onmove|onmoveend|onmovestart|onabort|onactivate|onafterprint|onafterupdate|onbefore|onbeforeactivate|onbeforecopy|onbeforecut|onbeforedeactivate|onbeforeeditocus|onbeforepaste|onbeforeprint|onbeforeunload|onbeforeupdate|onblur|onbounce|oncellchange|onchange|onclick|oncontextmenu|onpaste|onpropertychange|onreadystatechange|onreset|onresize|onresizend|onresizestart|onrowenter|onrowexit|onrowsdelete|onrowsinserted|onscroll|onselect|onselectionchange|onselectstart|onstart|onstop|onsubmit|onunload)+\\s*=+",
                           Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL });

        xssPatterns = new ArrayList<>();
        String regex = null;
        Integer flag = null;
        int arrLength = 0;
        for (Object[] arr : ret) {
            arrLength = arr.length;
            for (int i = 0; i < arrLength; i++) {
                regex = (String) arr[0];
                flag = (Integer) arr[1];
                xssPatterns.add(Pattern.compile(regex, flag));
            }
        }
    }

    public static String stripXss(String value) {
        if (StringUtils.isNotBlank(value)) {
            for (Pattern pattern : xssPatterns) {
                Matcher matcher = pattern.matcher(value.toLowerCase());
                // 匹配
                if (matcher.find()) {
                    // 删除相关字符串
                    value = matcher.replaceAll("");
                }
            }
        }
        return value;
    }

    public static boolean hasXss(String value) {
        if (StringUtils.isNotBlank(value)) {
            for (Pattern pattern : xssPatterns) {
                Matcher matcher = pattern.matcher(value.toLowerCase());
                // 匹配
                if (matcher.find()) {
                    String filterVal = matcher.replaceAll("");
                    if (!StringUtils.equalsIgnoreCase(value.toLowerCase(), filterVal)) {
                        log.error(
                            "已被过滤，参数中包含不允许xss的关键词(" + pattern.toString() + ")" + ";参数：" + value);
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
