package вар1;
import java.io.*;

public class вар1 {
    private static String gw="аеёиоуыэюя";
    public static boolean chekchar(char w) {
        char [] gl=gw.toCharArray();
        for(int i = 0; i<gl.length; i++){
            if(gl[i]==w){
                return true;
            }
        }
        return false;
    }
    public static void main(String[]args)throws IOException{
        InputStream in = null;
        Reader file = null;
        BufferedReader buf = null;

        OutputStream out = null;
        Writer wr = null;
        try {
            in = new FileInputStream("C:\\Users\\user\\Documents\\in.txt");
            file = new InputStreamReader(in, "cp1251");
            buf = new BufferedReader(file);

            File f1 = new File("C:\\Users\\user\\Documents\\out.txt");
            f1.createNewFile();
            if (f1.exists()) {
                out = new FileOutputStream(f1);
                wr = new OutputStreamWriter(out, "Unicode");
                String line = "";
                String[] words;
                int num_line = 1;
                while ((line = buf.readLine()) != null) {
                    wr.write(num_line);
                    words = line.split(" ");
                    int count = 0;
                    for (int i = 0; i< words.length; i++) {
                        if(chekchar(words[i].charAt(0))) {
                            wr.append(words[i]+" ");
                            count++;
                        }
                    }
                    wr.append(count + "\n");
                }
            }
        }
        catch (IOException ie){
            System.out.println("Error" + ie);
        }
        finally{
            in.close();
            file.close();
            buf.close();
            wr.flush();
            wr.close();
            out.close();
        }
    }
}
