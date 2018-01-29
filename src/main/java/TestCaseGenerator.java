// 01418476 group 2 sec 1

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class TestCaseGenerator {
    public static void main(String[] args) throws IOException {

        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter minimum of X: ");
        int minX = Integer.parseInt(buffer.readLine());
        System.out.print("Enter maximum of X: ");
        int maxX = Integer.parseInt(buffer.readLine());
        System.out.print("Enter minimum of Y: ");
        int minY = Integer.parseInt(buffer.readLine());
        System.out.print("Enter maximum of Y: ");
        int maxY = Integer.parseInt(buffer.readLine());

        int[] xValues = new int[]{minX, minX+1, Math.round((minX+maxX)/2), maxX-1, maxX};
        int[] yValues = new int[]{minY, minY+1, Math.round((minY+maxY)/2), maxY-1, maxY};

        int midX = xValues[xValues.length/2];
        int midY = yValues[yValues.length/2];

        Map<String, String> testCases = new HashMap<String, String>();

        for (int x : xValues) {
            testCases.put(x + " " + midY, (x+midY)+"");
        }
        for (int y : yValues) {
            testCases.put(midX + " " + y, (midX+y)+"");
        }

        PrintWriter inputsWriter = new PrintWriter("inputs.txt", "UTF-8");
        PrintWriter outputsWriter = new PrintWriter("outputs.txt", "UTF-8");
        for (String input : testCases.keySet()) {
            inputsWriter.println(input);
            outputsWriter.println(testCases.get(input));
        }

        inputsWriter.close();
        outputsWriter.close();

    }
}
