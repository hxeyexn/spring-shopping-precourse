package shopping.domain;

public record Product(Long id, String name, int price, String imageUrl) {

    public Product {
        if (name == null || name.length() > 15) {
            throw new IllegalArgumentException("상품 이름은 공백을 포함하여 최대 15자까지 입력 가능합니다.");
        }
    }
}
