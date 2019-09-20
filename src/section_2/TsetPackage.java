package section_2;

public class TsetPackage {

    public static void main(String[] args) {
        System.out.println(adjustPackageName("com.xcar.index.viewmodel.IndexViewModel"));
        System.out.println(adjustPackageName("com.xcar.index.ui.fragment.IndexFragment"));

    }

    private static String adjustPackageName(String packageName) {
        final String[] packages = packageName.split("\\.");
        StringBuilder header;
        if (packages.length >= 3 && (packageName.contains("ui") || packageName.contains("data") || packageName.contains("viewmodel"))) {
            int index = 0;
            for (int i = 0; i < packages.length; i++) {
                if (packages[i].equals("ui") || packages[i].equals("data") || packages[i].equals("viewmodel")) {
                    index = i;
                    break;
                }
            }
            if (index > 0) {
                header = new StringBuilder();
                for (int i = 0; i < index; i++) {
                    header.append(packages[i]);
                    if (i <= index - 2) {
                        header.append(".");
                    }
                }
            } else {
                header = new StringBuilder(packageName);
            }

        } else if (packages.length >= 3) {
            header = new StringBuilder(packages[0] + "." + packages[1] + "." + packages[2]);
        } else {
            header = new StringBuilder(packageName);
        }
        return header + ".bind";
    }
}
