package com.mufeng.test.base.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @Auther: mufeng
 * @Date: 2018/12/28 17:05
 */
public class TestJson {
    @Test
    public void stringToJson(){
        StringBuilder sb=new StringBuilder();
        String rStr="{\"employees\": [{\"firstName\": \"Bill\",\"lastName\": \"Gates\"},{\"firstName\": \"George\",\"lastName\": \"Bush\"},{\"firstName\": \"Thomas\",\"lastName\": \"Carter\"}]}";
        for(int i=0;i<rStr.length();i++){
            sb.append(rStr.charAt(i));
            boolean flag=rStr.charAt(i)=='{'||rStr.charAt(i)=='['||rStr.charAt(i)=='}'||rStr.charAt(i)==']'||rStr.charAt(i)==',';
            if(flag){
               sb.append("\r\n");
            }
        }
        System.out.println(sb);

    }
    @Test
    public void jsonToString(){
        String str="{\n" +
                "    \"employees\": [\n" +
                "        {\n" +
                "            \"firstName\": \"Bill\",\n" +
                "            \"lastName\": \"Gates\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"firstName\": \"George\",\n" +
                "            \"lastName\": \"Bush\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"firstName\": \"Thomas\",\n" +
                "            \"lastName\": \"Carter\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        System.out.println(str.trim());
    }
    //json字符串-简单对象型
    private static final String  JSON_OBJ_STR = "{\"studentName\":\"lily\",\"studentAge\":12}";
    //json字符串-数组类型
    private static final String  JSON_ARRAY_STR = "[{\"studentName\":\"lily\",\"studentAge\":12},{\"studentName\":\"lucy\",\"studentAge\":15}]";
    //复杂格式json字符串
    private static final String  COMPLEX_JSON_STR = "{\"teacherName\":\"crystall\",\"teacherAge\":27,\"course\":{\"courseName\":\"english\",\"code\":1270},\"students\":[{\"studentName\":\"lily\",\"studentAge\":12},{\"studentName\":\"lucy\",\"studentAge\":15}]}";
    @Test
    public void test1(){

    }
    /**
     * json字符串-简单对象型与JSONObject之间的转换
     */
    @Test
    public void testJSONStrToJSONObject(){
        JSONObject jsonObject = JSON.parseObject(JSON_OBJ_STR);
        System.out.println(jsonObject.getString("studentName")+":"+jsonObject.getInteger("studentAge"));
        System.out.println(jsonObject);
    }

    /**
     * json字符串-数组类型与JSONArray之间的转换
     */
    @Test
    public void testJSONStrToJSONArray(){
        JSONArray array = JSON.parseArray(JSON_ARRAY_STR);
        for(int i=0;i<array.size();i++){
            JSONObject jsonObject = array.getJSONObject(i);
            System.out.println(jsonObject);
        }
    }

    /**
     * 复杂json格式字符串与JSONObject之间的转换
     */
    @Test
    public void testComplexJSONStrToJSONObject(){
        JSONObject jsonObject = JSON.parseObject(COMPLEX_JSON_STR);
        System.out.println(jsonObject);
    }

    /**
     * json字符串-数组类型与JavaBean_List之间的转换
     */
    @Test
    public void testJSONStrToJavaBeanList(){
        ArrayList students = JSON.parseObject(JSON_ARRAY_STR, new TypeReference<ArrayList<Student>>() {});
        System.out.println(students);
    }
}

class Student {

    private String studentName;
    private Integer studentAge;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(Integer studentAge) {
        this.studentAge = studentAge;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentName='" + studentName + '\'' +
                ", studentAge=" + studentAge +
                '}';
    }
}
