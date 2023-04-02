package JAVAHW2;

import java.util.Scanner;
import java.util.StringJoiner;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.lang.String;

public class zad3 {

    public static void main(String[] args) {
    /* На первой строке записывается натуральное число n - количество строчек в книге. Затем вводится n строк - строки книги. потом вводится натуральное 
    число m - количество продуктов, на которые у человека аллергия. Потом вводится m строк - вида "продукт1 - продукт2", где продукт1 - продукт, 
    на который у человека аллергия и продукт2 - продукт, на который следует заменить продукт1. Гарантируется что любой продукт состоит из 1 слова. 
    название продуктов написаны строчными буквами. Гарантируется, что продукты, на которые нужно выполнить замену, не встречаются изначально в тексте.
    Выходные данные: Замените все продукты в поваренной книге Васи и выведите их построчно на экран. На окончания не обращайте внимание. 
    ВАЖНО!!! Если продукт, который следует заменить написан с большой буквы, то и замена тоже должна начинаться с большой буквы!
    Sample Input: 2
    Рецепт 1. Арахис 100гр, мороженое 200гр. Возьмите арахис и измелчите его. Посыпьте измельчённый арахис на мороженое.
    Рецепт 2. Клубника 100гр, сгущенка 3кг. Смешать, есть) Радоваться жизни.
    3
    арахис - колбаса
    клубника - вишня
    сгущенка - молоко
    Sample Output:
    Рецепт 1. Колбаса 100гр, мороженно 200гр. Возьмите колбаса и измельчите его. Посыпьте измельченный колбаса на мороженое.
    Рецепт 2. Вишня 100гр, молоко 3 кг. Смешать его.
    */
    Scanner scanner = new Scanner(System.in,  "cp866");
    StringJoiner joiner = new StringJoiner(" ");

    System.out.printf("Введите число cтрок в книге: ");
    int n = Integer.parseInt(scanner.nextLine());
    // System.out.printf("Введите строки книги: ");
    //String [] recipe_book = new String[n];
    //for (int i = 0; i <n; i++){
    //   recipe_book[i] = scanner.nextLine();
    //}
    String recipe_book0 = "Рецепт1. Колбаса 100гр, мороженое 200гр. Возьмите колбаса и измельчите его. Посыпьте измельченный колбаса на мороженое.".toLowerCase();
    String recipe_book1 = "Рецепт 2. Вишня 100гр, молоко 3 кг. Смешать его.";
    String [] recipe_books0 = recipe_book0.split(" ");
    String [] recipe_books1 = recipe_book1.split(" ");
    
    System.out.printf("Введите количество продуктов, на которые у человека аллергия: ");
    int m = Integer.parseInt(scanner.nextLine());
    int count = 0;
    String res = "";
    System.out.printf("Введите продукт1 - продукт2, где продукт1 - алергический, продукт2 - замена, через дефис: \n");

    while (count != m) {
        String temp = scanner.nextLine();
        res += temp + " - ";
        count++;
    }
    scanner.close();

    var change = res.split(" - ");

    for (int i = 0; i < recipe_books0.length; i++) {
        for (int j = 1; j < change.length; j += 2) {
            if ((recipe_books0[i]).equals(change[j])){
                recipe_books0[i] = change[j-1];
            }
        } 
    }

    for (int i = 0; i < recipe_books1.length; i++) {
        for (int j = 3; j < change.length; j += 2) {
            if ((recipe_books1[i]).equals(change[j])){
                recipe_books1[i] = change[j-1];
            }
        } 
    }

    String changed_line0 = String.join(" ", recipe_books0);
    changed_line0 = Character.toUpperCase(changed_line0.charAt(0)) + changed_line0.substring(1);
    String changed_line1 = String.join(" ", recipe_books1);
    changed_line1 = Character.toUpperCase(changed_line1.charAt(0)) + changed_line1.substring(1);

    int dotIndex = changed_line0.indexOf(".");
    
    while (dotIndex != -1) {
        if (dotIndex + 1 < changed_line0.length()) {
            char nextChar = changed_line0.charAt(dotIndex + 2);
            if (Character.isLowerCase(nextChar)) {
                changed_line0 = changed_line0.substring(0, dotIndex + 2) + Character.toUpperCase(nextChar) + changed_line0.substring(dotIndex + 3);
            }
        }
    dotIndex = changed_line0.indexOf(".", dotIndex + 1);
    }
//Line 2
    int dotIndex2 = changed_line1.indexOf(".");

    while (dotIndex2 != -1) {
        if (dotIndex2 + 1 < changed_line1.length()) {
            char nextChar2 = changed_line1.charAt(dotIndex2 + 2);
            if (Character.isLowerCase(nextChar2)) {
                changed_line1 = changed_line1.substring(0, dotIndex2 + 2) + Character.toUpperCase(nextChar2) + changed_line1.substring(dotIndex2 + 3);
            }
        }
    dotIndex2 = changed_line1.indexOf(".", dotIndex2 + 1);
    }

    System.out.println(changed_line0);
    System.out.println(changed_line1);

//    int dotIndex = changed_line0.indexOf(" ");
//    System.out.println(dotIndex);
//     if (dotIndex != -1 && dotIndex < changed_line0.length() - 1) {
//          System.out.println("YES");
//          changed_line0 = changed_line0.substring(0, dotIndex + 1) + Character.toUpperCase(changed_line0.charAt(dotIndex + 1)) + changed_line0.substring(dotIndex + 2);
//          System.out.println(changed_line0);
//     }

    } 
}





