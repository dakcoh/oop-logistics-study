package logistics.service;

import logistics.model.Product;
import logistics.model.Warehouse;

import java.util.ArrayList;
import java.util.List;

// 창고 관리를 담당하는 클래스
public class WarehouseManager {
    private List<Warehouse> warehouses; // 관리 중인 창고 목록

    // 생성자: 창고 목록 초기화
    public WarehouseManager() {
        this.warehouses = new ArrayList<>();
    }

    // 창고 추가
    public void addWarehouse(Warehouse warehouse) {
        warehouses.add(warehouse);
    }

    // 상품 출고 (모든 창고에서 재고 확인 및 감소)
    public boolean dispatchProduct(Product product, int quantity) {
        for (Warehouse warehouse : warehouses) {
            if (warehouse.hasSufficientStock(product, quantity)) {
                warehouse.reduceStock(product, quantity);
                return true;
            }
        }
        return false; // 모든 창고에서 재고 부족
    }
}
