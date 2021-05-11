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

    /**
     * The function read from the outputStream and decompress the data to byte array
     * Evey cell represent a sequence of digits.
     * @param b byte array to write into after the decompress
     * @return
     * @throws IOException
     */
    @Override
    public int read(byte[] b) throws IOException {
        int counter = 0;
        int read = in.read();
        boolean isZero = false;

        while (read != -1){
            if (counter < 24){

                b[counter] = 0x00;
                counter++;

                b[counter] = 0x00;
                counter++;

                b[counter] = (byte)read;
                counter++;

                read = in.read();

                b[counter] = (byte)read;
                counter++;
            }
            else if (counter == 24){
                if(read == 0){
                    isZero = true;
                }

                counter++;
            }
            else{
                for(int i = 0; i < read; i++){
                    if(isZero == true) {
                        b[counter - 1] = 0x00;
                        counter++;

                        b[counter - 1] = 0x00;
                        counter++;

                        b[counter - 1] = 0x00;
                        counter++;

                        b[counter - 1] = 0x00;
                        counter++;
                    }
                    else {
                        b[counter - 1] = 0x00;
                        counter++;

                        b[counter - 1] = 0x00;
                        counter++;

                        b[counter - 1] = 0x00;
                        counter++;

                        b[counter - 1] = 0x01;
                        counter++;
                    }
                }
                isZero = !isZero;
            }

            read = in.read();
        }

        return in.read(b);
    }
}
