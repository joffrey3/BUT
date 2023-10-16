public enum DNALetter {
    A("A"),
    C("C"),
    G("G"),
    T("T");

    private String value;

    private DNALetter(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
