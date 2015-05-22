package project;

import java.io.File;
import java.util.Scanner;

public class RegistrySearch {

    String[] getServer(char op) {
        File reg = new File("Registry.txt");
        String s[] = new String[2];
        try {
            Scanner get = new Scanner(reg);
            while (get.hasNextLine()) {
                String[] line = get.nextLine().split(",");
                if (Character.toString(op).equals(line[0])) {
                    s[0]=line[1];
                    s[1]=line[2];
                    break;
                }
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }
}
