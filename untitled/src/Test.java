import java.io.*;
import java.util.ArrayList;

/**
 * Created by chenghao on 15/4/27.
 */
public class Test {
    @org.junit.Test
    public void test() throws IOException {
        File file1 = new File("/Users/chenghao/data1.txt");
        BufferedReader br1 = new BufferedReader(new InputStreamReader(
                new FileInputStream(file1)));
        File file2 = new File("/Users/chenghao/data2.txt");
        BufferedReader br2 = new BufferedReader(new InputStreamReader(
                new FileInputStream(file2)));

        ArrayList<int[]> arrayList1 = getList(br1);
        ArrayList<int[]> arrayList2 = getList(br2);

        if (arrayList1.size() != arrayList2.size()){
            System.out.println("----------------error size");
        }

        for (int i = 0; i < arrayList1.size(); i++){
            int[] pair = arrayList1.get(i);
            if (!inList(pair,arrayList2)){
                System.out.println(pair[0]+" "+pair[1]);
            }
        }

    }

    public ArrayList<int[]> getList(BufferedReader br) throws IOException {
        ArrayList<int[]> arrayList = new ArrayList<>();
        String input = null;
        while ((input = br.readLine()) != null){
            input = input.trim();
            if (input.length() > 0){
                String[] ss = input.split(" ");
                int[] is = new int[2];
                is[0] = Integer.parseInt(ss[0]);
                is[1] = Integer.parseInt(ss[1]);
                arrayList.add(is);
            }
        }
        return arrayList;
    }

    public boolean inList(int[] pair,ArrayList<int[]> arrayList){
        for (int i = 0; i<arrayList.size();i++){
            int[] temp = arrayList.get(i);
            if (pair[0]==temp[0] && pair[1]==temp[1]){
                return true;
            }
        }
        return false;
    }
}
