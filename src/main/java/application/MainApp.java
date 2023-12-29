package application;

import java.util.List;
import java.util.Scanner;

public class MainApp {

    private static Scanner sc = new Scanner(System.in);
    private static Service service = new Service();

    public static void main(String[] args) {
        System.out.println("SELECT OPERATION");
        System.out.println("1. INSERT PRODUCT");
        System.out.println("2. REMOVE PRODUCT");
        System.out.println("3. UPDATE PRODUCT");
        System.out.println("4. DISPLAY PRODUCT");
        System.out.println("5. EXIT");

        int ch=sc.nextInt();

        switch (ch) {


            case 1:
                insertProduct();
                break;

            case 2:
            removeProduct();
                break;

            case 3:
                updateProduct();
                break;

            case 4:
                displayAllProduct();
                break;

            case 5:
                System.out.println(0);
                break;

            default:
                System.out.println("INVALID INPUT");
        }

        main(args);

    }
    public static void insertProduct()
    {
        System.out.println("ENTER ID ");
        int productId= sc.nextInt();
        System.out.println("ENTER PRODUCT NAME");
        String productName=sc.next();
        System.out.println("ENTER PRODUCT PRICE");
        double productPrice=sc.nextDouble();
        System.out.println("ENTER PRODUCT TYPE");
        String productType=sc.next();

        Product newProduct=new Product(productId, productName,productPrice, productType);

        int n =Service.insertProduct(newProduct);
        System.out.println(n+"RECORD ADDED");

    }
    public static void updateProduct()
    {
        System.out.println("ENTER ID ");
        int productId= sc.nextInt();
        System.out.println("ENTER UPDATE PRODUCT NAME");
        String productName =sc.next();
        System.out.println("ENTER UPDATE PRODUCT PRICE");
        double productPrice= sc.nextDouble();
        System.out.println("ENTER UPDATE PRODUCT TYPE");
        String productType = sc.next();

        Product uptProduct = new Product(productId , productName , productPrice , productType);
        int n = service.updateProduct(uptProduct);
        System.out.println(n + "PRODUCT UPDATED !!");
    }

    public static void removeProduct()
    {
        System.out.println("ENTER PRODUCT ID ");
        int productId = sc.nextInt();

        int n= service.deleteProduct(productId);
        System.out.println(n + "PRODUCT DELETED  !!");
    }
    public static void displayAllProduct()
    {
        List<Product> productList= service.displayAllProduct();
        System.out.println("Id \t\t Name \t\t Price \t\t Type");
        for (Product p : productList)
        {
            System.out.println(p.getProductId() + " \t"+p.getProductName() + " \t" +p.getProductPrice() +" \t "+p.getProductType());

        }

    }
    public static void searchProductById()
    {
        System.out.println("ENTER PRODUCT ID ");
        int productId = sc.nextInt();

        Product p =service.searchProductById(productId);
        System.out.println("Id \t\t Name \t\t Price \t\t Type");
        System.out.println(p.getProductId() + " \t" + p.getProductName() + " \t" + p.getProductPrice() + " \t" + p.getProductType());
    }



}
