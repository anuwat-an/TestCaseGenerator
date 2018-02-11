// 01418476 group 2 sec 1

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TestCaseGenerator {
    public static void main(String[] args) throws IOException {

        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter minimum of X: ");
        double minX = Integer.parseInt(buffer.readLine());
        System.out.print("Enter maximum of X: ");
        double maxX = Integer.parseInt(buffer.readLine());
        System.out.print("Enter minimum of Y: ");
        double minY = Integer.parseInt(buffer.readLine());
        System.out.print("Enter maximum of Y: ");
        double maxY = Integer.parseInt(buffer.readLine());
        System.out.println("1: bva");
        System.out.println("2: robustness");
        System.out.println("3: worst case");
        System.out.println("4: worst case robustness");
        System.out.print("Select mode : ");
        int mode = Integer.parseInt(buffer.readLine());
        double midX ;
        double midY ;
        ArrayList<Double> xValues = new ArrayList<Double>();
        ArrayList<Double> yValues = new ArrayList<Double>();
        ArrayList<String> outputTemp = new ArrayList<String>();
        Map<String, String> testCases = new HashMap<String, String>();

    if (mode == 1) { //bva
        xValues.add(minX); xValues.add(minX+1); xValues.add((minX+maxX)/2); xValues.add(maxX-1); xValues.add(maxX);
        yValues.add(minY); yValues.add(minY+1); yValues.add((minY+maxY)/2); yValues.add(maxY-1); yValues.add(maxY);
        int midIndex = Math.round(xValues.size()/2) ;
        midX = xValues.get(midIndex);
        midY = yValues.get(midIndex);
        for (double x : xValues) { testCases.put(x + " " + midY, (x + midY) + ""); }
        for (double y : yValues) { testCases.put(midX + " " + y, (midX + y) + ""); }
    }
    else if (mode == 2) { //robust
        xValues.add(minX-1); xValues.add(minX); xValues.add(minX+1); xValues.add((minX+maxX)/2); xValues.add(maxX-1); xValues.add(maxX); xValues.add(maxX+1);
        yValues.add(minY-1); yValues.add(minY); yValues.add(minY+1); yValues.add((minY+maxY)/2); yValues.add(maxY-1); yValues.add(maxY); yValues.add(maxY+1);
        int midIndex = Math.round(xValues.size()/2) ;
        midX = xValues.get(midIndex);
        midY = yValues.get(midIndex);
        for (double x : xValues) { testCases.put(x + " " + midY, (x + midY) + ""); }
        for (double y : yValues) { testCases.put(midX + " " + y, (midX + y) + ""); }
    }

    else if (mode == 3 ) { // worst case
        xValues.add(minX); xValues.add(minX+1); xValues.add((minX+maxX)/2); xValues.add(maxX-1); xValues.add(maxX);
        yValues.add(minY); yValues.add(minY+1); yValues.add((minY+maxY)/2); yValues.add(maxY-1); yValues.add(maxY);
        for (double x : xValues){
            for (double y : yValues){
                testCases.put(x + " " + y, x+y+"");
            }
        }
    }

    else if (mode == 4) { // worst case robustness
        xValues.add(minX-1); xValues.add(minX); xValues.add(minX+1); xValues.add((minX+maxX)/2); xValues.add(maxX-1); xValues.add(maxX); xValues.add(maxX+1);
        yValues.add(minY-1); yValues.add(minY); yValues.add(minY+1); yValues.add((minY+maxY)/2); yValues.add(maxY-1); yValues.add(maxY); yValues.add(maxY+1);
        for (double x : xValues){
            for (double y : yValues){
                testCases.put(x + " " + y, x+y+"");
            }
        }
    }


        PrintWriter inputsWriter = new PrintWriter("inputs.txt", "UTF-8");
        PrintWriter outputsWriter = new PrintWriter("outputs.txt", "UTF-8");

        for (String key : testCases.keySet()){
            if (!(outputTemp.contains(testCases.get(key)))){
                outputTemp.add(testCases.get(key));

            }

        }
//        outputTemp = outputTemp.sort(list, new Comparator<Message>() {  help me sort dis m8
//            @Override
//            public int compare(Message o1, Message o2) {
//                return o1.getTime() - o2.getTime();
//            }
//        });
        for (String input : testCases.keySet()) {
            inputsWriter.println(input);
            outputsWriter.println(testCases.get(input));
        }

        inputsWriter.close();
        outputsWriter.close();
        System.out.println("Done.Please take a look at 'input.txt' and 'output.txt'.");

    }
}
