package com.web.utilities;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import java.util.*;

public class FilloExcelReader {



    public static List<Map<String, String>> getData(String dataFile, String workSheet){
        Fillo fillo=new Fillo();
        List<Map<String,String>> list=null;
        Map<String,String> dataMap;
        Recordset rs;
        Connection connection = null;
        try {
            connection = fillo.getConnection(dataFile);
            String query="Select * from "+workSheet;
            rs=connection.executeQuery(query);
            list=new ArrayList<>();
            while(rs.next()) {
                dataMap=new HashMap<>();
                for(String keyName:rs.getFieldNames()){
                    dataMap.put(keyName,rs.getField(keyName));
                }
                list.add(dataMap);
            }



        } catch (FilloException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        connection.close();

        return list;
    }


    public static List<Map<String, String>> getDataForTestCase(String dataFile, String workSheet, String... testCase){
        Fillo fillo=new Fillo();
        List<Map<String,String>> list=null;
        Map<String,String> dataMap;
        Recordset rs;
        Connection connection = null;
        String query;
        try {
            connection = fillo.getConnection(dataFile);
            if(testCase.length!=0){
                query="Select "+testCase[0]+" from "+workSheet+" where TestCase='"+testCase[0]+"'";;
            }else {
                query="Select * from "+workSheet;
            }
            rs=connection.executeQuery(query);
            list=new ArrayList<>();
            while(rs.next()) {
                dataMap=new HashMap<>();
                for(String keyName:rs.getFieldNames()){
                    dataMap.put(keyName,rs.getField(keyName));
                }
                list.add(dataMap);
            }


        } catch (FilloException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        connection.close();
        return list;
    }


    public static int getColumnCount(String dataFile, String workSheet, String... testCase){
        Fillo fillo=new Fillo();
        List<Map<String,String>> list=null;
        Map<String,String> dataMap;
        Recordset rs = null;
        Connection connection = null;
        String query;
        int col;

        try{
            connection = fillo.getConnection(dataFile);
            if(testCase.length!=0){
                query="Select "+testCase[0]+" from "+workSheet+" where TestCase='"+testCase[0]+"'";;
            }else {
                query="Select * from "+workSheet;
            }
            col=connection.executeQuery(query).getFieldNames().size();
            connection.close();
            return col;
        }catch (Exception e){
            System.out.println(e.getMessage());
            connection.close();
            return 0;
        }


    }

    public static int getRowCount(String dataFile, String workSheet, String... testCase){
        Fillo fillo=new Fillo();
        List<Map<String,String>> list=null;
        Map<String,String> dataMap;
        Recordset rs = null;
        Connection connection = null;
        String query;
        int rows;

        try{
            connection = fillo.getConnection(dataFile);
            if(testCase.length!=0){
                query="Select "+testCase[0]+" from "+workSheet+" where TestCase='"+testCase[0]+"'";;
            }else {
                query="Select * from "+workSheet;
            }
            rows=connection.executeQuery(query).getCount();
            connection.close();
            return rows;
        }catch (Exception e){
            System.out.println(e.getMessage());
            connection.close();
            return 0;
        }


    }




}
