package app;

import java.sql.SQLException;
import java.util.Scanner;

public class service {
    Scanner scanner = new Scanner(System.in);
    DataBase dataBase = new DataBase();
    service() throws SQLException {
        System.out.println("Service is running");
        while (true){
            System.out.println("1. 查询");
            System.out.println("2. 新增");
            System.out.println("3. 更新");
            System.out.println("4. 删除");
            System.out.println("5. 遍历");
            System.out.println("6. 退出");
            System.out.println("Choose an option:");
            switch (scanner.nextInt()){
                case 1:
                    dataBase.query();
                    break;
                case 2:
                    dataBase.insert();
                    break;
                case 3:
                    dataBase.update();
                    break;
                case 4:
                    dataBase.delete();
                    break;
                case 5:
                    dataBase.traverse();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }
}
