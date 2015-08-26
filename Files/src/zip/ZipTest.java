package zip;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.IOUtils;

public class ZipTest
{
    // wariant prostszy
    public static void main (String[] args)
    {
        try
        {
            FileInputStream inputStream = new FileInputStream( "/home/tomasz/pgadmin.log" );
            FileOutputStream outputStream = new FileOutputStream( "/home/tomasz/pgadmin.zip" );
            ZipEntry zipEntry = new ZipEntry( "pgadmin.log" );
            ZipOutputStream zipOutputStream = new ZipOutputStream( outputStream );
            zipOutputStream.putNextEntry( zipEntry );
            IOUtils.copy( inputStream, zipOutputStream );
            
            inputStream.close();
            zipOutputStream.closeEntry();
            zipOutputStream.close();
        }
        catch ( IOException e )
        {
            e.printStackTrace();
        }
    }
    // wariant oryginalny
    public void testOld()
    {
        byte[] buffer = new byte[1024];

        try
        {
            FileInputStream in = new FileInputStream( "/home/tomasz/pgadmin.log" );
            FileOutputStream fos = new FileOutputStream( "/home/tomasz/pgadmin.zip" );
            // one zip archive can have mutliple entries
            ZipEntry zipEntry = new ZipEntry( "pgadmin.log" );
            ZipOutputStream zipOutputStream = new ZipOutputStream( fos );
            zipOutputStream.putNextEntry( zipEntry );

            int len;
            while ( ( len = in.read( buffer ) ) > 0 )
            {
                zipOutputStream.write( buffer, 0, len );
            }

            in.close();
            zipOutputStream.closeEntry();

            // remember to close it
            zipOutputStream.close();
            System.out.println( "Done" );

        }
        catch ( IOException ex )
        {
            ex.printStackTrace();
        }
    }
}
