/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author PC
 */

public class Weekdays {
    private static final List<String> listDayOfWeek = Collections.unmodifiableList(
    new ArrayList<String>() {{
        add("Thứ 2");
        add("Thứ 3");
        add("Thứ 4");
        add("Thứ 5");
        add("Thứ 6");
        add("Thứ 7");
        add("Chủ nhật");
        // etc
    }});

    public Weekdays() {
    }
    public List<String> getWeekdays(){
        return listDayOfWeek;
    }
    public int getWeekdaysCount(){
        return listDayOfWeek.size();
    }
    public String getWeekdayByID(int id){
        return listDayOfWeek.get(id);
    }
    public int getIDWeekdaysByName(String name){
        for(int i = 1; i <= listDayOfWeek.size(); i++){
            if(listDayOfWeek.get(i).equals(name)){
                return i;
            }
        }
        return -1;
    }
}
