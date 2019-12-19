package com.ac.common;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * @author anchao
 * @date 2019/12/17 15:24
 */
@Slf4j
public class StringSerializerClass extends JsonSerializer<String> {

    @Override
    public void serialize(String value, JsonGenerator gen, SerializerProvider serializers) {

        try {

            if (StringUtils.isBlank(value)) {
                gen.writeString(StringUtils.EMPTY);
            }

            gen.writeString(String.format("%s[%s]", value, value));

        }catch (Exception e){
            e.printStackTrace();
            log.error("StringSerializerClass.serialize={}", e);
        }

    }


}
