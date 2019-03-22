package com.huawei;

import model.Car;
import model.Cross;
import model.Road;
import org.apache.log4j.Logger;
import util.CalUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Main {
    private static final Logger logger = Logger.getLogger(Main.class);
    private static List<Road> roadList = new ArrayList<>();
    private static List<Car> carList = new ArrayList<>();
    private static List<Cross> crossList = new ArrayList<>();
    private static List<List<Integer>> resList = new ArrayList<>();
    private static int seed = 3;
    public static void main(String[] args)
    {
        if (args.length != 4) {
            logger.error("please input args: inputFilePath, resultFilePath");
            return;
        }

        logger.info("Start...");

        String carPath = args[0];
        String roadPath = args[1];
        String crossPath = args[2];
        String answerPath = args[3];
        logger.info("carPath = " + carPath + " roadPath = " + roadPath + " crossPath = " + crossPath + " and answerPath = " + answerPath);

        // TODO:read input files
        logger.info("start read input files");

        readText(new File(carPath),0);
        readText(new File(roadPath),1);
        readText(new File(crossPath),2);





        // TODO: calc
        int len = crossList.size() + 1;
        //System.out.println(len);
        Road map[][] =new Road[crossList.size()+1][crossList.size()+1];
        for(Road road : roadList) {
            if(road.getTwoWay() == 1)
                map[road.getStart()][road.getEnd()] = map[road.getEnd()][road.getStart()] = road;
            else
                map[road.getStart()][road.getEnd()] = road;
        }
        int ins = 0;
        for(Car car : carList) {
            CalUtil calUtil = new CalUtil();
            car.setTime(ins/seed + 1);
            List<Integer> minPath = calUtil.getMinPath(map,car,len);
            resList.add(minPath);
            ins++;
        }


        // TODO: write answer.txt

        writeText(new File(answerPath));
        logger.info("Start write output file");

        logger.info("End...");
    }


    public static void writeText(File file) {
        try{
            FileOutputStream fos = new FileOutputStream(file);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            for(List<Integer> list : resList)
            {
                int len = list.size();
                for(int i=0; i<len; i++)
                {
                    if(i == 0)
                        bw.write("(");
                    bw.write(String.valueOf(list.get(i)));
                    //System.out.println(list.get(i));
                    if(i != len-1)
                        bw.write(" ");
                    else
                        bw.write(")");
                }
                bw.newLine();
            }
            bw.close();
        } catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void readText(File file, int op) {
        StringBuffer stringBuffer = new StringBuffer();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s = null;
            while((s = br.readLine()) != null) {
                if(s.charAt(0) != '#')
                {
                    s = s.substring(1,s.length()-1);
                    String[] tmp = s.split(", ");
                    //System.out.println(s);
                    switch (op)
                    {
                        case 0:
                            Car car = new Car(Integer.valueOf(tmp[0]),Integer.valueOf(tmp[1]),
                                    Integer.valueOf(tmp[2]),Integer.valueOf(tmp[3]),Integer.valueOf(tmp[4]));
                            carList.add(car);
                            break;
                        case 1:
                            Road road = new Road(Integer.valueOf(tmp[0]),Integer.valueOf(tmp[1]),
                                    Integer.valueOf(tmp[2]), Integer.valueOf(tmp[3]),
                                    Integer.valueOf(tmp[4]),Integer.valueOf(tmp[5]),
                                    Integer.valueOf(tmp[6]));
                            roadList.add(road);

                            break;
                        case 2:
                            Cross cross = new Cross(Integer.valueOf(tmp[0]),Integer.valueOf(tmp[1]),
                                    Integer.valueOf(tmp[2]), Integer.valueOf(tmp[3]),
                                    Integer.valueOf(tmp[4]));
                            crossList.add(cross);
                            break;

                    }
                }
            }
            br.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}