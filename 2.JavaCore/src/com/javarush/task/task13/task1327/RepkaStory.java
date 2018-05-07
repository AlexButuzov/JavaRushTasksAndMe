package com.javarush.task.task13.task1327;

import java.util.List;

public class RepkaStory {
    static void tell(List<Person> items) {
        Person first;
        Person second;
        for (int i = items.size() - 1; i > 0; i--) {
            first = items.get(i);
            second = items.get(i - 1);
            first.pull(second);
        }
    }

    /*public static void tell(List<Person> plot) {
        int sizePlot = plot.size();
        for (int i = 0; i < (sizePlot - 1); i++) {
            System.out.println(plot.get(sizePlot - i).getName()+ " за " + plot.get(sizePlot - i - 1).getNamePadezh());
        }
    }*/
}
