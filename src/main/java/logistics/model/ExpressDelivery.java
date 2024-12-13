package logistics.model;

// 특급 배송 클래스 (Delivery를 상속)
public class ExpressDelivery extends Delivery {
    public ExpressDelivery(String deliveryId, Product product, int quantity, String destination) {
        super(deliveryId, product, quantity, destination);
    }

    // 고정 비용 방식으로 배송 비용 계산
    @Override
    public double calculateCost() {
        return 50.0;
    }
}