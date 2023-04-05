package JAVAHW2;

public class zad2 {

    public static String shuffle(final String s, final int[] index) {
        char[] shuffles = new char[s.length()+1]; 
        for (int i = 0; i < s.length(); i++) {
            shuffles[index[i]] = s.charAt(i); 
        } 
        return new String(shuffles); 
    } 
        
    public static void main(String[] args) {

    /*Вам дается строка S и целочисленный массив индексов int index[s.length]. Напишите программу, которая перетасует символы в S таким образом,
    что символ c i-й позиции переместится на индекс index[i] в результирующей строке. Пример: s = “cba”, index = [3,2,1] result “abc”
    public String shuffle(final String s, final int[] index){
    return "";
    }
    */
    
    String s = "cba"; 
    int[] index = {3,2,1}; 
    System.out.println(shuffle(s, index));
    }
}
