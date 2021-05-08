package IO;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class MyCompressorOutputStream extends OutputStream {

    public OutputStream out;

    public MyCompressorOutputStream(OutputStream out){
        this.out = out;
    }


    @Override
    public void write(int b) throws IOException {

    }

    @Override
    public void write(byte[] b) throws IOException {

        if (b.length % 4 != 0 || b.length < 24)
            try {
                throw new Exception("Can't create the maze...");

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        ByteBuffer bb = ByteBuffer.allocate(b.length);
        for (int i = 4; i <= 24; i += 4) {
            if (b[i - 2] != 0) {
                bb.put(b[i - 2]);
            } else {
                bb.put((byte) 0x00);

            }
            bb.put(b[i - 1]); // now we have the rows the cols the start pos and goal pos
        }


        for (int i = 27; i < b.length; i +=28 ){
            String s = "";

            for(int j = i; j < i + 28; j += 4){
                if(j > b.length)
                    break;
                s += b[j];
            }

            bb.put(Byte.parseByte(s, 2));
        }

        int pos = bb.position();
        byte[] compress = Arrays.copyOfRange(bb.array(), 0, pos);
        out.write(compress);

    }
/*
    public String write(byte[] b) throws IOException {

        if (b.length % 4 != 0 || b.length < 24)
            try {
                throw new Exception("Can't create the maze...");

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        ByteBuffer bb = ByteBuffer.allocate(b.length);
        for (int i = 4; i <= 24; i += 4) {
            if (b[i - 2] != 0) {
                bb.put(b[i - 2]);
            } else {
                bb.put((byte) 0x00);

            }
            bb.put(b[i - 1]); // now we have the rows the cols the start pos and goal pos
        }


        for (int i = 27; i < b.length; i +=28 ){
            String s = "";

            for(int j = i; j < i + 28; j += 4){
                if(j > b.length)
                    break;
                s += b[j];
            }

            bb.put(Byte.parseByte(s, 2));
        }

        int pos = bb.position();
        byte[] compress = Arrays.copyOfRange(bb.array(), 0, pos);
        out.write(compress);

    }*/
}
