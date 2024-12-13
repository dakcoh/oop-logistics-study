package logistics.model;

// 배송 상태를 나타내는 열거형
public enum DeliveryStatus {
    PENDING,      // 대기 중
    IN_TRANSIT,   // 배송 중
    DELIVERED,    // 배송 완료
    CANCELED      // 취소됨
}