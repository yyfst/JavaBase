package common.utils;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

import java.util.UUID;

@Slf4j
public class TraceUtil {
    public static void putTraceIdToMdc() {
        String traceId = generateTraceId().replace("-", "");
        MDC.put("traceId", traceId);
    }

    public static String generateTraceId() {
        UUID uuid = generateUuid();

        return uuid.toString();
    }

    private static UUID generateUuid() {
        return UUID.randomUUID();
    }
}
