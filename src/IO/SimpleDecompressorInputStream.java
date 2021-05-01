package IO;

import java.io.IOException;
import java.io.InputStream;

public class SimpleDecompressorInputStream  extends InputStream {


    InputStream in;

    public SimpleDecompressorInputStream(InputStream in){
        this.in = in;
    }

    @Override
    public int read() throws IOException {
        return 0;
    }

    @Override
    public int read(byte[] b) throws IOException {
        int counter = 0;
        int read = in.read();

        while (read != -1){
            if (counter < 12){
                b[counter] = 0x00;
                counter++;
                b[counter] = 0x00;


            }
        }




        return super.read(b);
    }
}
