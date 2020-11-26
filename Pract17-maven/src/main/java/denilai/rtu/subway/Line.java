package denilai.rtu.subway;

public class Line {

    private String name;
    private String alias;

    public Line(){}

    public Line(String name, String alias){

        this.name = name;
        this.alias = alias;
    }

    public String getName() {
        return name;
    }

    public String getAlias() {
        return alias;
    }
}
