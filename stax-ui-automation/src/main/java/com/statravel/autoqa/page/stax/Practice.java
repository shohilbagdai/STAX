package com.statravel.autoqa.page.stax;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

public class Practice {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(100);
        list.add(200);
        list.add(300);
        list.add(400);
        list.add(500);
        int minimum = 100;

        for (Integer element : list) {
            int price = element;
            if (minimum > price) {
                minimum = price;
            }
        }

        System.out.println(minimum);

    }
}
