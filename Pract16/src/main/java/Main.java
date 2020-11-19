public class Main {

    public static int main(String [] args){
        float f = Float.parseFloat("12,45");
        String pathToCSV = "D:\\Documents\\Denisov\\ProgPractice\\JavaLabs\\Pract16\\src\\main\\resources\\movementList.csv";
        CSVParser parser = new CSVParser(pathToCSV);
        parser.getBankingUnits().forEach(el -> System.out.println(el.toString()));
        return 0;
    }


}
