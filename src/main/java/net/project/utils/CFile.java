package net.project.utils;

import java.io.*;

/**
 * @author learnercys on 10/09/15.
 */
public class CFile extends File {

    public CFile(String path) {
        super(path);
    }

    public CFile(File f) {
        this(f.getAbsolutePath());
    }

    public void saveFile( String newText ) {
        try {
            PrintWriter printWriter = new PrintWriter( this.getAbsolutePath() );
            String [] lines = newText.split("\n");
            for(String line: lines) {
                printWriter.println( line );
            }
            printWriter.close();
        } catch (FileNotFoundException ex ) {
            // do nothing. something really rare happened.
        }
    }

    /**
     * Read the current file
     *
     * @return The content to the current file
     */
    public String read() {
        return read(this);
    }

    /**
     * Read the given file
     * @param file
     * @return
     */
    public static String read( File file ) {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String newLine = "", text;

            while ( (text = bufferedReader.readLine()) != null ) {
                stringBuilder.append( newLine );
                stringBuilder.append( text );
                newLine = "\n";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        return stringBuilder.toString();
    }

    public static String getExtension( File file ) throws NullPointerException{
        if( file.getName().lastIndexOf( "." ) < 0 ) {
            return null;
        }
        return file.getName().substring( file.getName().lastIndexOf( "." ) + 1, file.getName().length() );
    }


}
