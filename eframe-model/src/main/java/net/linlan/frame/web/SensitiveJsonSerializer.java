/*
 * eframe-model - model模型数据模块
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
package net.linlan.frame.web;

import java.io.IOException;
import java.util.Objects;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;

import net.linlan.annotation.Sensitive;
import net.linlan.frame.FrameAdminUser;
import net.linlan.utils.enums.DesensitizedType;

/**
 * 数据脱敏序列化过滤
 *
 * @author Linlan
 */
public class SensitiveJsonSerializer extends JsonSerializer<String>
                                     implements ContextualSerializer {
    private DesensitizedType desensitizedType;

    @Override
    public void serialize(String value, JsonGenerator gen,
                          SerializerProvider serializers) throws IOException {
        if (desensitization()) {
            gen.writeString(desensitizedType.desensitizer().apply(value));
        } else {
            gen.writeString(value);
        }
    }

    @Override
    public JsonSerializer<?> createContextual(SerializerProvider prov,
                                              BeanProperty property) throws JsonMappingException {
        Sensitive annotation = property.getAnnotation(Sensitive.class);
        if (Objects.nonNull(annotation)
            && Objects.equals(String.class, property.getType().getRawClass())) {
            this.desensitizedType = annotation.desensitizedType();
            return this;
        }
        return prov.findValueSerializer(property.getType(), property);
    }

    /**
     * 是否需要脱敏处理
     */
    private boolean desensitization() {
        try {
            FrameAdminUser loginUser = SecurityUtils.getLoginUser();
            // 管理员不脱敏
            return !loginUser.getIsSuperAdmin();
        } catch (Exception e) {
            return true;
        }
    }
}
