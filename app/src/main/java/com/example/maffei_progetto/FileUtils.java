package com.example.maffei_progetto;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.os.Environment;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class FileUtils
{

    public static final String directory = "/PermissionApp";
    public static final String FileUtilsTAG = "FILE_UTILS";

    //funzione per creazione della directory
    public static boolean createDirectory(String dir,Context context)
    {

        boolean ret = false;
        String path = context.getFilesDir().toString();
        Log.d(FileUtilsTAG, "Creating dir: " + path);
        File directory = new File(path);

        if(!directory.exists())  {
            directory.mkdirs();
            ret = true;
        }
        return ret;
    }

    public static String listDir(Context context)
    {

        String path = context.getFilesDir().toString();
        Log.d(FileUtilsTAG, "Path: " + path);

        File directory = new File(path);
        if(!directory.exists())
            return "directory does not exists..";
        File[] files = directory.listFiles();
        Log.d(FileUtilsTAG, "Size: "+ files.length);
        String s ="";
        for (int i = 0; i < files.length; i++)
        {
            s+= files[i].getName();
            if(i<files.length-1)
                s+=", ";
            Log.d(FileUtilsTAG, "FileName:" + files[i].getName());
        }
        return s;
    }

    //funzione per la lettura del file
    public static String readFile(String filename,Context context)
    {
        String path = context.getFilesDir().toString();
        File file = new File(path, filename);
        try {
            //FileInputStream fis = context.openFileInput(filename);
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null)
            {
                sb.append(line).append("\n");
            }
            return sb.toString();
        } catch (FileNotFoundException e) {
            Log.d(FileUtilsTAG, "READ ERROR: File "+filename+" not found!");
            Log.e(FileUtilsTAG, "READ ERROR: File "+filename+" not found!");
            return null;
        } catch (UnsupportedEncodingException e) {
            Log.d(FileUtilsTAG, "READ ERROR: File "+filename+" encoding error!");
            Log.e(FileUtilsTAG, "READ ERROR: File "+filename+" encoding error!");
            return null;
        } catch (IOException e) {
            Log.d(FileUtilsTAG, "READ ERROR: generic I/O exception for "+filename+"..");
            Log.e(FileUtilsTAG, "READ ERROR: generic I/O exception for "+filename+"..");
            return null;
        }
    }

    //funzione per la lettura del file
    public static void writeFile(String filename, Context context, String content)
    {
        String path = context.getFilesDir().toString();

        File file = new File(path, filename);

        try {
            //si scrive in append
            FileOutputStream f = new FileOutputStream(file,true);
            PrintWriter pw = new PrintWriter(f);
            pw.println(content);
            pw.flush();
            pw.close();
            f.close();
            MediaScannerConnection.scanFile(context, new String[] {path}, null, null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Log.d(FileUtilsTAG, "File "+filename+" not found." +
                    " check WRITE_EXTERNAL_STORAGE permission..");
            Log.e(FileUtilsTAG, "File "+filename+" not found." +
                    " check WRITE_EXTERNAL_STORAGE permission..");
        } catch (IOException e) {
            e.printStackTrace();
            Log.d(FileUtilsTAG, "Generic I/O exception while trying to write file "+filename);
            Log.e(FileUtilsTAG, "Generic I/O exception while trying to write file "+filename);
        }
    }
}