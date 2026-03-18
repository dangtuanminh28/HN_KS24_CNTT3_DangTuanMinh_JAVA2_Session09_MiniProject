package MiniProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Product {
    private String id;
    private String name;
    private double price;

    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void displayInfo();

}

class PhysicalProduct extends Product {
    private double weight;
    public PhysicalProduct(String id, String name, double price, double weight) {
        super(id, name, price);
        this.weight = weight;
    }

    @Override
    public void displayInfo() {
        System.out.println("Danh sách sản phẩm vật lý");
        System.out.println("ID: " + getId() + " Tên: " + getName() + " Giá: " + getPrice() + " Trọng lượng: " + weight);
    }
}

class DigitalProduct extends Product {
    private double size;
    public DigitalProduct(String id, String name, double price, double size) {
        super(id, name, price);
        this.size = size;
    }

    @Override
    public void displayInfo() {
        System.out.println("Danh sách sản phẩm kỹ thuật số");
        System.out.println("ID: " + getId() + " Tên: " + getName() + " Giá: " + getPrice() + " Kích cỡ: " + size);
    }
}

class ProductDatabase {
    private List<Product> products = new ArrayList<>();
    private static ProductDatabase instance;

    private ProductDatabase() {}

    public static ProductDatabase getInstance() {
        if (instance == null) {
            instance = new ProductDatabase();
        }
        return instance;
    }

    public void addProduct(Product p) {
        products.add(p);
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public boolean deleteProduct(String id) {
        return products.removeIf(p -> p.getId().equals(id));
    }
}

class ProductFactory {
    public static Product createProduct(int type, String id, String name, double price, double attr) {
        if (type == 1) {
            return new PhysicalProduct(id, name, price, attr);
        } else if (type == 2) {
            return new DigitalProduct(id, name, price, attr);
        } else {
            return null;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        ProductDatabase db = ProductDatabase.getInstance();
        do {
            System.out.println("""
                ---------------------- QUẢN LÝ SẢN PHẨM ----------------------
                1. Thêm mới sản phẩm
                2. Xem danh sách sản phẩm
                3. Cập nhật thông tin sản phẩm
                4. Xoá sản phẩm
                5. Thoát
                -----------------------------------------------------------------------
                Lựa chọn của bạn:
      
                """);
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("""
                    Chọn loại sản phẩm: 
                    1.Vật lý
                    2. Kỹ thuật số 
                    """);
                    int type = sc.nextInt(); sc.nextLine();
                    System.out.print("Nhập ID: ");
                    String id = sc.nextLine();
                    System.out.print("Nhập tên: ");
                    String name = sc.nextLine();
                    System.out.print("Nhập giá: ");
                    double price = sc.nextDouble();
                    double attr = 0;
                    if (type == 1) {
                        System.out.print("Nhập trọng lượng: ");
                        attr = sc.nextDouble();
                    }
                    if (type == 2) {
                        System.out.print("Nhập kích cỡ: ");
                        attr = sc.nextDouble();
                    }

                    Product p = ProductFactory.createProduct(type, id, name, price, attr);
                    if (p != null) {
                        db.addProduct(p);
                        System.out.println("Thêm thành công!");
                    } else System.err.println("Loại không hợp lệ!");
                    break;
                case 2:
                    System.out.println("--- Danh sách sản phẩm ---");
                    db.getAllProducts().forEach(Product::displayInfo);
                    break;
                case 3:
                    break;
                case 4:
                    System.out.print("Nhập ID cần xóa: ");
                    String delId = sc.nextLine();
                    if (db.deleteProduct(delId)){
                        System.out.println("Đã xóa!");
                    } else {
                        System.err.println("Không tìm thấy!");
                    }
                    break;
                case 5:
                    System.out.println("Thoát chương trình");
                    break;
                default:
                    System.err.println("Vui lòng nhập lại");
            }
        } while (true);
    }
}