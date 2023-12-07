package racingcar.util;

public enum UtilSign {

    SPACE(" "),
    NEW_LINE("\n"),
    COLON(" : "),
    COMMA(","),
    MOVE("-");

    private final String title;

    UtilSign(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
