package offer;

public class ReplaceSpace {

    public String replaceSpace(String str) {
        char[] array = new char[str.length() * 3];
        int size = 0;
        for (int i = 0; i < str.length(); i++) {
            char a = str.charAt(i);
            if (a == ' ') {
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            } else {
                array[size++] = a;
            }
        }


        String s = new String(array, 0, size);
        return s;
    }
}
