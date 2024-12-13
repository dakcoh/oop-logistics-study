package logistics.service;

import logistics.model.Delivery;
import logistics.model.DeliveryStatus;

import java.util.ArrayList;
import java.util.List;

// 배송 관리를 담당하는 클래스
public class DeliveryManager {
    private List<Delivery> deliveries; // 관리 중인 배송 목록

    // 생성자: 배송 목록 초기화
    public DeliveryManager() {
        this.deliveries = new ArrayList<>();
    }

    // 새로운 배송 생성
    public void createDelivery(Delivery delivery) {
        deliveries.add(delivery);
        System.out.println("New delivery created: " + delivery);
    }

    // 배송 상태 업데이트
    public void updateDeliveryStatus(String deliveryId, DeliveryStatus status) {
        for (Delivery delivery : deliveries) {
            if (delivery.getDeliveryId().equals(deliveryId)) {
                delivery.updateStatus(status);
                System.out.println("Updated delivery: " + delivery);
                return;
            }
        }
        System.out.println("Delivery ID not found: " + deliveryId);
    }

    // 모든 배송 목록 반환
    public List<Delivery> getAllDeliveries() {
        return deliveries;
    }
}
