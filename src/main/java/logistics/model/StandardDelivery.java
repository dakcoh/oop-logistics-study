package logistics.model;

// 표준 배송 클래스 (Delivery를 상속)
public class StandardDelivery extends Delivery {
    public StandardDelivery(String deliveryId, Product product, int quantity, String destination) {
        super(deliveryId, product, quantity, destination);
    }

    // 무게와 수량을 기반으로 배송 비용 계산
    @Override
    public double calculateCost() {
        return getProduct().getWeight() * getQuantity() * 2.0;
    }
}