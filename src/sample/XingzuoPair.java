package sample;

import java.io.BufferedReader;
import java.io.FileReader;

public class XingzuoPair {

    private String desc;

    public int[][] pairCheck = new int[][]
            {{87, 60, 72, 41, 91, 58, 78, 64, 96, 51, 82, 69},
                    {69, 88, 71, 78, 46, 93, 61, 65, 74, 99, 54, 82},
                    {88, 79, 90, 75, 82, 47, 94, 65, 85, 70, 99, 58},
                    {66, 81, 68, 88, 72, 75, 45, 97, 57, 78, 61, 93},
                    {99, 48, 79, 76, 89, 71, 81, 57, 93, 69, 86, 64},
                    {74, 97, 52, 82, 78, 89, 61, 84, 66, 92, 70, 87},
                    {84, 62, 97, 56, 79, 69, 87, 72, 81, 45, 92, 77},
                    {55, 84, 61, 91, 76, 88, 66, 89, 49, 81, 72, 95},
                    {95, 64, 85, 74, 98, 58, 88, 77, 90, 71, 80, 47},
                    {57, 92, 60, 80, 68, 97, 65, 84, 73, 87, 47, 76},
                    {78, 44, 92, 70, 81, 65, 98, 58, 86, 68, 89, 75},
                    {74, 77, 43, 97, 70, 80, 59, 92, 51, 85, 64, 88}};

    public int getPairCheck(int girl, int boy) {
        System.out.println(girl);
        System.out.println(boy);
        return pairCheck[girl][boy];
    }

    public String getPairDesc(int girl, int boy) {
        StringBuilder result = new StringBuilder();
        try {
            String path = "src/text/desc/" + boy + ".txt";
            System.out.println(path);
            BufferedReader br = new BufferedReader(new FileReader(path));
            desc = null;
            while ((desc = br.readLine()) != null) {
                result.append(desc);
            }
            desc = result.toString();
//			System.out.println(desc);
            String[] strings = desc.split("#");
            return strings[girl];
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
