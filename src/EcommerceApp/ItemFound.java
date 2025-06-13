package EcommerceApp;

import java.util.ArrayList;

public class ItemFound {
    private ArrayList<String> itemFounds = new ArrayList<>();

    public String[] canAddItems(String[] list) {
        for (int i = 0; i < list.length; i++) {
             String word = list[i];
             itemFounds.add(word);
        }
        return convertToArray(itemFounds);
    }

    private static String[] convertToArray(ArrayList<String> result) {
        String[] results = new String[result.size()];
        for (int index = 0; index < results.length; index++) {
            results[index] = String.valueOf(result.get(index));
        }
        return results;
    }
}
