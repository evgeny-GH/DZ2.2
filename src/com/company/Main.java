package com.company;
//test
public class Main {

    public static void main(String[] args) {
    
	// 1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4,
        // при подаче массива другого размера необходимо бросить исключение MyArraySizeException.
        //2. Далее метод должен пройтись по всем элементам массива, преобразовать в int,
        // и просуммировать. Если в каком-то элементе массива преобразование не удалось
        // (например, в ячейке лежит символ или текст вместо числа), должно быть брошено исключение
        // MyArrayDataException, с детализацией в какой именно ячейке лежат неверные данные.
        //3. В методе main() вызвать полученный метод,
        // обработать возможные исключения MySizeArrayException и MyArrayDataException, и вывести результат расчета.
    
        
            try {
                int result = method(myArrs);
                System.out.println(result);
            } catch (MyArraySizeException e) {
                System.out.println("Размер массива превышен");
            }
        
            catch (MyArrayDataException e){
                System.out.println("Неправильное значение массива");
                System.out.println("Ошибка в ячейке: Столбец: " + e.i + " Строка: " + e.j);
            }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    static String [][] myArrs = new String[][]{
            {"1","2","3","4"},
            {"5","6","7","8"},
            {"9","10","11","12"},
            {"13ААААА","14","15","16"}};
   
    

    private static int method(String[][] myArrs)throws MyArraySizeException, MyArrayDataException  {
        int count = 0;
        if (myArrs.length != 4) {
            throw new MyArraySizeException();
        }
        for (int i = 0; i < myArrs.length; i++) {
            if (myArrs[i].length != 4) {
                throw new MyArraySizeException();
            }
            for (int j = 0; j < myArrs[i].length; j++) {
                try {
                    count += Integer.parseInt(myArrs[i][j]);
                }
                catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        
        }
        return count;
    }

}


    
   
    
     
    

