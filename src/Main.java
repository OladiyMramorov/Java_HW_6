import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Laptop> laptops = new ArrayList<>();
        laptops.add(new Laptop("Russia", "BITBLAZE", "Titan BM15", 2350.00, 16, 512, 15.6, "Байкал-М", "Байкал-М GPU"));
        laptops.add(new Laptop("China", "Xiaomi", "RedmiBook Pro 15", 1500.50, 16, 512, 15.6, "Intel i5-12450H", "RTX 2050"));
        laptops.add(new Laptop("USA", "Apple", "MacBook Pro 16", 1999.99, 16, 512, 16, "M1 Pro", "Apple M1 Pro GPU"));
        laptops.add(new Laptop("Belarus", "Horizont", "H-book MAK4", 800.00, 8, 256, 15.6, "Intel Core-i3 1115G4", "Intel Iris Xe Graphics"));
        laptops.add(new Laptop("Taiwan", "Acer", "Porsche Design Book RS", 2500.00, 16, 1024, 14, "Intel Core i7-1165G7", "NVIDIA GeForce MX350"));
        laptops.add(new Laptop("India", "JioBook", "NB2112QB", 184, 2, 32, 11.6, "Qualcomm Snapdragon", "Adreno GPU"));

        for (Laptop laptop : laptops) {
            laptop.printInfo();
            System.out.println();
        }

        filterLaptops(laptops);
    }
    public static void filterLaptops(ArrayList<Laptop> laptops) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите цифру, соответствующую необходимому критерию:\n" +
                "1 - Страна производитель\n" +
                "2 - Бренд\n" +
                "3 - Модель\n" +
                "4 - Цена\n" +
                "5 - RAM\n" +
                "6 - Хранение\n" +
                "7 - Размер экрана\n" +
                "8 - Процессор\n" +
                "9 - Видеокарта");

        int criterion = scanner.nextInt();
        scanner.nextLine();
        String value = scanner.nextLine();

        List<Laptop> filteredLaptops = new ArrayList<>();

        for (Laptop laptop : laptops) {
            switch (criterion) {
                case 1:
                    if (laptop.getMadeIn().equalsIgnoreCase(value)) {
                        filteredLaptops.add(laptop);
                    }
                    break;
                case 2:
                    if (laptop.getBrand().equalsIgnoreCase(value)) {
                        filteredLaptops.add(laptop);
                    }
                    break;
                case 3:
                    if (laptop.getModel().equalsIgnoreCase(value)) {
                        filteredLaptops.add(laptop);
                    }
                    break;
                case 4:
                    if (laptop.getPrice() <= Double.parseDouble(value)) {
                        filteredLaptops.add(laptop);
                    }
                    break;
                case 5:
                    if (laptop.getRam() >= Integer.parseInt(value)) {
                        filteredLaptops.add(laptop);
                    }
                    break;
                case 6:
                    if (laptop.getStorage() >= Integer.parseInt(value)) {
                        filteredLaptops.add(laptop);
                    }
                    break;
                case 7:
                    if (laptop.getScreenSize() >= Double.parseDouble(value)) {
                        filteredLaptops.add(laptop);
                    }
                    break;
                case 8:
                    if (laptop.getProcessor().equalsIgnoreCase(value)) {
                        filteredLaptops.add(laptop);
                    }
                    break;
                case 9:
                    if (laptop.getGraphicsCard().equalsIgnoreCase(value)) {
                        filteredLaptops.add(laptop);
                    }
                    break;

                default:
                    System.out.println("Неправильный критерий фильтрации.");
                    return;
            }
        }

        if (filteredLaptops.isEmpty()) {
            System.out.println("Нет ноутбуков, отвечающих фильтру.");
        } else {
            System.out.println("Ноутбуки, отвечающие фильтру:");
            for (Laptop laptop : filteredLaptops) {
                laptop.printInfo();
            }
        }
        scanner.close();
    }
}