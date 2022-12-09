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
        System.out.println(length);
        key = new String[length];
        values = new String[length];
        for (String header : list) {
            if(i==0){
                key[0] = "Status";
                values[0] = header;
            }
            else if(i<length-1){
                key[i] = header.split(":", 2)[0];
                System.out.println(key[i]);
                values[i] = header.split(":", 2)[1];
                i++;
            }
        }
    }

}