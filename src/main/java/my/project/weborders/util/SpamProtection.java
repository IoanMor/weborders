package my.project.weborders.util;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class SpamProtection {
    private static final Map<String, Bucket> buckets = new ConcurrentHashMap<>();

    private static Bucket getBucket(String ip){
        return buckets.computeIfAbsent(ip, k -> Bucket.builder().addLimit(Bandwidth.simple(5, Duration.ofHours(1))).build());
    }

  public static boolean submitRequest (HttpServletRequest request){
        String ip = request.getRemoteAddr();
        return  getBucket(ip).tryConsume(1);

  }
}
