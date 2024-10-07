import java.util.Scanner;

public class Main {
    private static final String FILE_PATH = "frutas.txt";
    private static FruitManager fruitManager;

    public static void main(String[] args) {
        fruitManager = new FruitManager(FILE_PATH);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nGestión de Frutas");
            System.out.println("1. Crear Fruta");
            System.out.println("2. Leer Fruta");
            System.out.println("3. Actualizar Fruta");
            System.out.println("4. Borrar Fruta");
            System.out.println("5. Listar Frutas");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: // Crear Fruta
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer
                    System.out.print("Nombre: ");
                    String name = scanner.nextLine();
                    System.out.print("Peso (en kg): ");
                    double weight = scanner.nextDouble();
                    System.out.print("Precio: ");
                    double price = scanner.nextDouble();
                    fruitManager.create(new Fruit(id, name, weight, price));
                    System.out.println("Fruta creada.");
                    break;
                case 2: // Leer Fruta
                    System.out.print("ID: ");
                    id = scanner.nextInt();
                    Fruit fruit = fruitManager.read(id);
                    System.out.println(fruit != null ? fruit : "Fruta no encontrada.");
                    break;
                case 3: // Actualizar Fruta
                    System.out.print("ID: ");
                    id = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer
                    System.out.print("Nuevo Nombre: ");
                    name = scanner.nextLine();
                    System.out.print("Nuevo Peso (en kg): ");
                    weight = scanner.nextDouble();
                    System.out.print("Nuevo Precio: ");
                    price = scanner.nextDouble();
                    fruitManager.update(new Fruit(id, name, weight, price));
                    System.out.println("Fruta actualizada.");
                    break;
                case 4: // Borrar Fruta
                    System.out.print("ID: ");
                    id = scanner.nextInt();
                    fruitManager.delete(id);
                    System.out.println("Fruta borrada.");
                    break;
                case 5: // Listar Frutas
                    System.out.println("Lista de Frutas:");
                    for (Fruit fruitInList : fruitManager.items) {
                        System.out.println(fruitInList);
                    }
                    break;
                case 0: // Salir
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }
}