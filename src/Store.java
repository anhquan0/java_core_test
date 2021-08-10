    import java.text.Collator;
    import java.util.*;

    class Product {
        private int id;
        private String name;
        private double price;
        private double discount;

        public Product(int id, String name, double price, double discount) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.discount = discount;
        }

        public Product() {
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public double getDiscount() {
            return discount;
        }

        public void setDiscount(double discount) {
            this.discount = discount;
        }

        public double getRealPrice() {
            return price * (100 - discount)/100;
        }

        public void printDetails(){
            System.out.println("Mã sản phẩm: " + getId());
            System.out.println("Tên sản phẩm: " + getName());
            System.out.println("Giá sản phẩm niêm yết: " + getPrice() + " $");
            System.out.println("Chiết khấu: " + getDiscount() + " %");
            System.out.println("Giá cuối cùng: " + getRealPrice() + " $");
        }
    }

    class ProductManager {
        private List<Product> listProducts;

        public ProductManager(List<Product> listProducts) {
            this.listProducts = listProducts;
        }

        public List<Product> getListProducts() {
            return listProducts;
        }

        public void setListProducts(List<Product> listProducts) {
            this.listProducts = listProducts;
        }

        public void sortDescending() {
            listProducts.sort((o1, o2) -> (int) -(o1.getRealPrice() - o2.getRealPrice()));
        }

        public void sortAscending() {
            listProducts.sort((o1, o2) -> (int) (o1.getRealPrice() - o2.getRealPrice()));
        }

        public void show() {
            System.out.println("\nDanh sách sản phẩm: \n");
            for(Product product : listProducts) {
                product.printDetails();
                System.out.println("\n-------------------------------------------");
            }
        }
    }

    public class Store {
        public static void main(String[] args) {
            List<Product> listProducts = new ArrayList<>();
            Scanner sc = new Scanner(System.in);
            System.out.println("Nhập số sản phẩm:");
            int n = sc.nextInt();
            System.out.println("Nhập thông tin sản phẩm: ");
            for(int i = 0; i < n; i++) {
                Product product = new Product();
                System.out.println("Mã sản phẩm " + (i + 1) + ": ");
                product.setId(sc.nextInt());
                sc.nextLine();
                System.out.println("Tên sản phẩm " + (i + 1) + ": ");
                product.setName(sc.nextLine());
                System.out.println("Giá sản phẩm " + (i + 1) + ": ");
                product.setPrice(sc.nextDouble());
                System.out.println("Chiết khấu " + (i + 1) + ": ");
                product.setDiscount(sc.nextDouble());
                listProducts.add(product);
                System.out.println("-------------------------------------------");
            }
            ProductManager productManager = new ProductManager(listProducts);
            productManager.show();
            System.out.println("Danh sách sản phẩm theo thứ tự tăng dần: ");
            productManager.sortAscending();
            productManager.show();
//            System.out.println("Danh sách sản phẩm theo thứ tự giảm dần: ");
//            productManager.sortDescending();
//            productManager.show();
        }
    }
