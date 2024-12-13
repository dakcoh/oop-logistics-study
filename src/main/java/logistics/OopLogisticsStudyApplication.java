package logistics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import logistics.model.*;
import logistics.service.DeliveryManager;
import logistics.service.WarehouseManager;

@SpringBootApplication(exclude = {
		org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration.class,
		org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration.class
})
public class OopLogisticsStudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(OopLogisticsStudyApplication.class, args);

		// 창고 및 배송 관리자 생성
		WarehouseManager warehouseManager = new WarehouseManager();
		DeliveryManager deliveryManager = new DeliveryManager();

		// 창고 생성 및 상품 등록
		Warehouse seoulWarehouse = new Warehouse("Seoul");
		Product laptop = new Product("Laptop", 2.5, 0.01);
		Product phone = new Product("Phone", 0.5, 0.002);

		seoulWarehouse.addProduct(laptop, 50);
		seoulWarehouse.addProduct(phone, 100);

		warehouseManager.addWarehouse(seoulWarehouse);

		// 배송 생성 및 처리
		Delivery expressDelivery = new ExpressDelivery("D001", laptop, 10, "Busan");
		Delivery standardDelivery = new StandardDelivery("D002", phone, 5, "Incheon");

		if (warehouseManager.dispatchProduct(laptop, 10)) {
			deliveryManager.createDelivery(expressDelivery);
		}

		if (warehouseManager.dispatchProduct(phone, 5)) {
			deliveryManager.createDelivery(standardDelivery);
		}

		// 배송 상태 업데이트
		deliveryManager.updateDeliveryStatus("D001", DeliveryStatus.IN_TRANSIT);
		deliveryManager.updateDeliveryStatus("D001", DeliveryStatus.DELIVERED);
	}

}
