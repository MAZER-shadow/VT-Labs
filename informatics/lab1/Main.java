import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int [] fib = {1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711};
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.printf("Введите, что вы хотите сделать:\n 1)из Цекендорфа в десятичную\n 2)из десятичной в Цекендорфа\n 3)из десятичной в -10\n 4)из десятичной в симметичную\n");
            int j = sc.nextInt();
            switch (j) {
                case 1:
                    Scanner sc1 = new Scanner(System.in);
                    System.out.print("Введите ваше число для перевода:");
                    String num1 = sc1.nextLine();// принимаем число для перевода
                    String[] num2 = num1.split("");// делаем из этого числа список состоящий из каждой отдельной цифры принятой за строку
                    int sum = 0;
                    int y = 0;
                    Integer count = 0;
                    for (int i = num2.length - 1; i >= 0; i--) {// i показывает какой число в посл. фибоначи взять, y показывает индекс числа, которе мы берём из изначального
                        count = Integer.parseInt(num2[y]);// превращаем каждую отдельную цифру в целое число
                        sum += count * fib[i];// умножаем нашу цифру на соотвествующее ей число в последовательности фибоначи и плюсуем
                        y++;
                    }
                    System.out.println(num1 + " в системе счисления Цекендорфа = " + sum + " в десятичной системе счисления");// вывод
                    break;
                case 2:
                    Scanner sc11 = new Scanner(System.in);
                    System.out.print("Введите ваше число для перевода:");
                    int num11 = sc11.nextInt();// ввод
                    int nache = num11;// для вывода делаю копию(так как буду изменять в последствии переменную с исходным числом
                    int y1 = 0;
                    StringBuilder str = new StringBuilder("");// будет нашим числом в СС цикендорфа
                    for (int i = fib.length - 1; i >= 0; i--) {//данный перебор ищет с какого числа в последовательности фибоначи нам начинать наш основной перебор
                        if (fib[i] > num11) {// если число фибоначи больше нашего, то не имеет смысла его брать, ищем то, которое меньше или равно нашему
                            y1++;//y1 будет обозначать индекс числа в последовательности фибоначи с которого мы будем начинать подбор
                        } else {
                            break;
                        }
                    }
                    for (int yy = y1; yy >= 0; yy--) {// подбор
                        if (fib[yy] <= num11) {// если до нашего числа можно взять ещё число число фибоначи, тогда мы его берём(пишем 1 в число с СС цекендорфа, иначе пропускаем его(пишем 0 в число с СС цекендорфа)
                            str.append("1");
                            num11 -= fib[yy];// вычитаем из нашего числа число из посл. фибоначи для дальнеёшего подбора
                        } else {
                            str.append("0");
                        }
                    }
                    System.out.println(nache + " в десятичной системе счисления =  " + str + " в системе счисления Цекендорфа");// вывод
                    break;
                case 3:
                    Scanner sc111 = new Scanner(System.in);
                    System.out.print("Введите ваше число для перевода:");
                    int num111 = sc111.nextInt();// ввод
                    if (num111 > 0) {// проверяем меньше наше число 0 или больше для работы с знаком -
                        String num = String.valueOf(num111);// делаем исх число строкой
                        StringBuilder min = new StringBuilder("1");
                        StringBuilder max = new StringBuilder("9");
                        for (int i = 0; i < num.length() - 1; i++) {
                            min.append("0");
                        }// определяем минимальный порог перебора
                        for (int yyy = 0; yyy < (num.length() + 1); yyy++) {
                            max.append("9");
                        }
                        // определяем максимальный порог перебора
                        int min1 = Integer.parseInt(min.toString());//делаем наш минимальный порог целым числом
                        int max1 = Integer.parseInt(max.toString());//делаем наш максимальный порог целым числом
                        for (int i = min1; i <= max1; i++) {// перебор от мин возможного в -10 СС к максимльно возможному в -10 СС
                            String l1 = String.valueOf(i);// делаем число из перебора строкой
                            String[] l11 = l1.split("");// делаем число из перебора массивм из строчных элементов
                            int sum111 = 0;// эта сумма для перевода из -10 в 10 СС
                            for (int yy = 0; yy < l11.length; yy++) {// перевод из - 10 в 10 СС
                                sum111 += Integer.parseInt(l11[yy]) * Math.pow(-10, l11.length - (yy + 1));
                            }
                            if (sum111 == num111) {// если обратный перевод дал нам это же число: выводим его
                                System.out.println(num111 + " в десятичной системе счисления =  " + l1 + " в -10 CC");
                                break;
                            }
                        }
                    } else if (num111 < 0) {
                        String num = String.valueOf(num111);// делаем исх число строкой
                        StringBuilder min = new StringBuilder("1");
                        StringBuilder max = new StringBuilder("9");
                        for (int i = 0; i < num.length() - 2; i++) {
                            min.append("0");
                        }// определяем минимальный порог перебора
                        for (int i = 0; i < num.length(); i++) {
                            max.append("9");
                        }// определяем максимальный порог перебора
                        int min1 = Integer.parseInt(min.toString());//делаем наш минимальный порог целым числом
                        int max1 = Integer.parseInt(max.toString());//делаем наш максимальный порог целым числом
                        for (int i = min1; i <= max1; i++) {// перебор от мин возможного в -10 СС к максимльно возможному в -10 СС
                            String l1 = String.valueOf(i);// делаем число из перебора строкой
                            String[] l11 = l1.split("");// делаем число из перебора массивм из строчных элементов
                            int sum111 = 0;// эта сумма для перевода из -10 в 10 СС
                            for (int yy = 0; yy < l11.length; yy++) {// перевод из - 10 в 10 СС
                                sum111 += Integer.parseInt(l11[yy]) * Math.pow(-10, l11.length - (yy + 1));
                            }
                            if (sum111 == num111) {// если обратный перевод дал нам это же число: выводим его
                                System.out.println(num111 + " в десятичной системе счисления =  " + l1 + " в -10 CC");
                                break;
                            }
                        }


                    } else {
                        System.out.println("0 в десятичной равен 0 в -10");
                    }
                    break;
                case 4:
                    Scanner sc1111 = new Scanner(System.in);
                    System.out.println("Введите в какую именно симетричную систему вы хотите перевсти, например: 7 или 9 или 11:");
                    int num1111 = sc1111.nextInt();// ввод cc счисления
                    int[] kcc = new int[num1111];// создаём массив, в котором будет лежать алфавит нашей симетричной системы счисления
                    System.out.println("Введите число для перевода:");
                    int num11111 = sc1111.nextInt();// ввод числа в 10 сс
                    int numbers = num11111;//копия числа для вывода
                    int yyyy = 0;// показывает идексацию элементов в алфвавите при заполнении
                    for (int i = -num1111 / 2; i <= 0; i++) {// заполняем первую половину нашего алфваита + 0
                        kcc[yyyy] = i;
                        yyyy++;
                    }
                    for (int i = 1; i < kcc.length / 2 + 1; i++) {// заполняем вторую половину нашего алфваита
                        kcc[yyyy] = i;
                        yyyy++;
                    }
                    int ostatok1 = 0;//будем использовать для остатка
                    String hhh = "";//будем использовать для нашего числа в новой СС
                    if (num11111>0){//проверяем больше ли нуля нашего числа
                        while (num11111 > 0) {// перевод из 10 в Сим.
                            if (num11111 % num1111 <= kcc[kcc.length - 1]) {// если наш остаток от деления меньше последнего числа в алфавите, мы его берём
                                hhh = String.valueOf(num11111 % num1111) + hhh;// записываем этот остаток в начало числа
                                num11111 /= num1111;//присваем наше число целой части от деления
                            } else {
                                ostatok1 = num1111 - (num11111 % num1111);// если остаток не в нашем алфавите, то мы из мощности алфавита вычитаем наш остаток
                                hhh = "{-" + String.valueOf(ostatok1) + "}" + hhh;// получаем наш остаток и добавляем знак-(суть СС)
                                num11111 = (num11111 / num1111) + 1;// присваиваем наше число целой части+1 так, как была операция где мы вычитали из мощности
                            }
                        }
                    }else if (num11111 < 0){//проверяем меньше ли нуля нашего числа
                        String newnumber = String.valueOf(num11111);
                        String [] newnumbers = newnumber.split("");
                        String fornewnumber = "";
                        for (int i = 1; i < newnumbers.length; i++) {
                            fornewnumber += newnumbers[i];
                        }
                        num11111 = Integer.parseInt(fornewnumber);// тем что выше убираем знак - из числа для работы с ним, а далее программа таже, что и для > 0, но меняем знак - на +, а + на - в нужном числе
                        while (num11111 > 0) {// перевод из 10 в Сим.
                            if (0 < num11111 % num1111 && num11111 % num1111<= kcc[kcc.length - 1]) {
                                hhh = "{-"+String.valueOf(num11111 % num1111)+ "}" + hhh;
                                num11111 /= num1111;
                            } else if (num11111 % num1111==0) {
                                hhh = String.valueOf("0")+ hhh;
                                num11111 /= num1111;
                            } else {
                                ostatok1 = num1111 - (num11111 % num1111);
                                hhh = String.valueOf(ostatok1)+ hhh;
                                num11111 = (num11111 / num1111) + 1;
                            }
                        }
                    }else{//если был введён ноль, то выводить будем ноль
                        hhh = "0";
                    }
                    System.out.println(numbers + " в десятичной = " + hhh + " в системе С" + num1111);
                    break;
                default:
                    System.out.println("такого варианта нет((, но попробуйте ещё разок;)");
            }
        }
    }
}
