class test
{

public static void func(int[] array){

	array[4]=0;

}

public static void main(String[] args){

            int[] array={1,3,1,4,2,5};
         	System.out.println(array[4]);
         	func(array);	
         	System.out.print(array[4]);
    }

}