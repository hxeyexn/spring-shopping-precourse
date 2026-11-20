package shopping.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class TokenRepository {

    private final Map<String, Long> tokens = new HashMap<>();

    public void save(String token, Long memberId) {
        tokens.put(token, memberId);
    }
}
