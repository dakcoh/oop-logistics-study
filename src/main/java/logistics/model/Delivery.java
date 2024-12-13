package logistics.model;

// 배송의 공통 속성과 행동을 정의하는 추상 클래스
public abstract class Delivery {
    private String deliveryId;  // 배송 ID
    private Product product;    // 배송 상품
    private int quantity;       // 배송 수량
    private String destination; // 배송 목적지
    private DeliveryStatus status; // 배송 상태

    // 생성자: 배송 정보를 초기화
    public Delivery(String deliveryId, Product product, int quantity, String destination) {
        this.deliveryId = deliveryId;
        this.product = product;
        this.quantity = quantity;
        this.destination = destination;
        this.status = DeliveryStatus.PENDING;
    }

    // 배송 ID 반환
    public String getDeliveryId() {
        return deliveryId;
    }

    // 배송 상품 반환
    public Product getProduct() {
        return product;
    }

    // 배송 수량 반환
    public int getQuantity() {
        return quantity;
    }

    // 배송 목적지 반환
    public String getDestination() {
        return destination;
    }

    // 현재 배송 상태 반환
    public DeliveryStatus getStatus() {
        return status;
    }

    // 배송 상태 업데이트
    public void updateStatus(DeliveryStatus status) {
        this.status = status;
    }

    // 배송 비용 계산 (각 하위 클래스에서 구현)
    public abstract double calculateCost();

    // 배송 정보를 문자열로 반환
    @Override
    public String toString() {
        return "Delivery ID: " + deliveryId + ", Product: " + product.getName() +
                ", Quantity: " + quantity + ", Destination: " + destination + ", Status: " + status;
    }
}