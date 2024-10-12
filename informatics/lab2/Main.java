import static java.lang.Math.pow;
import static java.lang.Math.abs;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        byte m = (byte)0;
        while (m==0) {
            Scanner sc = new Scanner(System.in);/* вводим число для проверки */
            System.out.print("Введите число из 7 0 или 1 для проверки сообщения на ошибку по классическому коду Хэмминга:");
            String [] k1 = sc.nextLine().split(""); // разбиваем наше число на список из одиночных символов
            if (k1.length != 7 || (k1[0].equals("0")==false && k1[0].equals("1")==false) || (k1[1].equals("0")==false && k1[1].equals("1")==false) || (k1[2].equals("0")==false && k1[2].equals("1")==false)|| (k1[3].equals("0")==false && k1[3].equals("1")==false)|| (k1[4].equals("0")==false && k1[4].equals("1")==false) || (k1[5].equals("0")==false && k1[5].equals("1")==false) || (k1[6].equals("0")==false && k1[6].equals("1")==false)) {
                if (k1.length!=7){
                    System.out.println("Длина неверна, попробуйте ещё раз");
                }else {
                    System.out.println("Ошибочный ввод символов! Попробуйте ещё раз");
                }
                continue;
            }
            m+=1;
            int s1 = Integer.parseInt(k1[0]) ^ Integer.parseInt(k1[2]) ^ Integer.parseInt(k1[4]) ^ Integer.parseInt(k1[6]);// первая контрольная сумма
            int s2 = Integer.parseInt(k1[1]) ^ Integer.parseInt(k1[2]) ^ Integer.parseInt(k1[5]) ^ Integer.parseInt(k1[6]);// вторая контрольная сумма
            int s3 = Integer.parseInt(k1[3]) ^ Integer.parseInt(k1[4]) ^ Integer.parseInt(k1[5]) ^ Integer.parseInt(k1[6]);// третья контрольная сумма
            String[] S = {String.valueOf(s1), String.valueOf(s2), String.valueOf(s3)};// собираем синдром
            if (S[0].equals("0") && S[1].equals("0") && S[2].equals("0")) {// проверка на безошибочный случай
                System.out.printf("Сообщение без ошибок: %s\nБита с ошибкой нет", (k1[2] + k1[4] + k1[5] + k1[6]));
            } else {
                String[] nameBit = {"r1", "r2", "i1", "r3", "i2", "i3", "r4"};
                byte l = (byte) 0;
                for (int i = 0; i < S.length; i++) {
                    l += Integer.parseInt(S[i]) * pow(2, i);//перевод из 2 в десятичную систему, но в обратном порядке (это будет наш ломаный бит по счёту)
                }
                k1[l - 1] = String.valueOf(abs(Integer.parseInt(k1[l - 1]) - 1));// вычисляем название нашего бита
                System.out.printf("Индекс бита с ошибкой %d\nБит отвечает за %s\nПравильное сообщение: %s", l, nameBit[l - 1], (k1[2] + k1[4] + k1[5] + k1[6]));//выводим
            }
        }
    }
}