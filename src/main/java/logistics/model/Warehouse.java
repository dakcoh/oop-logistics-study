package logistics.model;

import java.util.HashMap;
import java.util.Map;

// 창고 정보를 관리하는 클래스
// 창고는 특정 위치와 상품 재고를 관리
public class Warehouse {
    private String location; // 창고 위치
    private Map<Product, Integer> inventory; // 상품 재고 정보

    // 생성자: 창고 위치를 초기화
    public Warehouse(String location) {
        this.location = location;
        this.inventory = new HashMap<>();
    }

    // 창고 위치 반환
    public String getLocation() {
        return location;
    }

    // 상품 재고를 추가
    public void addProduct(Product product, int quantity) {
        inventory.put(product, inventory.getOrDefault(product, 0) + quantity);
    }

    // 특정 상품의 재고가 충분한지 확인
    public boolean hasSufficientStock(Product product, int quantity) {
        return inventory.getOrDefault(product, 0) >= quantity;
    }

    // 재고를 감소시킴
    public void reduceStock(Product product, int quantity) {
        if (hasSufficientStock(product, quantity)) {
            inventory.put(product, inventory.get(product) - quantity);
        } else {
            throw new RuntimeException("재고 부족: " + product.getName());
        }
    }

    // 현재 재고 반환
    public Map<Product, Integer> getInventory() {
        return inventory;
    }

    // 창고 정보를 문자열로 반환
    @Override
    public String toString() {
        return "Warehouse (" + location + ")";
    }
}