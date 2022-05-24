import data.InputData;

public class pandemic {
    public static void main(String[] args) throws Exception {
        InputData data = new InputData();
        if (data.parseInput(args) != -1) {
            data.printAll();
        }
        
    }
}
