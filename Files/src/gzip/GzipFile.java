package gzip;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPOutputStream;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

public class GzipFile
{
    public static void main( String[] args )
        throws IOException
    {
        FileInputStream fis = new FileInputStream( "/home/tomasz/dok" );
        File outputFile = new File( "/home/tomasz/file" );
        String contents = "";
        try
        {
            contents = IOUtils.toString( fis );
        }
        finally
        {
            fis.close();
        }
        FileUtils.writeStringToFile( outputFile, contents );
        writeGzippedFile( outputFile );
        writeGzippedEncodedContent( outputFile );
    }

    private static void writeGzippedFile( File file )
        throws IOException
    {
        InputStream input = null;
        try
        {
            input = new FileInputStream( file );
            ByteArrayOutputStream output = new ByteArrayOutputStream();

            GZIPOutputStream gzip = new GZIPOutputStream( output );
            IOUtils.copy( input, gzip );
            gzip.finish();
            File gzippedFile = new File( "/home/tomasz/file.zip" );
            FileUtils.writeByteArrayToFile( gzippedFile, output.toByteArray() );
        }
        catch ( IOException e )
        {
            e.printStackTrace();
            throw new RuntimeException( e );
        }
        finally
        {
            input.close();
        }
    }

    private static void writeGzippedEncodedContent(File file) throws IOException
    { 
        InputStream input = new FileInputStream(file);
        try
        {
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            IOUtils.copy(input, output);
            String baseEncodedString = new Base64().encodeAsString( output.toByteArray() );
            System.out.println("encoded string: " + baseEncodedString);
            
            ByteArrayOutputStream outputForGZip = new ByteArrayOutputStream();
            GZIPOutputStream gzip = new GZIPOutputStream( outputForGZip );
            gzip.write( baseEncodedString.getBytes() );
            gzip.close();
            File gZippedEncodedFile = new File("/home/tomasz/encoded.zip");
            FileUtils.writeByteArrayToFile( gZippedEncodedFile, outputForGZip.toByteArray() );
        }
        finally
        {
            input.close();
        }
    }
}