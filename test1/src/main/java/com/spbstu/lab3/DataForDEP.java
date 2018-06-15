package com.spbstu.lab3;


public enum DataForDEP {
    CHECKBOX1("Water"), CHECKBOX2("Earth"), CHECKBOX3("Wind"), CHECKBOX4("Fire"),
    RADIO1("Gold"), RADIO2("Silver"), RADIO3("Bronze"), RADIO4("Selen"),
    DROPDOWN1("Red"), DROPDOWN2("Green"), DROPDOWN3("Blue"), DROPDOWN4("Yellow");
    public static Integer CheckboxNum = 4;
    public static Integer RadioNum = 4;
    public static Integer DropdownNum = 4;
    static String Site2 = "https://jdi-framework.github.io/tests/page8.htm";
    public String Str;
    DataForDEP(String s) {
        Str = s;
    }
}
