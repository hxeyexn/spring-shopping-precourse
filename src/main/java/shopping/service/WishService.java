package shopping.service;

import java.util.List;

import org.springframework.stereotype.Service;

import shopping.domain.Wish;
import shopping.repository.TokenRepository;
import shopping.repository.WishRepository;

@Service
public class WishService {

    private final WishRepository wishRepository;
    private final TokenRepository tokenRepository;

    public WishService(WishRepository wishRepository, TokenRepository tokenRepository) {
        this.wishRepository = wishRepository;
        this.tokenRepository = tokenRepository;
    }

    public Wish addWish(String token, Long productId) {
        Long memberId = tokenRepository.findMemberIdByToken(token);

        if (memberId == null) {
            throw new IllegalArgumentException("유효하지 않은 토큰입니다.");
        }

        Wish wish = new Wish(null, memberId, productId);

        return wishRepository.save(wish);
    }

    public List<Wish> findWishes(String token) {
        Long memberId = tokenRepository.findMemberIdByToken(token);

        if (memberId == null) {
            throw new IllegalArgumentException("유효하지 않은 토큰입니다.");
        }

        return wishRepository.findAllByMemberId(memberId);
    }
}
