package treatment;

public class Header {
    String[] key;
    String[] values;
    int length;

    public int getLength() {
        return this.length;
    }

    public String[] getKey() {
        return this.key;
    }

    public String[] getValues() {
        return this.values;
    }

    public Header(String[] list) {
        int i = 0;
        length = list.length;
        key = new String[length];
        values = new String[length];
        for (String header : list) {
            key[i] = header.split(":", 2)[0];
            values[i] = header.split(":", 2)[1];
        }
    }

}