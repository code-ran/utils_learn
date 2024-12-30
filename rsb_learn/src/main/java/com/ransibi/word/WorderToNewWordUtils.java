package com.ransibi.word;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcBorders;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class WorderToNewWordUtils {

    private static Map<String, List<String>> mapPath = new HashMap<String, List<String>>();

    public static void main(String[] args) {

        Map<String, Integer> maps = new HashMap<String, Integer>();
        maps.put("dev1name1", 1);
        maps.put("dev1name3", 3);
        maps.put("dev1name4", 4);
        maps.put("dev1name5", 5);
        maps.put("dev1name6", 6);
        maps.put("dev2name1", 1);
        maps.put("dev2name2", 2);
        maps.put("dev2name3", 3);
        maps.put("dev2name4", 4);
        maps.put("dev2name5", 5);
        maps.put("dev2name6", 6);
//        maps.put("1trip1",1);
        maps.put("1trip2", 1);
        maps.put("1trip3", 2);
        maps.put("1trip4", 3);
        maps.put("1trip5", 5);
        maps.put("1trip6", 6);
        maps.put("2trip1", 1);
        maps.put("2trip2", 2);
        maps.put("2trip3", 3);
        maps.put("2trip4", 4);
        maps.put("2trip5", 5);
        maps.put("2trip6", 6);
        //模板文件地址
        String inputUrl = "rsb_learn/src/main/java/com/ransibi/word/modeljilin3_fault.docx";
        //新生产的模板文件
        String outputUrl = "rsb_learn/src/main/java/com/ransibi/word/out/ceshi.docx";

        Map<String, String> testMap = new HashMap<String, String>();
        testMap.put("dev1name1", "35千伏38号集电线344测控保护装置CSD-211A-G");
        testMap.put("title", "故障事件简报");
        testMap.put("fltTime", "2023-12-13 19:51:59.559");
        testMap.put("fltType", "相间故障");
        testMap.put("fltContent", "35千伏38号集电线344解放主保护动作，AC相间接地故障，三跳不重合。");
        testMap.put("kepft1", "解放:第一次：176ms");
        testMap.put("kepft2", "第二次：-");
        testMap.put("crrent1", "0.02,4.04,4.05");
        testMap.put("stnName1", "解放");
        testMap.put("1trip1", "是");
        testMap.put("ptName1", "1.解放35千伏38号集电线344测控保护装置CSD-211A-G");
        testMap.put("dev1Name", "35千伏38号集电线344");

        WorderToNewWordUtils.changWord(inputUrl, outputUrl, testMap, null, maps, 1);
    }

    /**
     * 根据模板生成新word文档
     * 判断表格是需要替换还是需要插入，判断逻辑有$为替换，表格无$为插入
     *
     * @param inputUrl  模板存放地址
     * @param outputUrl 新文档存放地址
     * @param textMap   需要替换的信息集合
     * @param maps      需要插入的表格信息集合
     * @return 成功返回true, 失败返回false
     */
    public static boolean changWord(String inputUrl, String outputUrl,
                                    Map<String, String> textMap, FltBrieFingEntity flt, Map<String, Integer> maps, int t) {


        //模板转换默认成功
        boolean changeFlag = true;
        try {
            //获取docx解析对象
            XWPFDocument document = new XWPFDocument(POIXMLDocument.openPackage(inputUrl));
            //解析替换文本段落对象
            //  WorderToNewWordUtils.changeText(document, textMap);
            //解析替换表格对象
            WorderToNewWordUtils.changeTable(document, textMap, flt, maps, t);
            File f = new File(outputUrl);
            FileOutputStream stream = new FileOutputStream(f);
            document.write(stream);
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
            changeFlag = false;
        }

        return changeFlag;

    }

    /**
     * 替换表格对象方法
     *
     * @param document docx解析对象
     * @param textMap  需要替换的信息集合
     * @param maps     需要插入的表格信息集合
     */
    public static void changeTable(XWPFDocument document, Map<String, String> textMap, FltBrieFingEntity flt, Map<String, Integer> maps, int t) {
        //获取表格对象集合
        List<XWPFTable> tables = document.getTables();
        System.out.println("tables.size()===" + tables.size());


        XWPFTable tab = tables.get(0);
        for (int i = t; i < 6; i++) {
//            int delrow = 11 + t;
            int delrow = 9 + t;
            System.out.println("===delrow==="+delrow);
            tab.removeRow(delrow);
        }
//
        for (int i = 0; i < tables.size(); i++) {
            //只处理行数大于等于2的表格，且不循环表头
            XWPFTable table = tables.get(i);

            if (table.getRows().size() > 1) {
                //判断表格是需要替换还是需要插入，判断逻辑有$为替换，表格无$为插入
                if (checkText(table.getText())) {
                    List<XWPFTableRow> rows = table.getRows();
                    //遍历表格,并替换模板
                    eachTable(document, rows, textMap, flt, maps);
                } else {
                }
            }
        }
    }

    /**
     * 遍历表格
     *
     * @param rows    表格行对象
     * @param textMap 需要替换的信息集合
     */
    public static void eachTable(XWPFDocument document, List<XWPFTableRow> rows, Map<String, String> textMap, FltBrieFingEntity flt, Map<String, Integer> maps) {
        int z = 0;
        for (XWPFTableRow row : rows) {
            List<XWPFTableCell> cells = row.getTableCells();
            for (XWPFTableCell cell : cells) {
                //判断单元格是否需要替换
                if (checkText(cell.getText())) {
                    List<XWPFParagraph> paragraphs = cell.getParagraphs();
                    for (XWPFParagraph paragraph : paragraphs) {
                        List<XWPFRun> runs = paragraph.getRuns();
                        for (XWPFRun run : runs) {
                            System.out.println("run.toString()==" + run.toString());
                            String str = run.toString();
                            str = str.replace("${", "");
                            str = str.replace("}", "");
                            if (maps.containsKey(str)) {
                                CTTcBorders tblBorders = cell.getCTTc().getTcPr().addNewTcBorders();
                                if (str.indexOf("dev1") > -1) {
                                    tblBorders.addNewRight().setVal(STBorder.NIL);
                                } else if (str.indexOf("2trip") > -1) {
                                    tblBorders.addNewLeft().setVal(STBorder.NIL);
                                } else {
                                    tblBorders.addNewRight().setVal(STBorder.NIL);
                                    tblBorders.addNewLeft().setVal(STBorder.NIL);
                                }
                                //if(str.indexOf("6")<0){
                                tblBorders.addNewBottom().setVal(STBorder.NIL);
                                //}
                                cell.getCTTc().getTcPr().setTcBorders(tblBorders);

                            }
                            //某一台装置的 录波文件集合
                            if (mapPath.containsKey(str)) {
//                            	  List<String> lstImgFile=new ArrayList<String>();
//                            	  lstImgFile.add("D:/stdown/FltScreenShot/昌盛/保护/5011断路器1号微机保护PCS-921A-DG-G(昌盛BH10020)/2018-10-18-02_52_14-274-00082-00079/001.png");
//                            	  lstImgFile.add("D:/stdown/FltScreenShot/昌盛/保护/5011断路器1号微机保护PCS-921A-DG-G(昌盛BH10020)/2018-10-18-02_52_14-274-00082-00079/002.png");
                                List<String> lstImgFile = mapPath.get(str);
                                FileInputStream is = null;
                                for (String imgfile : lstImgFile) {
                                    addimg(run, imgfile, is);
                                }
                                run.setText(changeValue("", textMap), 0);
                            } else {
                                if (str.indexOf("ptName") > -1 || str.indexOf("pic") > -1) {

                                }
                                run.setText(changeValue(run.toString(), textMap), 0);
                            }
                        }
                    }


                }


            }

        }
    }


    public static void addimg(XWPFRun run, String imgfile, FileInputStream is) {
        //String imgFile = "D:/stdown/FltScreenShot/昌盛/保护/5011断路器1号微机保护PCS-921A-DG-G(昌盛BH10020)/2018-10-18-02_52_14-274-00082-00079/001.png";
        int formats = XWPFDocument.PICTURE_TYPE_PNG;

        try {
            is = new FileInputStream(imgfile);
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
            if (is != null) {

                run.addPicture(is, formats, imgfile, Units.toEMU(430), Units.toEMU(300));
            } else {

            }
        } catch (InvalidFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


    /**
     * 判断文本中时候包含$
     *
     * @param text 文本
     * @return 包含返回true, 不包含返回false
     */
    public static boolean checkText(String text) {
        boolean check = false;
        if (text.indexOf("$") != -1) {
            check = true;
        }
        return check;

    }

    /**
     * 匹配传入信息集合与模板
     *
     * @param value   模板需要替换的区域
     * @param textMap 传入信息集合
     * @return 模板需要替换区域信息集合对应值
     */
    public static String changeValue(String value, Map<String, String> textMap) {
        Set<Entry<String, String>> textSets = textMap.entrySet();
        for (Entry<String, String> textSet : textSets) {


            //匹配模板与替换值 格式${key}
            String key = "${" + textSet.getKey() + "}";

            if (value.indexOf(key) != -1) {
                value = textSet.getValue();
            }
        }
        //模板未匹配到区域替换为空
        if (checkText(value)) {
            value = "";
        }
        return value;
    }


    public void setMapPath(Map<String, List<String>> mapPaths) {
        mapPath = mapPaths;
    }


}

