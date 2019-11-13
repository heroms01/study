package datastructure;

import java.util.ArrayList;
import java.util.List;

class StackArray {
    private List<String> list = new ArrayList<>();

    void push(String value) {
        list.add(value);
    }

    String pop() {
        if (list.size() <= 0)
            return null;

        String value = list.get(list.size()-1);
        list.remove(list.size() - 1);

        return value;
    }
}
