package com.company;

import java.util.regex.Pattern;

/**
* Разбить текст по словам (в тексте могут встречаться разные разделители, напр. пробел, запятая, точка, двоеточие)
* Привести первую букву первого слова текста в заглавную
* Каждое слово после точки должно начинаться с заглавной буквы
* Результат обьеденить обратно в строку (String.join()) и вернуть из метода
*/

public class Main {
    public static void main(String[] args) {
        String imputedText = " one two,three.four:five. ";
        System.out.println(imputedText + " <- Source text");

        String formatedText = formatText(imputedText);
        System.out.println(formatedText + " <- Разбивка по словам");
    }

    private static String formatText(String enteredText) {
        String result = "";
        enteredText = enteredText.trim(); // Удаляет пробелы в начале и в конце строки
        char ch = enteredText.charAt(0);
        // Конкатенация: первая буква - большая + остаток фразы
        enteredText = Character.toString(ch).toUpperCase() + enteredText.substring(1);

        // После точки - слово с большой буквы
        for (int i = 0; i < enteredText.length(); i++) {
            char TekChar = enteredText.charAt(i); // Идём по символьно
            // Если точка и конец фразы выходим из цикла
            if ((TekChar == '.') && (i == enteredText.length() - 1)) break;
            else if (TekChar == '.') { ///???? else можно не писать????
                result += Character.toString(TekChar); // Точка прибавляется к тексту
                TekChar = enteredText.charAt(i + 1); // Переходим к след символу
                TekChar = Character.toUpperCase(TekChar); // следующая буква -> Заглавная
                result += Character.toString(TekChar);
                i++;
            } else {
                result += Character.toString(TekChar);
            }
        }

        // Разбиваем на слова по разделителям
        Pattern pattern = Pattern.compile("[ ,.!?:]");
        //Pattern pattern = Pattern.compile("\\s*(\\s|,|!|\\.)\\s*"); // разделитель -> \\s пробел, \\.точка, зпт, !
        String[] words = pattern.split(result);
        String resultOfMetod = String.join(" ", words);
        //System.out.println(s111);
//        String frazaIzSlov = "";
//        for (String word : words) {
//            //frazaIzSlov += word.toString() + " ";
//            frazaIzSlov += String.join(" 8", word); // Как работает join???

        return resultOfMetod;
    }
    }



/*
Регулярные выражения:
Pattern pattern = Pattern.compile("[ ,.!?:]"); // остаются пустые строки
Pattern pattern = Pattern.compile("\\s*(\\s|,|!|\\.)\\s*"); // разделитель -> пробел, точка, зпт, !
\\s     spase
\\.     точка
знаки разделяются |


/*Classwork
	    String str = "Animals";
        System.out.println(str.length());  //7
        System.out.println("First letter = index[0] to char ->" + str.charAt(0)); //a - массив символа. Индекс = 0 - первая буква
        System.out.println(str.charAt(6)); //s
    //  System.out.println(str.charAt(7)); // exception - выходим за пределы массива символов animals
        System.out.println(str.indexOf("a")); //0 - первая буква = 0 элемент массива
        System.out.println(str.substring(3,5)); //ma. Начиная с 3 элемента =m И заканчивая 5 (не входит)
        System.out.println(str.toLowerCase());
        System.out.println(str.toUpperCase());
        System.out.println("equals: abc = ABC? -> " + "abc".equals("ABC"));
        System.out.println("equalsIgnoreCase: abc = ABC? -> " + "abc".equalsIgnoreCase ("ABC"));
        System.out.println("abc.startsWith(a? -> " + "abc".startsWith("a"));
        System.out.println("abc.endsWith(a? -> " + "abc".endsWith("a"));
        System.out.println("abc contains a? -> " + "abc".contains("a"));
        System.out.println(str.replace ('a','A')); // Найти и заменить
        System.out.println("Del spaces before and after [ a b c ] -> " + " a b c ".trim());

//        String sentence = "hello world";
//        String[] words = sentence.split(" ");
//        System.out.println(Arrays.toString(words));

//        String result = "AniMaL ".trim().toLowerCase().replace("a","A");
//        System.out.println(result);
//
//        String alpha = "";
//        for (char current = 'a'; current <= 'z'; current++) {
//            alpha+= current;
//                    }
//        System.out.println(alpha);


*/
