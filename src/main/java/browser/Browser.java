package browser;

public enum Browser {
    CHROME("chrome"),
    FIREFOX("firefox"),
    SAFARI("safari"),
    EDGE("edge"),
    OPERA("opera");

    private final String name;

    Browser(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
