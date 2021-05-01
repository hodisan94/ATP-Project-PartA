package IO;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class SimpleCompressorOutputStream  extends OutputStream {


    OutputStream out;

    public SimpleCompressorOutputStream (OutputStream out){
        this.out = out;
    }


    @Override
    public void write(int b) throws IOException {

    }

    @Override
    public void write(byte[] b) throws IOException {

        int index = 0 ;
        int oneCounter = 0;
        int zeroCounter = 0;

        byte s = 1;

        byte bbb = (byte) 255;

        byte sd = (byte) 256;
        byte sd1 = (byte) 128;
        byte sd2 = (byte) 129;
        byte sd3 = (byte) 130;
        byte sd4 = (byte) 131;

        if (b.length % 4 != 0 || b.length < 24)
            try {
                throw new Exception("Can't create the maze...");

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        byte tempbyte = 0x00; //just for testing..not using it
        byte[] tempbytes = {(byte) 0x80, (byte) 0x40, (byte) 0x20 , (byte)  0x10, (byte) 0x08 , (byte)  0x04 , (byte) 0x02, (byte) 0x01}; // just for testing ..not using it

        ByteBuffer bb = ByteBuffer.allocate(b.length/4);
        for (int i = 4 ; i<=24 ; i+=4){
            if (b[i-2] != 0 ){
                bb.put(b[i-2]);
            }
            else{
                bb.put((byte) 0x00);

            }
            bb.put(b[i-1]); // now we have the rows the cols the start pos and goal pos
        }

        if (b[27] == (byte) 0x00) // if 0 is the first
        {
            bb.put((byte) 0x00);
            zeroCounter++;

            for (int j = 32 ; j<b.length ; j+=4){
                if (b[j-1] == (byte) 0x00){
                    if (oneCounter > 0 ){
                        if (oneCounter > 255){
                            bb.put((byte) 255);
                            bb.put((byte) 0x00);
                            oneCounter = oneCounter -255;
                            bb.put((byte) oneCounter);
                            oneCounter = 0;
                        }
                        else{
                            bb.put((byte) oneCounter);
                            oneCounter = 0;

                        }
                    }

                    zeroCounter++;
                    //byte temp = b[j];
                }
                if (b[j-1] == (byte) 0x01){
                    if (zeroCounter >0){
                        if (zeroCounter > 255){
                            bb.put((byte) 255);
                            bb.put((byte) 0x00);
                            zeroCounter = zeroCounter - 255;
                            bb.put((byte)zeroCounter);
                            zeroCounter = 0;

                        }
                        else{
                            bb.put((byte) zeroCounter);
                            zeroCounter = 0;

                        }
                    }
                    oneCounter++;
                }
            }
        }

        else { // zero is not the first. so the first is 1.
            bb.put((byte) 0x01);
            oneCounter++;

            for (int j = 32; j < b.length; j += 4) {
                if (b[j-1] == (byte) 0x00) {
                    if (oneCounter > 0) {
                        if (oneCounter > 255) {
                            bb.put((byte) 255);
                            bb.put((byte) 0x00);
                            oneCounter = oneCounter - 255;
                            bb.put((byte) oneCounter);
                            oneCounter = 0;
                        }
                        else {
                            bb.put((byte) oneCounter);
                            oneCounter = 0;

                        }
                    }

                    zeroCounter++;
                    //byte temp = b[j];
                }
                if (b[j-1] == (byte) 0x01) {
                    if (zeroCounter > 0) {
                        if (zeroCounter > 255){
                            bb.put((byte) 255);
                            bb.put((byte) 0x00);
                            zeroCounter = zeroCounter - 255;
                            bb.put((byte)zeroCounter);
                            zeroCounter = 0;

                        }
                        else{
                            bb.put((byte) zeroCounter);
                            zeroCounter = 0;

                        }
                    }
                    oneCounter++;
                }

            }

        }
        int pos = bb.position();
        byte[] compress =  Arrays.copyOfRange(bb.array(),0,pos);
        out.write(compress);




        //super.write(b);
    }
}
