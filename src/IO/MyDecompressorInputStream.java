package IO;

import java.io.IOException;
import java.io.InputStream;

public class MyDecompressorInputStream extends InputStream {

    public InputStream in;

    public MyDecompressorInputStream(InputStream in){
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
        String s = Integer.toBinaryString(read);

        while (read != -1) {
            if (counter < 24) {

                b[counter] = 0x00;
                counter++;

                b[counter] = 0x00;
                counter++;

                b[counter] = (byte) read;
                counter++;

                read = in.read();

                b[counter] = (byte) read;
                counter++;

            }
            else{
                s = Integer.toBinaryString(read);
                while (s.length() != 8) {
                    if (s.length() * 4 + counter == b.length)
                        break;
                    s = "0" + s;
                }

                if(s.charAt(0) == '1'){
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x01;
                    counter++;
                }
                else{
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                }

                if(s.length() < 2)
                    break;
                if(s.charAt(1) == '1'){
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x01;
                    counter++;
                }
                else{
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                }

                if(s.length() < 3)
                    break;
                if(s.charAt(2) == '1'){
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x01;
                    counter++;
                }
                else{
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                }

                if(s.length() < 4)
                    break;
                if(s.charAt(3) == '1'){
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x01;
                    counter++;
                }
                else{
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                }

                if(s.length() < 5)
                    break;
                if(s.charAt(4) == '1'){
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x01;
                    counter++;
                }
                else{
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                }

                if(s.length() < 6)
                    break;
                if(s.charAt(5) == '1'){
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x01;
                    counter++;
                }
                else{
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                }

                if(s.length() < 7)
                    break;
                if(s.charAt(6) == '1'){
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x01;
                    counter++;
                }
                else{
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                }

                if(s.length() < 8)
                    break;
                if(s.charAt(7) == '1'){
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x01;
                    counter++;
                }
                else{
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                }

            }

            /*else{
                s = Integer.toBinaryString(read);
                while (s.length() != 7) {
                    if (s.length() * 4 + counter == b.length)
                        break;
                    s = "0" + s;
                }


                if(s.charAt(0) == '1'){
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x01;
                    counter++;
                }
                else{
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                }

                if(s.length() < 2)
                    break;
                if(s.charAt(1) == '1'){
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x01;
                    counter++;
                }
                else{
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                }

                if(s.length() < 3)
                    break;
                if(s.charAt(2) == '1'){
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x01;
                    counter++;
                }
                else{
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                }

                if(s.length() < 4)
                    break;
                if(s.charAt(3) == '1'){
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x01;
                    counter++;
                }
                else{
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                }

                if(s.length() < 5)
                    break;
                if(s.charAt(4) == '1'){
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x01;
                    counter++;
                }
                else{
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                }

                if(s.length() < 6)
                    break;
                if(s.charAt(5) == '1'){
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x01;
                    counter++;
                }
                else{
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                }

                if(s.length() < 7)
                    break;
                if(s.charAt(6) == '1'){
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x01;
                    counter++;
                }
                else{
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                    b[counter] = 0x00;
                    counter++;
                }

            }*/

            read = in.read();

        }

        return in.read(b);

        //return 0;
    }
}

