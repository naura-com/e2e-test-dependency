package com.github.leeonky.extensions.dal;

import com.github.leeonky.dal.DAL;
import com.github.leeonky.dal.runtime.Data;
import com.github.leeonky.dal.runtime.Extension;
import com.github.leeonky.dal.runtime.SchemaAssertionFailure;
import com.github.leeonky.dal.type.Partial;
import com.github.leeonky.dal.type.Schema;

import java.time.Duration;
import java.time.LocalDateTime;

import static java.time.format.DateTimeFormatter.ofPattern;

public class TimeNow implements Extension {

    @Override
    public void extend(DAL dal) {
        dal.getRuntimeContextBuilder().registerSchema(AlmostNow.class);
    }

    @Partial
    public static class AlmostNow implements Schema {
        @Override
        public void verify(Data data) throws SchemaAssertionFailure {
            String string = data.getInstance().toString();
            LocalDateTime localDateTime;
            if (string.contains("-")) {
                localDateTime = LocalDateTime.parse(string.substring(0, 19), ofPattern("yyyy-MM-dd HH:mm:ss"));
            } else {
                localDateTime = LocalDateTime.parse(string.substring(0, "yyyyMMddHHmmss".length()), ofPattern("yyyyMMddHHmmss"));
            }
            LocalDateTime now = LocalDateTime.now();
            long millis = Duration.between(now, localDateTime).abs().toMillis();
            if (millis > 100 * 1000 * 3600)
                throw new SchemaAssertionFailure(String.format("expecting time is now[%s], but[%s]", now, localDateTime));
        }
    }
}
