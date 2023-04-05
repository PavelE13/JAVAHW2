package JAVAHW2;

public class zad1 {

    public static String findJewelsInStones(String jewels_n, String stones_n) {
        StringBuilder res = new StringBuilder(); 
        for (int i = 0; i < jewels_n.length(); i++) {
            char jewel = jewels_n.charAt(i);
            int count = 0;
            for (int j = 0; j < stones_n.length(); j++) { 
                if (stones_n.charAt(j) == jewel) { 
                count++;
                }
            } 
        res.append(jewel).append(count);
        } 
        return res.toString(); 
        }
        
    public static void main(String[] args) {
    /* Посчитайте сколько драгоценных камней в куче обычных камней
    Пример:jewels = “aB”, stones = “aaaAbbbB” Результат в консоль ”a3B1”
    public String findJewelsInStones(String jewels, String stones) {
    return "";
    }
    */

    String stones = "aaaAbbbB";
    String jewels = "aB";
    System.out.println();
    System.out.println(findJewelsInStones (jewels, stones));
    }
}
