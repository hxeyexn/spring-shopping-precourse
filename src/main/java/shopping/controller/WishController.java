package shopping.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import shopping.domain.Wish;
import shopping.service.WishService;

@RestController
@RequestMapping("/api/wishes")
public class WishController {

    private final WishService wishService;

    public WishController(WishService wishService) {
        this.wishService = wishService;
    }

    @PostMapping
    public ResponseEntity<Wish> addWish(@RequestHeader("Authorization") String token,
                                        @RequestBody WishRequest request) {
        Wish wish = wishService.addWish(token, request.productId());

        return ResponseEntity.ok(wish);
    }

    record WishRequest(Long productId) {
    }
}
