package logistics.model;

// 상품 정보를 관리하는 클래스
public class Product {
    private String name;    // 상품 이름
    private double weight;  // 상품 무게 (kg)
    private double volume;  // 상품 부피 (m³)

    // 생성자: 상품 이름, 무게, 부피를 초기화
    public Product(String name, double weight, double volume) {
        this.name = name;
        this.weight = weight;
        this.volume = volume;
    }

    // 상품 이름 반환
    public String getName() {
        return name;
    }

    // 상품 무게 반환
    public double getWeight() {
        return weight;
    }

    // 상품 부피 반환
    public double getVolume() {
        return volume;
    }

    // 상품 정보를 문자열로 반환
    @Override
    public String toString() {
        return name + " (Weight: " + weight + "kg, Volume: " + volume + "m³)";
    }
}