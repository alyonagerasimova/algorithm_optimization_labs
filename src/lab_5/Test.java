package lab_5;

import java.util.*;

//10. Имеется 1000 бутылок лимонада, ровно одна из которых отравлена. Также у вас есть 10 тестовых полосок для обнаружения
//        яда. Даже одна капля яда окрашивает полоску и делает ее непригодной для дальнейшего использования. На тестовую полоску
//        можно одновременно нанести любое количество капель, и одна полоска может использоваться сколько угодно раз (при условии,
//        что все пробы были отрицательными). Однако вы можете проводить испытания не чаще одного раза в день, а для получения
//        результата с момента проведения проходит семь дней. Как найти отравленную бутылку за минимальное количество дней?
//        Напишите программную модель вашего решения.
public class Test {

    public static String padLeft(int number, int n) {
        return String.format("%" + n + "s", Integer.toBinaryString(number)).replace(" ", "0");
    }

    static List<Integer> getColoredStripes(){
        int numberOfStripes = 10;
        List<Integer> coloredStripes = new ArrayList<>(numberOfStripes);

        System.out.println("Прошло 7 дней");

        int sum = 0;

        for (int i = 0; i < numberOfStripes; i++){
            if(Math.random() * 10 > 5 && sum < 38){
                coloredStripes.add(i);
                sum += i;
            }
        }
        return coloredStripes;
    }

    static int findPoisonedBottle(List<Integer> coloredStripes) {
        int result = 0;
        for(int i : coloredStripes) {
            int mask = 1 << i;
            result = result | mask;
            System.out.println("№ полоски: " + i + ", двоичный флаг: " + padLeft(mask, 10));
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> coloredStripes = getColoredStripes();
        System.out.println("Окрашенные тестовые полоски: " + coloredStripes);
        int foundPoisonedBottle = findPoisonedBottle(coloredStripes);
        System.out.println("Отравленная бутылка - №" + foundPoisonedBottle + " = " + padLeft(foundPoisonedBottle, 10));
    }
}

